package com.byc.merchants.merchants_cms.bean.apply;

/**
 * created by pht on 2018/9/17 0017
 */

import java.io.Serializable;

/**
 * 保险信息实体类
 *
 * @author pht
 * @program merchants_cms
 * @date 2018/9/17 0017
 */
public class MerInsuranceApply implements Serializable {

    private static final long serialVersionUID = -3202826533448193020L;

    //主键
    private Integer order_id;
    //商户id
    private Integer mer_id;
    //申请编号
    private String apply_no;
    //车牌
    private String car_plate;
    //预约用户id
    private Integer user_id;
    //用户名
    private String user_name;
    //用户手机号
    private String user_mobile;
    //身份证号码
    private String card_no;
    //投保地址
    private String address;
    //申请时间
    private Integer apply_time;

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getMer_id() {
        return mer_id;
    }

    public void setMer_id(Integer mer_id) {
        this.mer_id = mer_id;
    }

    public String getApply_no() {
        return apply_no;
    }

    public void setApply_no(String apply_no) {
        this.apply_no = apply_no;
    }

    public String getCar_plate() {
        return car_plate;
    }

    public void setCar_plate(String car_plate) {
        this.car_plate = car_plate;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_mobile() {
        return user_mobile;
    }

    public void setUser_mobile(String user_mobile) {
        this.user_mobile = user_mobile;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getApply_time() {
        return apply_time;
    }

    public void setApply_time(Integer apply_time) {
        this.apply_time = apply_time;
    }


    @Override
    public String toString() {
        return "MerInsuranceApply{" +
                "order_id=" + order_id +
                ", mer_id=" + mer_id +
                ", apply_no='" + apply_no + '\'' +
                ", car_plate='" + car_plate + '\'' +
                ", user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_mobile='" + user_mobile + '\'' +
                ", card_no='" + card_no + '\'' +
                ", address='" + address + '\'' +
                ", apply_time=" + apply_time +
                '}';
    }
}
