package com.byc.merchants.merchants_cms.dao.car;

import com.byc.merchants.merchants_cms.model.car.CarImageModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/17 12:36
 * @Description:
 */
public interface CarImageMapper {


    /**
     *@描述 车辆图片入录
     *@参数  CarImageModel
     *@返回值
     *@创建人  胡丛
     *@创建时间  2018/9/17
     *@修改人和其它信息
     */
    @Insert("insert into mer_car_image(car_id,image_url,create_time)values(#{car_id},#{image_url},UNIX_TIMESTAMP())")
    int insert(CarImageModel model);


    /**
     *@描述 查询车辆图片
     *@参数 car_id
     *@返回值 List
     *@创建人  胡丛
     *@创建时间  2018/9/17
     *@修改人和其它信息
     */
    @Select("select image_id,image_url,create_time from mer_car_image where car_id = #{car_id}")
    List<CarImageModel> selectBycarId(Integer car_id);


    /**
     *@描述 修改车辆信图片
     *@参数   image_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/17
     *@修改人和其它信息
     */
    @Update("update mer_car_image set image_url = #{image_url} where image_id = #{image_id}")
    int updateImage(CarImageModel model);
}
