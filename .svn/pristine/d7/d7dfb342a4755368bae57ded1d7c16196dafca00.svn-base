package com.byc.merchants.merchants_cms.service.serviceImpl.pay;

import com.byc.merchants.merchants_cms.dao.pay.DepositMapper;
import com.byc.merchants.merchants_cms.model.pay.DepositLogModel;
import com.byc.merchants.merchants_cms.service.pay.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/11 14:03
 * @Description:
 */
@Service("depositService")
public class DepositServiceImpl implements DepositService{


    @Autowired
    private DepositMapper depositDao;

    /**
     *@描述 添加日志
     *@参数  DepositLogModel
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
     public int insertLog(DepositLogModel model){
         int i = depositDao.insertLog(model);
         return i;
     }
}
