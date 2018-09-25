package com.byc.merchants.merchants_cms.bean.product;

/**
 * created by pht on 2018/9/18 0018
 */

import java.io.Serializable;

/**
 * 车辆列表实体类
 *
 * @author pht
 * @program merchants_cms
 * @date 2018/9/18 0018
 */
public class CarInfo implements Serializable {

    private static final long serialVersionUID = 2989044841715851138L;
    // '车辆id',
    private Integer car_id;
    //'商户id',
    private Integer mer_id;
    //'车辆名称',
    private String car_name;
    //'指导价(单位:万元)',
    private Double guide_price;
    //上架状态[0:上架  1:下架]',
    private Integer shelves_status;
    //'首页展示图',
    private String index_image;
    // '销量',
    private Integer sales_volume;


    public Integer getCar_id() {
        return car_id;
    }

    public void setCar_id(Integer car_id) {
        this.car_id = car_id;
    }

    public Integer getMer_id() {
        return mer_id;
    }

    public void setMer_id(Integer mer_id) {
        this.mer_id = mer_id;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public Double getGuide_price() {
        return guide_price;
    }

    public void setGuide_price(Double guide_price) {
        this.guide_price = guide_price;
    }

    public Integer getShelves_status() {
        return shelves_status;
    }

    public void setShelves_status(Integer shelves_status) {
        this.shelves_status = shelves_status;
    }

    public String getIndex_image() {
        return index_image;
    }

    public void setIndex_image(String index_image) {
        this.index_image = index_image;
    }

    public Integer getSales_volume() {
        return sales_volume;
    }

    public void setSales_volume(Integer sales_volume) {
        this.sales_volume = sales_volume;
    }

    @Override
    public String toString() {
        return "CarInfo{" +
                "car_id=" + car_id +
                ", mer_id=" + mer_id +
                ", car_name='" + car_name + '\'' +
                ", guide_price=" + guide_price +
                ", shelves_status=" + shelves_status +
                ", index_image='" + index_image + '\'' +
                ", sales_volume=" + sales_volume +
                '}';
    }
}
