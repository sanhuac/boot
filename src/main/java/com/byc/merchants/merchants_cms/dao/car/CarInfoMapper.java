package com.byc.merchants.merchants_cms.dao.car;

import com.byc.merchants.merchants_cms.model.car.CarInfoModel;
import com.byc.merchants.merchants_cms.model.car.CarInfoTwoModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/12 17:24
 * @Description:
 */
public interface CarInfoMapper {


    /**
     *@描述 初步保存车辆信息
     *@参数 CarInfoModel
     *@返回值 int
     *@创建人  胡丛
     *@创建时间  2018/9/12
     *@修改人和其它信息
     */
    @Insert("insert into mer_car_info(mer_id,car_name,slogan,publish_type,discounted_prices,car_brand,service_description,guide_price,car_type," +
            "car_model,car_color,deposit_status,deposit_price,remark,title_main,title_sub,coupons_status,car_point,recomment_status)" +
            "values(#{mer_id},#{car_name},#{slogan},#{publish_type},#{discounted_prices},#{car_brand},#{service_description},#{guide_price},#{car_type}," +
            "#{car_model},#{car_color},#{deposit_status},#{deposit_price},#{remark},#{title_main},#{title_sub},#{coupons_status},#{car_point},#{recomment_status})")
    int firstSave(CarInfoModel model);



    /**
     *@描述 完善车辆信息
     *@参数  CarInfoTwoModel
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/17
     *@修改人和其它信息
     */
    @Update("update mer_car_info set basic_information = #{basic_information},basic_performance = #{basic_performance},car_show = #{car_show} where car_id = #{car_id}")
    int updateSencod(CarInfoTwoModel model);
}
