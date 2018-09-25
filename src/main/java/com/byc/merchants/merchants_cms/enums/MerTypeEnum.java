package com.byc.merchants.merchants_cms.enums;

/**
 * created by pht on 2018/9/17 0017
 */

/**
 * 店铺类型枚举
 */
public enum MerTypeEnum {

    MER_4S(0, "4S店"),
    MER_SECOND(1, "二手车行"),
    MER_INSURANCE(2, "保险店"),
    MER_MORTGAGE(3, "按揭店");


    public int KEY;
    public String REMARK;

    MerTypeEnum(int key, String remark) {
        this.KEY = key;
        this.REMARK = remark;
    }
}
