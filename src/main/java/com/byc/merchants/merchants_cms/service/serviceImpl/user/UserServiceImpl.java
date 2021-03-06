package com.byc.merchants.merchants_cms.service.serviceImpl.user;

import com.alibaba.fastjson.JSONObject;
import com.byc.merchants.merchants_cms.bean.sms.Sms;
import com.byc.merchants.merchants_cms.bean.user.User;
import com.byc.merchants.merchants_cms.constant.Constant;
import com.byc.merchants.merchants_cms.constant.UserConstant;
import com.byc.merchants.merchants_cms.dao.image.StoreImageMapper;
import com.byc.merchants.merchants_cms.dao.store.AccountMapper;
import com.byc.merchants.merchants_cms.dao.user.UserMapper;
import com.byc.merchants.merchants_cms.dao.sms.SmsMapper;
import com.byc.merchants.merchants_cms.enums.MessageTypeEnum;
import com.byc.merchants.merchants_cms.exception.UnifiedException;
import com.byc.merchants.merchants_cms.model.image.StoreImageModel;
import com.byc.merchants.merchants_cms.model.register.MerchantsIn;
import com.byc.merchants.merchants_cms.model.user.LoginLog;
import com.byc.merchants.merchants_cms.model.user.UserModel;
import com.byc.merchants.merchants_cms.model.login.LoginModel;
import com.byc.merchants.merchants_cms.model.login.LoginToken;
import com.byc.merchants.merchants_cms.model.register.RegisterModel;
import com.byc.merchants.merchants_cms.redis.RedisKeyPrefix;
import com.byc.merchants.merchants_cms.service.user.UserService;
import com.byc.merchants.merchants_cms.service.redis.RedisService;
import com.byc.merchants.merchants_cms.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/5 12:23
 * @Description: 商户业务层
 */
