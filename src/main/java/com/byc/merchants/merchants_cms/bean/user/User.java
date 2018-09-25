package com.byc.merchants.merchants_cms.bean.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/5 10:49
 * @Description: 商户实体类
 */
@Data
public class User implements Serializable{

    /**
     * 商户id
     */
    private Integer merId;

    /**
     * 商户用户名字
     */
    private String merMobile;

    /**
     * 商户登录密码
     */
    private String password;

    /**
     * 商户法人姓名
     */
    private String merName;

    /**
     * 商店名字
     */
    private String store_name;

    /**
     * 门店类型[0:4s店   1:车行]
     */
    private Integer store_type;

    /**
     * 身份证正面照
     */
    private String card_face;

    /**
     * 身份证反面照
     */
    private String card_side;

    /**
     * 营业执照
     */
    private String businessLicense;

    /**
     * 承若书
     */
    private String commitment_book;

    /**
     * 店铺logo
     */
    private String storeLogo;

    /**
     * 店铺简介
     */
    private String storeIntroduction;

    /**
     *客服电话
     */
    private String customerPhoto;

    /**
     * 销售品牌
     */
    private String saleBrands;

    /**
     * 店铺二维码
     */
    private String storeErcode;

    /**
     * 商户状态[0:开通   1:未开通]
     */
    private Integer merStatus;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 经度
     */
    private String lng;

    /**
     * 省编码
     */
    private String provinceCode;

    /**
     * 市编码
     */
    private String cityCode;

    /**
     * 区编码
     */
    private String areaCode;

    /**
     * 车信息标签
     */
    private String noticeLabel;

    /**
     *优惠信息标签
     */
    private String favorLabel;

    /**
     * 商户注册时间
     */
    private Integer createTime;

}
