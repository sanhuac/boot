package com.byc.merchants.merchants_cms.model.car;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/17 14:23
 * @Description:
 */
@ApiModel(value = "完善车辆信息所需参数",description = "完善车辆信息所需参数")
@Data
public class CarSecondModel implements Serializable{

    @ApiModelProperty(value = "车辆id",name = "car_id",example = "1")
    private Integer car_id;

    @ApiModelProperty(value = "分期方案",name = "terms",example = "5000、500、24,5000、500、24")
    private String terms;

    @ApiModelProperty(value = "车辆图片",name = "car_images",example = "images/school/1534236090914.jpg,images/school/1534236090914.jpg")
    private String car_images;

    @ApiModelProperty(value = "车辆基本信息",name = "basic_information",example = "1000万元,100L/20km")
    private String basic_information;

    @ApiModelProperty(value = "车辆基本性能",name = "basic_performance",example = "100L/20km,100L/20km")
    private String basic_performance;

    @ApiModelProperty(value = "购车说明",name = "car_show",example = "这个车就是好")
    private String car_show;

    @ApiModelProperty(value = "购车实拍标题",name = "film_title",example = "好")
    private String film_title;

    @ApiModelProperty(value = "购车实拍内容",name = "film_content",example = "就是好")
    private String film_content;

    @ApiModelProperty(value = "购车实拍图片",name = "film_image",example = ".data")
    private String film_image;


}
