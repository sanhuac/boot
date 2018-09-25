package com.byc.merchants.merchants_cms.service.store;


import com.byc.merchants.merchants_cms.exception.UnifiedException;
import com.byc.merchants.merchants_cms.model.image.StoreImageModel;
import com.byc.merchants.merchants_cms.model.user.UpdateMerModel;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/11 09:15
 * @Description: 商铺接口
 */
public interface StoreService {

    /**
     *@描述 修改商铺logo
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    int updateStoreLogo(UpdateMerModel mer);

    /**
     *@描述 修改商铺名字
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    int updateStoreName(UpdateMerModel mer);

    /**
     *@描述 修改商铺门店简介
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    int updateStoreIntroduce(UpdateMerModel mer);

    /**
     *@描述 修改商铺客服电话
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    int updateStorePhone(UpdateMerModel mer);

    /**
     *@描述 修改商铺门店地址
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    int updateStoreAddress(UpdateMerModel mer);

    /**
     *@描述 修改商铺门店销售品牌
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    int updateStoreBrand(UpdateMerModel mer);

    /**
     *@描述 修改商铺门店活动
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    int updateStoreActive(UpdateMerModel mer);

    /**
     *@描述 修改商铺门店二维码
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    int updateStoreErcode(UpdateMerModel mer);

    /**
     *@描述 修改商铺门店首页图
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    int updateStoreIndex(StoreImageModel image)throws UnifiedException;
}
