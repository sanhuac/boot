package com.byc.merchants.merchants_cms.service.product;

import com.byc.merchants.merchants_cms.exception.UnifiedException;
import com.byc.merchants.merchants_cms.qo.CarQueryObject;

import java.util.Map;

/**
 * created by pht on 2018/9/18 0018
 */
public interface ProductService {

    /**
     * 4s店铺产品列表
     *
     * @param mer_id
     * @param qo
     * @return
     */
    Map<String, Object> merCarList(Integer mer_id, CarQueryObject qo) throws UnifiedException;

    /**
     * 商品编辑页面数据回显
     *
     * @param mer_id
     * @param car_id
     * @return
     */
    Map<String, Object> productEdit(Integer mer_id, Integer car_id) throws UnifiedException;

    /**
     * 产品上下架
     *
     * @param mer_id
     * @param product_id
     */
    void saleOrNot(Integer mer_id, Integer product_id) throws UnifiedException;

    /**
     * 批量删除产品
     *
     * @param mer_id
     * @param ids
     */
    void batchDelete(Integer mer_id, int[] ids) throws UnifiedException;
}
