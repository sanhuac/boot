package com.byc.merchants.merchants_cms.model.car;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/12 16:26
 * @Description:
 */
@ApiModel(value = "添加车辆信息所需参数", description = "添加车辆信息所需参数")
@Data
public class CarInfoModel implements Serializable {

    @ApiModelProperty(value = "商户id（不用传）", name = "mer_id", example = "0")
    private Integer mer_id;

    @ApiModelProperty(value = "车辆名称", name = "car_name", example = "大众奔腾")
    private String car_name;

    @ApiModelProperty(value = "车辆宣传语", name = "slogan", example = "奔腾你值得拥有")
    private String slogan;

    @ApiModelProperty(value = "发布类型[0:常规  1:新车  2:降价  3:团购 4:热销]", name = "publish_type", example = "0")
    private Integer publish_type;

    @ApiModelProperty(value = "降价数额", name = "discounted_prices", example = "99.99")
    private BigDecimal discounted_prices;

    @ApiModelProperty(value = "品牌", name = "car_brand", example = "大众")
    private String car_brand;

    @ApiModelProperty(value = "服务说明[以英文逗号隔开]", name = "service_description", example = "超低首付,方案灵活")
    private String service_description;

    @ApiModelProperty(value = "指导价", name = "guide_price", example = "13.56")
    private BigDecimal guide_price;

    @ApiModelProperty(value = "车类型[微型车 SUV 中型车]", name = "car_type", example = "SUV")
    private String car_type;

    @ApiModelProperty(value = "车型号", name = "car_model", example = "2018款 28T 两驱技术,2019款 38T 两驱技术")
    private String car_model;

    @ApiModelProperty(value = "车颜色", name = "car_color", example = "红色,白色,黑色")
    private String car_color;

    @ApiModelProperty(value = "定金状态[0:不用定金  1:要定金]", name = "deposit_status", example = "1")
    private Integer deposit_status;

    @ApiModelProperty(value = "定金金额", name = "deposit_price", example = "200.00")
    private BigDecimal deposit_price;

    @ApiModelProperty(value = "车辆备注", name = "remark", example = "车辆verygood")
    private String remark;

    @ApiModelProperty(value = "主标题", name = "title_main", example = "大众好")
    private String title_main;

    @ApiModelProperty(value = "副标题", name = "title_sub", example = "大众妙")
    private String title_sub;

    @ApiModelProperty(value = "优惠券使用状态[0:不使用   1:使用]", name = "coupons_status", example = "0")
    private Integer coupons_status;

    @ApiModelProperty(value = "提车点", name = "car_point", example = "杭州市下城区石桥路729号")
    private String car_point;

    @ApiModelProperty(value = "推荐首页[0:不推荐  1:推荐]", name = "recomment_status", example = "1")
    private Integer recomment_status;

    /**
     * 基本信息
     */
    @ApiModelProperty(hidden = true)
    private String basic_information;

    /**
     * 基本性能
     */
    @ApiModelProperty(hidden = true)
    private String basic_performance;

    /**
     * 购车说明
     */
    @ApiModelProperty(hidden = true)
    private String car_show;
    /**
     * 车辆实拍id
     */
    @ApiModelProperty(hidden = true)
    private Integer car_film_id;


}
