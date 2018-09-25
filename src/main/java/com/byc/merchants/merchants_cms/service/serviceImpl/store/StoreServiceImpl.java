package com.byc.merchants.merchants_cms.service.serviceImpl.store;

import com.byc.merchants.merchants_cms.dao.store.StoreMapper;
import com.byc.merchants.merchants_cms.exception.UnifiedException;
import com.byc.merchants.merchants_cms.model.image.StoreImageModel;
import com.byc.merchants.merchants_cms.model.user.UpdateMerModel;
import com.byc.merchants.merchants_cms.service.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/11 09:16
 * @Description:
 */
@Service("storeService")
public class StoreServiceImpl implements StoreService{


    @Autowired
    private StoreMapper storeDao;

    /**
     *@描述 修改商铺logo
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    public int updateStoreLogo(UpdateMerModel mer){
        int i = storeDao.updateStoreLogo(mer);
        return i;
    }

    /**
     *@描述 修改商铺名字
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    public int updateStoreName(UpdateMerModel mer){
        int i = storeDao.updateStoreName(mer);
        return i;
    }

    /**
     *@描述 修改商铺门店简介
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    public int updateStoreIntroduce(UpdateMerModel mer){
        int i = storeDao.updateStoreIntroduce(mer);
        return i;
    }

    /**
     *@描述 修改商铺客服电话
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    public int updateStorePhone(UpdateMerModel mer){
        int i = storeDao.updateStorePhone(mer);
        return i;
    }

    /**
     *@描述 修改商铺门店地址
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    public int updateStoreAddress(UpdateMerModel mer){
        int i = storeDao.updateStoreAddress(mer);
        return i;
    }

    /**
     *@描述 修改商铺门店销售品牌
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    public int updateStoreBrand(UpdateMerModel mer){
        int i = storeDao.updateStoreBrand(mer);
        return i;
    }

    /**
     *@描述 修改商铺门店活动
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    public int updateStoreActive(UpdateMerModel mer){
        int i = storeDao.updateStoreActive(mer);
        return i;
    }

    /**
     *@描述 修改商铺门店二维码
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    public int updateStoreErcode(UpdateMerModel mer){
        int i = storeDao.updateStoreErcode(mer);
        return i;
    }

    /**
     *@描述 修改商铺门店首页图
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    public int updateStoreIndex(StoreImageModel image)throws UnifiedException {
        String images = image.getImage_url();
        String[] arr = images.split(",");
        if(arr.length<1){
            throw new UnifiedException(400000);
        }
        int j = 0;
        for(int i=0;i<arr.length;i++){
            image.setImage_url(arr[i]);
            j = storeDao.updateStoreIndex(image);
        }
        return j;
    }
}
