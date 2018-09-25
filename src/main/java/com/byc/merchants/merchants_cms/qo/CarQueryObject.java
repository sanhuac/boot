package com.byc.merchants.merchants_cms.qo;

/**
 * created by pht on 2018/9/18 0018
 */

import java.io.Serializable;

/**
 * 4s点产品列表高级查询对象
 *
 * @author pht
 * @program merchants_cms
 * @date 2018/9/18 0018
 */
public class CarQueryObject extends QueryObject implements Serializable {

    private static final long serialVersionUID = 5235874069453415057L;

    //品牌名
    private String brandName;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "CarQueryObject{" +
                "brandName='" + brandName + '\'' +
                '}';
    }
}
