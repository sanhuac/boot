package com.byc.merchants.merchants_cms.dao.car;

import com.byc.merchants.merchants_cms.model.car.CarTermModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/17 12:45
 * @Description: 车辆分期方案
 */
public interface CarTermMapper {


    /**
     *@描述 插入分期方案
     *@参数
     *@返回值
     *@创建人  胡丛
     *@创建时间  2018/9/17
     *@修改人和其它信息
     */
    @Insert("insert into mer_car_plan(car_id,down_pay,monthly_pay,term)values(#{car_id},#{down_pay},#{monthly_pay},#{term})")
    int insert(CarTermModel model);

    @Select("select car_id,down_pay,monthly_pay,term from mer_car_plan where plan_id = #{plan_id}")
    CarTermModel selectById(Integer plan_id);

    @Delete("delete from mer_car_plan where plan_id = #{plan_id}")
    int delete(Integer plan_id);
}
