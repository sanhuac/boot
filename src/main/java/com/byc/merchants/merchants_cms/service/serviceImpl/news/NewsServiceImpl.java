package com.byc.merchants.merchants_cms.service.serviceImpl.news;

/**
 * created by pht on 2018/9/11 0011
 */

import com.byc.merchants.merchants_cms.bean.news.News;
import com.byc.merchants.merchants_cms.constant.Constant;
import com.byc.merchants.merchants_cms.dao.news.NewsMapper;
import com.byc.merchants.merchants_cms.exception.UnifiedException;
import com.byc.merchants.merchants_cms.qo.NewsQueryObject;
import com.byc.merchants.merchants_cms.qo.PageResult;
import com.byc.merchants.merchants_cms.service.news.NewsService;
import com.byc.merchants.merchants_cms.util.RecordNoUtil;
import com.byc.merchants.merchants_cms.util.TimeUtils;
import com.byc.merchants.merchants_cms.util.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pht
 * @program merchants_cms
 * @date 2018/9/11 0011
 */

@Service
public class NewsServiceImpl implements NewsService {


    @Autowired
    private NewsMapper newsMapper;

    /**
     * 查询新闻列表
     *
     * @param mer_id
     * @param qo
     */
    @Override
    public PageResult list(Integer mer_id, NewsQueryObject qo) {
        //校验参数
        int count = newsMapper.queryForCount(mer_id, qo);
        PageResult result = PageResult.emptyResult();
        if (count > 0) {
            List<News> newsList = newsMapper.queryForList(mer_id, qo);
            //添加图片前缀
            for (News news : newsList) {
                news.setImage(Constant.getInstance().PIC_URL_PREFIX + news.getImage());
            }
            result = new PageResult(qo.getCurrentPage(), qo.getPageSize(), count, newsList);
        }
        return result;
    }

    /**
     * 新闻编辑或添加或查看请求
     *
     * @param news_id
     * @return
     */
    @Override
    public News edit(Integer news_id) {

        if (ValidatorUtils.isNotNull(news_id)) {
            //编辑
            News news = newsMapper.selectNewsById(news_id);
            news.setImage(Constant.getInstance().PIC_URL_PREFIX + news.getImage());
            return news;
        }
        //添加
        return null;
    }

    /**
     * 添加或保存数据
     *
     * @param news
     */
    @Override
    public void updateOrAdd(News news) throws UnifiedException {
        if (ValidatorUtils.isNull(news)) {
            throw new UnifiedException(210001);
        }
        //校验参数
        //标题
        if (news.getNews_title().length() > 32 || news.getSecond_title().length() > 32) {
            throw new UnifiedException(210002);
        }

        if (ValidatorUtils.isNull(news.getNews_id())) {
            //添加操作
            //生成新闻编号(预留)
            news.setNews_no(RecordNoUtil.get11());
            //创建时间
            news.setCreate_time(Integer.parseInt(TimeUtils.getCurrentTimeStamp() + ""));
            newsMapper.insertNews(news);
        } else {
            //编辑
            newsMapper.updateNews(news);
        }

    }

    /**
     * 删除新闻
     *
     * @param mer_id
     * @param news_id
     */
    @Override
    public void deleteNews(Integer mer_id, Integer news_id) throws UnifiedException {
        if (ValidatorUtils.isNull(mer_id)) {
            throw new UnifiedException(200014);
        }
        if (ValidatorUtils.isNull(news_id)) {
            throw new UnifiedException(210003);
        }
        //删除
        int count = newsMapper.delete(mer_id, news_id);
        if (count != 1) {
            throw new UnifiedException(210004);
        }
    }
}
