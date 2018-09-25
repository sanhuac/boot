package com.byc.merchants.merchants_cms.service.serviceImpl.store;

import com.byc.merchants.merchants_cms.dao.store.InsuranceUMapper;
import com.byc.merchants.merchants_cms.model.user.InsuranceModel;
import com.byc.merchants.merchants_cms.service.store.InsuranceUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/21 14:23
 * @Description:
 */
@Service("insuranceService")
public class InsuranceUServiceImpl implements InsuranceUService{

    @Autowired
    private InsuranceUMapper insuranceDao;

    /**
     *@描述 保险完善信息展示
     *@参数
     *@返回值
     *@创建人  胡丛
     *@创建时间  2018/9/21
     *@修改人和其它信息
     */
    public InsuranceModel selectStoreById(Integer mer_id){

        InsuranceModel insuranceModel = insuranceDao.selectStoreById(mer_id);
        return insuranceModel;
    }

    /**
     *@描述 修改保险门店logo
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    public int updateInsuranceLogo(InsuranceModel mer){
        int i = insuranceDao.updateInsuranceLogo(mer);
        return i;
    }

    /**
     *@描述 修改保险门店名字
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    public int updateInsuranceName(InsuranceModel mer){
        int i = insuranceDao.updateInsuranceName(mer);
        return i;
    }

    /**
     *@描述 修改保险门店简介
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    public int updateInsuranceIntroduce(InsuranceModel mer){
        int i = insuranceDao.updateInsuranceIntroduce(mer);
        return i;
    }

    /**
     *@描述 修改保险门店客服电话
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    public int updateInsurancePhone(InsuranceModel mer){
        int i = insuranceDao.updateInsurancePhone(mer);
        return i;
    }

    /**
     *@描述 修改保险门店地址
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    public int updateInsuranceAddress(InsuranceModel mer){
        int i = insuranceDao.updateInsuranceAddress(mer);
        return i;
    }

    /**
     *@描述 修改保险门店Banner
     *@参数  mer_id
     *@返回值  int
     *@创建人  胡丛
     *@创建时间  2018/9/11
     *@修改人和其它信息
     */
    public int updateInsuranceBanner(InsuranceModel mer){
        int i = insuranceDao.updateInsuranceBanner(mer);
        return i;
    }
}