@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDao;

    @Autowired
    private RedisService redisService;

    @Autowired
    private SmsMapper smsDao;

    @Autowired
    private StoreImageMapper storeImageDao;
    @Autowired
    private AccountMapper accountMapper;

    /**
     * @描述 根据商户id查询商户
     * @参数 mer_id
     * @返回值 UserModel
     * @创建人 胡丛
     * @创建时间 2018/9/5
     * @修改人和其它信息
     */
    public UserModel selectUserById(Integer mer_id) {
        UserModel userModel = userDao.selectUserById(mer_id);
        return userModel;
    }

    /**
     * 商户登录
     *
     * @param request
     * @param mer_mobile 手机号
     * @param password   密码
     * @param ip
     * @param longitude
     * @param latitude
     * @return
     */
    @Override
    public Map<String, Object> login(HttpServletRequest request, String mer_mobile, String password, String ip, String longitude, String latitude) throws UnifiedException {
        //参数校验
        if (!ValidatorUtils.isLoginMobile(mer_mobile)) {
            throw new UnifiedException(200001);
        }
        //密码校验
//        password = UserUtils.checkPassword(password);
        //根据手机号查询
        LoginModel model = userDao.selectMerByMerMobile(mer_mobile);
        if (ValidatorUtils.isNull(model)) {
            throw new UnifiedException(200008);
        }
        //判断当前店铺是否开通
        int store_status = 1;
        if (UserConstant.MER_STATUS_NO == model.getMer_status()) {
            store_status = 0;
        }
        //密码加密对比校验
        // TODO: 2018/9/25 0025
//        if (!model.getPassword().equals(MD5.md5(password))) {
//            throw new UnifiedException(200010);
//        }

        //生成令牌信息
        //通行证(令牌)id
        String accessId = CommonUtils.getRandom(model.getMer_mobile());
        //登陆时间
        int loginTime = Integer.parseInt(TimeUtils.getCurrentTimeStamp() + "");
        //存贮登录信息
        addToken(accessId, model.getMer_id(), loginTime);
        //添加登录日志
        addLoginLog(model, loginTime, ip, longitude, latitude);
        //登录完成,看前端设计需要什么参数,到时候再返回
        // TODO: 2018/9/10 0010
        Integer store_type = userDao.selectStoreType(mer_mobile);
        Map<String, Object> map = new HashMap<>();
        map.put("mer_name", model.getMer_name());
        map.put("mer_id", model.getMer_id());
        map.put("accessId", accessId);
        map.put("store_type", store_type);
        map.put("store_status", store_status);
        return map;
    }

    /**
     * 添加登录日志
     *
     * @param model
     * @param loginTime
     * @param ip
     * @param longitude 经度
     * @param latitude  纬度
     */
    private void addLoginLog(LoginModel model, int loginTime, String ip, String longitude, String latitude) {
        LoginLog loginLog = new LoginLog();
        loginLog.setLogin_ip(ip);
        loginLog.setLogin_time(loginTime);
        loginLog.setMer_id(model.getMer_id());
        loginLog.setMer_mobile(model.getMer_mobile());
        loginLog.setLongitude(ValidatorUtils.isNull(longitude) ? "" : longitude);
        loginLog.setLatitude(ValidatorUtils.isNull(latitude) ? "" : latitude);
        //获取地区编码
        try {
            loginLog.setLogin_area_code(AddressUtils.getAddresses("ip=" + ip));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //添加日志
        userDao.addLoginLog(loginLog);
    }

    /**
     * 添加token
     *
     * @param accessId
     * @param mer_id
     * @param loginTime
     */
    private void addToken(String accessId, Integer mer_id, int loginTime) throws UnifiedException {
        //先登出
        logout(mer_id);
        //重新封装token数据
        LoginToken token = new LoginToken();
        token.setAccess_id(accessId);
        token.setMer_id(mer_id);
        token.setLogin_time(loginTime);
        token.setLast_action_time(Integer.parseInt(TimeUtils.getCurrentTimeStamp() + ""));
        token.setExpire_time(loginTime + 30 * 60);
        //存入数据库
        int i = userDao.addLoginToken(token);
        if (i != 1) {
            throw new UnifiedException(200011);
        }
        //添加到redis队列中，并设置过期时间
        Map<String, Object> tokenMap = new LinkedHashMap<>();
        tokenMap.put("access_id", accessId);
        tokenMap.put("mer_id", mer_id);
        tokenMap.put("login_time", loginTime);
        tokenMap.put("last_action_time", token.getLast_action_time());
        //设置过期时间
        redisService.set(RedisKeyPrefix.MER_TOKEN_PREFIX + accessId, CommonUtils.encodeUserToken(new JSONObject(tokenMap).toString()), 30 * 60);
    }

    /**
     * 登出
     *
     * @param mer_id
     */
    private void logout(Integer mer_id) {
        //查询数据库
        LoginToken token = userDao.selectUserTokenByMerId(mer_id);
        if (!ValidatorUtils.isNull(token)) {
            //清除redis
            redisService.deleteKey(RedisKeyPrefix.MER_TOKEN_PREFIX + token.getAccess_id());
            //删除数据库
            userDao.deleteUserTokenByMerId(mer_id);
        }
    }


    /**
     * @描述 商户注册
     * @参数 RegisterModel
     * @返回值 int
     * @创建人 胡丛
     * @创建时间 2018/9/10
     * @修改人和其它信息
     */
    public int register(RegisterModel model) throws UnifiedException {
        //校验该号码是否注册过
        int num = userDao.selectNumByMobile(model.getMer_mobile());
        if (num > 0) {
            throw new UnifiedException(200005);
        }
        //校验手机号格式和非空
        if (ValidatorUtils.isEmpty(model.getMer_mobile())) {
            throw new UnifiedException(200004);
        }
        if (!ValidatorUtils.isLoginMobile(model.getMer_mobile())) {
            throw new UnifiedException(200001);
        }
        System.out.println(model.getPassword() + ":" + Constant.DESKEY);
        //密码解密
//        try {
//            model.setPassword(DesUtils.decrypt(model.getPassword(), Constant.DESKEY));
//        } catch (Exception e) {
//            throw new UnifiedException(200003);
//        }
        //检验密码格式
//        if (!ValidatorUtils.isPassword(model.getPassword())) {
//            throw new UnifiedException(200007);
//        }
        //更新验证码
        Sms code = new Sms();
        code.setSmsCode(model.getCode());
        code.setUserMobile(model.getMer_mobile());
        code.setSmsStatus(UserConstant.SMS_STATUS_UNUSE);
        code.setSmsType(MessageTypeEnum.REGISTER.KEY);
        int count = smsDao.findCountBySpecificCondition(code);
        if (count < 1) {
            throw new UnifiedException(200012);
        }
        int result = smsDao.updateUsedBySpecificCondition(UserConstant.SMS_STATUS_USED,
                code.getSmsCode(), code.getUserMobile(), UserConstant.SMS_STATUS_UNUSE, MessageTypeEnum.REGISTER.KEY);
        if (result != 1) {
            throw new UnifiedException(200012);
        }
        //生成用户信息
        User user = new User();
        user.setMerMobile(model.getMer_mobile());
//        user.setPassword(CommonUtils.encodeLoginPwd(model.getPassword()));
        user.setPassword(model.getPassword());
        int register = userDao.register(user);
        if (register != 1) {
            throw new UnifiedException(200013);
        }
        log.info("注册返回商户主键:" + user.getMerId());
        return user.getMerId();
    }

    /**
     * @描述 商户入驻开店
     * @参数 MerchantsIn
     * @返回值 MerchantsIn
     * @创建人 胡丛
     * @创建时间 2018/9/10
     * @修改人和其它信息
     */
    @Transactional(rollbackFor = Exception.class)
    public MerchantsIn merchantsIn(MerchantsIn merchantsIn) throws UnifiedException {
        //非空检验
        if (ValidatorUtils.isEmpty(merchantsIn.getStore_name())) {
            throw new UnifiedException(200015);
        }
        if (ValidatorUtils.isEmpty(merchantsIn.getMer_name())) {
            throw new UnifiedException(200016);
        }
        if (ValidatorUtils.isEmpty(merchantsIn.getCustomer_photo())) {
            throw new UnifiedException(200019);
        }
        if (ValidatorUtils.isEmpty(merchantsIn.getCard_face())) {
            throw new UnifiedException(200017);
        }
        if (ValidatorUtils.isEmpty(merchantsIn.getCard_side())) {
            throw new UnifiedException(200018);
        }
        if (ValidatorUtils.isEmpty(merchantsIn.getBusiness_license())) {
            throw new UnifiedException(200020);
        }
        if (ValidatorUtils.isEmpty(merchantsIn.getCommitment_book())) {
            throw new UnifiedException(200021);
        }
        int i = userDao.merchantsIn(merchantsIn);
        if (i != 1) {
            throw new UnifiedException(200022);
        }
        /**
         * 生成商户账户
         */
        int count = accountMapper.insertMerAccount(merchantsIn.getMer_id());
        if (count != 1) {
            throw new UnifiedException(200022);
        }

        MerchantsIn result = userDao.selectMerById(merchantsIn.getMer_id());
        if (result == null) {
            throw new UnifiedException(200023);
        }
        return result;
    }

    @Override
    public LoginToken selectToken(String accessToken) {
        //从redis中取值
        String token = redisService.getStr(RedisKeyPrefix.MER_TOKEN_PREFIX + accessToken);
        if (ValidatorUtils.isNull(token)) {
            return null;
        }

        //从数据库取
        LoginToken loginToken = userDao.selectUserTokenByAccessId(accessToken);

        return loginToken;
    }

    /**
     * @描述 商户完善信息
     * @参数 mer_id
     * @返回值 UserModel
     * @创建人 胡丛
     * @创建时间 2018/9/10
     * @修改人和其它信息
     */
    public UserModel selectStoreById(Integer mer_id) {
        UserModel userModel = userDao.selectStoreById(mer_id);
        List<StoreImageModel> storeImageModels = storeImageDao.selectStoreIndexImsge(mer_id);
        userModel.setIndexImages(storeImageModels);
        return userModel;
    }


    /**
     * 重置密码
     *
     * @param mer_mobile
     * @param password
     * @param validCode
     */
    @Override
    @Transactional
    public void forgetPassword(String mer_mobile, String password, String validCode) throws UnifiedException {
        //校验参数
        //校验手机号
        if (!ValidatorUtils.isLoginMobile(mer_mobile)) {
            //手机号格式
            throw new UnifiedException(200001);
        }
        //是否手机号注册了
        LoginModel loginModel = userDao.selectMerByMerMobile(mer_mobile);
        if (ValidatorUtils.isNull(loginModel) || ValidatorUtils.isNull(loginModel.getMer_id())) {
            throw new UnifiedException(200024);
        }
        //判断当前商户是否开通
//        if (UserConstant.MER_STATUS_NO == loginModel.getMer_status()) {
//            throw new UnifiedException(200009);
//        }

        //校验密码
        if (ValidatorUtils.isNull(password)) {
            throw new UnifiedException(200002);
        }
        //密码解密
        try {
            password = DesUtils.decrypt(password, Constant.DESKEY);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UnifiedException(200003);
        }

        //校验密码长度
        if (password.length() < 6 || password.length() > 20) {
            throw new UnifiedException(200007);
        }

        //校验验证码

        //验证码处理
        Sms code = new Sms();
        code.setSmsCode(validCode);
        code.setUserMobile(mer_mobile);
        code.setSmsType(MessageTypeEnum.FORGET_PASSWORD.KEY);
        code.setSmsStatus(UserConstant.SMS_STATUS_UNUSE);
        int count = smsDao.findCountBySpecificCondition(code);
        if (count < 1) {
            //验证码失效了
            throw new UnifiedException(200025);
        }

        //验证更新为已使用
        int result = smsDao.updateUsedBySpecificCondition(UserConstant.SMS_STATUS_USED,
                validCode, mer_mobile, UserConstant.SMS_STATUS_UNUSE, MessageTypeEnum.FORGET_PASSWORD.KEY);
        if (result != 1) {
            throw new UnifiedException(200025);
        }


        //更新用户密码
        //密码加密后存入
        password = MD5.md5(password);
        int update = userDao.updatePasswordById(loginModel.getMer_id(), password);
        if (update < 1) {
            throw new UnifiedException(200026);
        }
    }
}
