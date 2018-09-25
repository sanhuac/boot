package com.byc.merchants.merchants_cms.model.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/10 16:40
 * @Description:
 */
@ApiModel(value = "商户信息编辑所需参数",description = "商户信息编辑所需参数(修改哪个传哪个参数,其他的不传)")
@Data
public class UpdateMerModel implements Serializable{

    private Integer mer_id;

    @ApiModelProperty(value = "商铺logo",name = "store_logo",example = "images/school/1534236090914.jpg")
    private String store_logo;

    @ApiModelProperty(value = "商铺名字",name = "store_name",example = "大众4S店")
    private String store_name;

    @ApiModelProperty(value = "商铺简介",name = "store_introduction",example = "给您优质服务")
    private String store_introduction;

    @ApiModelProperty(value = "客服电话",name = "customer_photo",example = "0571-8888888")
    private String customer_photo;

    @ApiModelProperty(value = "商铺地址",name = "store_address",example = "浙江省杭州市下城区石桥路")
    private String store_address;

    @ApiModelProperty(value = "省编码",name = "province_code",example = "330000")
    private String province_code;

    @ApiModelProperty(value = "市编码",name = "city_code",example = "330100")
    private String city_code;

    @ApiModelProperty(value = "区编码",name = "area_code",example = "330103")
    private String area_code;

    @ApiModelProperty(value = "纬度",name = "lat",example = "23.000000")
    private String lat;

    @ApiModelProperty(value = "经度",name = "lng",example = "126.000000")
    private String lng;

    @ApiModelProperty(value = "销售品牌",name = "sale_brands",example = "奥迪")
    private String sale_brands;

    @ApiModelProperty(value = "优惠信息标签",name = "favor_label",example = "优惠20元")
    private String favor_label;

    @ApiModelProperty(value = "车信息标签",name = "notice_label",example = "价格稳定")
    private String notice_label;

    @ApiModelProperty(value = "店铺二维码",name = "store_ercode",example = "images/school/1534236090914.jpg")
    private String store_ercode;

    @ApiModelProperty(value = "店铺首页图(多张以引文逗号隔开)",name = "index_image",example = "images/school/1534236090914.jpg,images/school/1534236090914.jpg")
    private String index_image;
}
