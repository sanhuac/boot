package com.byc.merchants.merchants_cms.dao.pay;

import com.byc.merchants.merchants_cms.model.pay.DepositLogModel;
import org.apache.ibatis.annotations.Insert;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/11 14:04
 * @Description: 定金
 */
public interface DepositMapper {


    /**
     *@描述 添加日志
     *@参数  DepositLogModel
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    @Insert("insert into mer_deposit_log(mer_id,pay_type,pay_money,create_time)values(#{mer_id},#{pay_type},#{pay_money},UNIX_TIMESTAMP())")
    int insertLog(DepositLogModel model);
}
