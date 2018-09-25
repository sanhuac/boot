package com.byc.merchants.merchants_cms.service.index;

import com.byc.merchants.merchants_cms.exception.UnifiedException;

import java.util.Map;

/**
 * created by pht on 2018/9/17 0017
 */
public interface IndexService {
    /**
     * 首页相关
     * @param mer_id
     * @return
     */
    Map<String,Object> merIndex(Integer mer_id) throws UnifiedException;
}
