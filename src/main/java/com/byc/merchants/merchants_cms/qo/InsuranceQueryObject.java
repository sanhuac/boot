package com.byc.merchants.merchants_cms.qo;

/**
 * created by pht on 2018/9/17 0017
 */

import java.io.Serializable;

/**
 * 保险列表高级查询对象
 *
 * @author pht
 * @program merchants_cms
 * @date 2018/9/17 0017
 */
public class InsuranceQueryObject extends QueryObject implements Serializable {

    private static final long serialVersionUID = -3026683384147468004L;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 预约地址
     */
    private String address;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "InsuranceQueryObject{" +
                "userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
