package com.byc.merchants.merchants_cms.service.store;

import com.byc.merchants.merchants_cms.model.user.InsuranceModel;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/21 14:22
 * @Description:
 */
public interface InsuranceUService {

    /**
     *@描述 保险完善信息展示
     *@参数
     *@返回值
     *@创建人  胡丛
     *@创建时间  2018/9/21
     *@修改人和其它信息
     */
    InsuranceModel selectStoreById(Integer mer_id);


    /**
     *@描述 修改保险门店logo
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    int updateInsuranceLogo(InsuranceModel mer);

    /**
     *@描述 修改保险门店名字
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    int updateInsuranceName(InsuranceModel mer);

    /**
     *@描述 修改保险门店简介
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    int updateInsuranceIntroduce(InsuranceModel mer);

    /**
     *@描述 修改保险门店客服电话
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    int updateInsurancePhone(InsuranceModel mer);

    /**
     *@描述 修改保险门店地址
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    int updateInsuranceAddress(InsuranceModel mer);

    /**
     *@描述 修改保险门店Banner
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    int updateInsuranceBanner(InsuranceModel mer);
}
