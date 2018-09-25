package com.byc.merchants.merchants_cms.dao.car;

import com.byc.merchants.merchants_cms.model.car.CarFilm;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/17 15:42
 * @Description:
 */
public interface CarFilmMapper {


    @Insert("insert into mer_car_film(car_id,film_title,film_content,film_image,create_time)values(#{car_id},#{film_title},#{film_content},#{film_image},UNIX_TIMESTAMP())")
    int insert(CarFilm model);


    @Select("select film_title,film_content,film_image,create_time from mer_car_film where car_id = #{car_id}")
    CarFilm selectBycarId(Integer car_id);

    @Update("update mer_car_film set film_title = #{film_title},film_content = #{film_content},film_image = #{film_image} where car_id = #{car_id}")
    int updateByCarId(CarFilm model);
}
