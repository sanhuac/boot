package com.byc.merchants.merchants_cms.constant;

/**
 * created by pht on 2018/9/7 0007
 */

/**
 * @program merchants_cms
 * @date 2018/9/7 0007
 * @author pht
 */
public class UserConstant {

    //店铺状态
    //未开通
    public static final int MER_STATUS_NO = 1;
    //已开通
    public static final int MER_STATUS_SUCCESS = 0;
    //用户Token前缀
    public static final String TOKEN_MER_LOGIN_PREFIX = "token:mer:";


    /**
     * 短信使用状态
     */
    public static final int SMS_STATUS_UNUSE = 0; //未使用
    public static final int SMS_STATUS_USED = 1;//已使用
    public static final int SMS_STATUS_DISABLE = 2;//主动废除


}
