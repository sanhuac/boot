package com.byc.merchants.merchants_cms.service.apply;

import com.byc.merchants.merchants_cms.exception.UnifiedException;
import com.byc.merchants.merchants_cms.qo.ApplyQueryObject;
import com.byc.merchants.merchants_cms.qo.EarnestQueryObject;
import com.byc.merchants.merchants_cms.qo.PageResult;

/**
 * created by pht on 2018/9/17 0017
 */
public interface ApplyService {

    /**
     * 预约列表
     * @param mer_id
     * @param qo
     * @return
     * @throws UnifiedException
     */
    PageResult subscribeList(Integer mer_id, ApplyQueryObject qo) throws UnifiedException;

    /**
     * 定金预约列表
     * @param mer_id
     * @param qo
     * @return
     */
    PageResult earnestList(Integer mer_id, EarnestQueryObject qo) throws UnifiedException;
}
