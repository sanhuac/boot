package com.byc.merchants.merchants_cms.util;

import com.byc.merchants.merchants_cms.dao.store.AccountMapper;
import com.byc.merchants.merchants_cms.redis.enums.RedisKeyEnum;
import com.byc.merchants.merchants_cms.service.redis.RedisService;
import com.byc.merchants.merchants_cms.springboot.SpringContext;

/**
 * 随机数生成工具类
 *
 * @author lgh
 */
public class RecordNoUtil {

    //	private final static Logger LOGGER = LoggerFactory.getLogger(RecordNoUtil.class);
    private static final RedisService REDIS_SERVICE = SpringContext.getBean(RedisService.class);

    /**
     * 生成资金日志16位唯一订单号
     *
     * @return
     */
    public static String generateOrderNo() {
        //生成订单号
        String orderNo = RecordNoUtil.get16();
        //校验订单号唯一性
        AccountMapper accountMapper = SpringContext.getBean(AccountMapper.class);
        int count = accountMapper.selectLogNumberByRequestNo(orderNo);
        if (count != 0) {
            orderNo = generateOrderNo();
        }
        return orderNo;
    }

    /**
     * 11位随机数生成
     *
     * @return
     */
    public static String get11() {
        return get11Random(RedisKeyEnum.RANDOM_11);
    }

    /**
     * 16位随机数生成
     *
     * @return
     */
    public static String get16() {
        return get16Random(RedisKeyEnum.RANDOM_16);
    }

    /**
     * 30位随机数生成
     *
     * @return
     */
    public static String get30() {
        return get30Random(RedisKeyEnum.RANDOM_30);
    }

    public static String getRandomCode() {
        String recordNo = get16();
        StringBuffer sBuffer = new StringBuffer();
        int t = 0;
        String r = "";
        for (int i = 0; i < recordNo.length(); i = i + 2) {
            t = Integer.parseInt(recordNo.substring(i, i + 2));
            r = getChar(t);
            sBuffer.append(r);
        }
        return sBuffer.toString();
    }

    private static String getChar(int t) {
        String r = "";
        if (t >= 0 && t <= 25) {
            r = (char) (t + 65) + "";
            if ("O".equals(r)) {
                r = "A";
            } else if ("I".equals(r)) {
                r = "L";
            }
        } else {
            t = t % 9;
            if (t == 0) {
                r = "A";
            } else {
                r = t + "";
            }
        }
        return r;
    }

    public static String get30Random(RedisKeyEnum enums) {
        String recordNo = TimeUtils.getSysTime("yyyyMMddhhmmssSSS");
        String random = null;
        Long nums = REDIS_SERVICE.ssize(enums.KEY);
        if (nums < 100) {
            for (int i = 0; i < 1000; i++) {
                REDIS_SERVICE.sadd(enums.KEY, (int) (Math.random() * 9000 + 1000) + "");
            }
        }
        random = String.valueOf(REDIS_SERVICE.spop(enums.KEY));
        return recordNo + "000000000" + random;
    }


    public static String get16Random(RedisKeyEnum enums) {
        String recordNo = TimeUtils.getSysTimeLong().substring(2);
        String random = null;
        Long nums = REDIS_SERVICE.ssize(enums.KEY);
        if (nums < 100) {
            for (int i = 0; i < 1000; i++) {
                REDIS_SERVICE.sadd(enums.KEY, (int) (Math.random() * 9000 + 1000) + "");
            }
        }
        random = String.valueOf(REDIS_SERVICE.spop(enums.KEY));
        return recordNo + random;
    }

    public static String get11Random(RedisKeyEnum enums) {
        String recordNo = String.valueOf(System.currentTimeMillis()).substring(6);
        String random = null;
        Long nums = REDIS_SERVICE.ssize(enums.KEY);
        if (nums < 100) {
            for (int i = 0; i < 1000; i++) {
                REDIS_SERVICE.sadd(enums.KEY, (int) (Math.random() * 9000 + 1000) + "");
            }
        }
        random = String.valueOf(REDIS_SERVICE.spop(enums.KEY));
        return recordNo + random;
    }

}
