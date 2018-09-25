package com.byc.merchants.merchants_cms.bean.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/7 16:24
 * @Description:
 */
@Data
public class Area implements Serializable{

    /**
     * 地区编号
     */
    private String area_no;

    /**
     * 当前名称
     */
    private String area_name;
}
