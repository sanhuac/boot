package com.byc.merchants.merchants_cms.controller.product;

/**
 * created by pht on 2018/9/18 0018
 */

import com.byc.merchants.merchants_cms.annoation.CurrentUser;
import com.byc.merchants.merchants_cms.controller.BaseController;
import com.byc.merchants.merchants_cms.qo.CarQueryObject;
import com.byc.merchants.merchants_cms.result.JsonResult;
import com.byc.merchants.merchants_cms.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品管理
 *
 * @author pht
 * @program merchants_cms
 * @date 2018/9/18 0018
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController extends BaseController {

    @Autowired
    private ProductService productService;


    /**
     * 产品列表
     *
     * @param mer_id
     * @param qo
     * @return
     */
    @PostMapping("/merProductList")
    public ResponseEntity<JsonResult> merCarList(@CurrentUser Integer mer_id, CarQueryObject qo) {
        JsonResult result = new JsonResult();

        log.info("产品列表请求参数:mer_id = " + mer_id + ",qo = " + qo);

        try {
            result = dealSuccess(productService.merCarList(mer_id, qo));
        } catch (Exception e) {
            result = dealException(e);
        }

        log.info("产品列表响应信息:" + result);
        return ResponseEntity.ok(result);
    }


    /**
     * 产品编辑页面数据回显
     *
     * @param mer_id
     * @param product_id
     * @return
     */
    @PostMapping("/merProductEdit")
    public ResponseEntity<JsonResult> merEdit(@CurrentUser Integer mer_id, Integer product_id) {
        JsonResult result = new JsonResult();

        log.info("产品编辑页面数据回显请求:mer_id = " + mer_id + ",product_id = " + product_id);

        try {

            result = dealSuccess(productService.productEdit(mer_id, product_id));
        } catch (Exception e) {
            result = dealException(e);
        }

        log.info("产品编辑页面数据回显响应:" + result);
        return ResponseEntity.ok(result);
    }

    /**
     * 产品上下架
     *
     * @param mer_id
     * @param product_id
     * @return
     */
    @PostMapping("/saleOrNot")
    public ResponseEntity<JsonResult> saleOrNot(@CurrentUser Integer mer_id, Integer product_id) {
        JsonResult result = new JsonResult();

        log.info("产品上下架请求参数 : mer_id = " + mer_id + ",product_id = " + product_id);

        try {
            productService.saleOrNot(mer_id, product_id);
            result = dealSuccess();
        } catch (Exception e) {
            result = dealException(e);
        }

        log.info("产品上下架响应信息:" + result);
        return ResponseEntity.ok(result);
    }

    /**
     * 批量删除
     *
     * @param mer_id
     * @param ids
     * @return
     */
    @PostMapping("/batchDelete")
    public ResponseEntity<JsonResult> batchDelete(@CurrentUser Integer mer_id, int[] ids) {
        JsonResult result = new JsonResult();

        log.info("批量删除商品请求:mer_id = " + mer_id + "ids = " + ids);

        try {
            productService.batchDelete(mer_id, ids);
            result = dealSuccess();
        } catch (Exception e) {
            result = dealException(e);
        }

        log.info("批量删除商品响应: " + result);
        return ResponseEntity.ok(result);
    }

}
