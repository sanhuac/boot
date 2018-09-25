package com.byc.merchants.merchants_cms.model.car;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/17 12:30
 * @Description:
 */
@ApiModel(value = "添加车辆图片所需参数",description = "添加车辆图片所需参数")
@Data
public class CarImageModel implements Serializable{

    @ApiModelProperty(value = "车辆id",name = "car_id",example = "1")
    private Integer car_id;

    @ApiModelProperty(value = "图片链接多个以逗号隔开",name = "image_url",example = "images/school/1534236090914.jpg,images/school/1534236090914.jpg")
    private String image_url;

    @ApiModelProperty(value = "图片id(修改的时候传)",name = "image_id",example = "0")
    private Integer image_id;

    @ApiModelProperty(value = "添加时间(不传)",name = "create_time",example = "0")
    private Integer create_time;
}
