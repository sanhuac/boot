package com.byc.merchants.merchants_cms.service.apply;

import com.byc.merchants.merchants_cms.exception.UnifiedException;
import com.byc.merchants.merchants_cms.qo.InsuranceQueryObject;
import com.byc.merchants.merchants_cms.qo.PageResult;

/**
 * created by pht on 2018/9/17 0017
 */
public interface InsuranceService {
    /**
     * 保险申请列表
     * @param mer_id
     * @param qo
     * @return
     */
    PageResult insuranceList(Integer mer_id, InsuranceQueryObject qo) throws UnifiedException;
}
