package com.byc.merchants.merchants_cms.service.news;

import com.byc.merchants.merchants_cms.bean.news.News;
import com.byc.merchants.merchants_cms.exception.UnifiedException;
import com.byc.merchants.merchants_cms.qo.NewsQueryObject;
import com.byc.merchants.merchants_cms.qo.PageResult;

/**
 * created by pht on 2018/9/11 0011
 */
public interface NewsService {

    /**
     * 新闻列表
     *  @param mer_id
     * @param qo
     */
    PageResult list(Integer mer_id, NewsQueryObject qo);

    /**
     * 新闻编辑或添加或查看请求
     * @param news_id
     * @return
     */
    News edit(Integer news_id);

    /**
     * 编辑或添加保存
     * @param news
     */
    void updateOrAdd(News news) throws UnifiedException;

    /**
     * 新闻删除
     * @param mer_id
     * @param news_id
     */
    void deleteNews(Integer mer_id, Integer news_id) throws UnifiedException;
}
