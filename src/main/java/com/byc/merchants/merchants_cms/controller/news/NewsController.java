package com.byc.merchants.merchants_cms.controller.news;

/**
 * created by pht on 2018/9/11 0011
 */

import com.byc.merchants.merchants_cms.annoation.CurrentUser;
import com.byc.merchants.merchants_cms.bean.news.News;
import com.byc.merchants.merchants_cms.controller.BaseController;
import com.byc.merchants.merchants_cms.qo.NewsQueryObject;
import com.byc.merchants.merchants_cms.qo.PageResult;
import com.byc.merchants.merchants_cms.result.JsonResult;
import com.byc.merchants.merchants_cms.service.news.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

/**
 * 新闻模块
 *
 * @author pht
 * @program merchants_cms
 * @date 2018/9/11 0011
 */
@RestController
@RequestMapping("/news")
@Api(value = "店铺新闻模块", tags = {"店铺新闻"})
@Slf4j
public class NewsController extends BaseController {

    @Autowired
    private NewsService newsService;

    /**
     * @param mer_id
     * @return
     */
    @ApiOperation(value = "新闻列表", notes = "获取新闻列表,包含分页查询与模糊查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "accessId", value = "登录tokenId", required = true, dataType = "string"),
            @ApiImplicitParam(name = "mer_id", value = "用户id,不用传", dataType = "int"),
    })
    @PostMapping("/newsList")
    public ResponseEntity<JsonResult> newsList(@CurrentUser Integer mer_id, String accessId, NewsQueryObject qo) {
        JsonResult result = new JsonResult();
        log.info("新闻列表请求参数: mer_id = " + mer_id + "分页对象");
        try {
            PageResult pageResult = newsService.list(mer_id, qo);
            log.info("新闻列表响应:" + pageResult);
            result = dealSuccess(pageResult);
        } catch (Exception e) {
            result = dealException(e);
        }
        return ResponseEntity.ok(result);
    }

    /**
     * @param news_id
     * @return
     */
    @PostMapping("/edit")
    @ApiOperation(value = "编辑新闻页面(数据回显,查看详情)", notes = "添加或者编辑")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "accessId", value = "登录tokenId", required = true, dataType = "string"),
            @ApiImplicitParam(name = "news_id", value = "新闻id", dataType = "int"),
    })
    public ResponseEntity<JsonResult> edit(Integer news_id, String accessId) {
        JsonResult result = new JsonResult();

        log.info("新闻编辑或添加或查看请求:新闻id = " + news_id);

        try {
            News news = newsService.edit(news_id);
            result = dealSuccess(news);
        } catch (Exception e) {
            result = dealException(e);
        }

        log.info("新闻编辑或添加或查看响应:" + result);
        return ResponseEntity.ok(result);
    }

    /**
     * 添加或编辑
     *
     * @param news
     * @return
     */
    @PostMapping("/updateOrAdd")
    @ApiOperation(value = "添加或编辑", notes = "没有id就是新增,有就是编辑")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "accessId", value = "登录tokenId", required = true, dataType = "string"),
            @ApiImplicitParam(name = "mer_id", value = "不用传", dataType = "int"),
    })
    public ResponseEntity<JsonResult> updateOrAdd(@CurrentUser Integer mer_id, News news, String accessId) {
        JsonResult result = new JsonResult();

        log.info("添加或更新请求参数:" + news);

        try {
            news.setMer_id(mer_id);
            newsService.updateOrAdd(news);
            result = dealSuccess();
        } catch (Exception e) {
            result = dealException(e);
        }

        log.info("添加或更新响应参数:" + result);
        return ResponseEntity.ok(result);
    }


    /**
     * 删除新闻
     * @param mer_id
     * @param news_id
     * @param accessId
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "accessId", value = "登录tokenId", required = true, dataType = "string"),
            @ApiImplicitParam(name = "mer_id", value = "不用传", dataType = "int"),
            @ApiImplicitParam(name = "news_id", value = "新闻id", dataType = "int"),
    })
    @ApiOperation(value = "删除新闻", notes = "删除当前新闻")
    @PostMapping("/delete")
    public ResponseEntity<JsonResult> delete(@CurrentUser Integer mer_id, Integer news_id, String accessId) {
        JsonResult result = new JsonResult();

        log.info("新闻删除请求参数:" + news_id);

        try {
            newsService.deleteNews(mer_id,news_id);
            result = dealSuccess();
        } catch (Exception e) {
            result = dealException(e);
        }

        log.info("新闻删除响应参数:" + result);
        return ResponseEntity.ok(result);
    }


}
