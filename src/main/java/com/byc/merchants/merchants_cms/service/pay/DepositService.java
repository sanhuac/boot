package com.byc.merchants.merchants_cms.service.pay;

import com.byc.merchants.merchants_cms.model.pay.DepositLogModel;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/11 14:01
 * @Description: 定金接口
 */
public interface DepositService {


    /**
     *@描述 添加日志
     *@参数  DepositLogModel
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    int insertLog(DepositLogModel model);
}
