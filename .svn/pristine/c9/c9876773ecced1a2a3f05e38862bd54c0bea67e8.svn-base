package com.byc.merchants.merchants_cms.bean.news;

/**
 * created by pht on 2018/9/11 0011
 */

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author pht
 * @program merchants_cms
 * @date 2018/9/11 0011
 */
public class News implements Serializable {

    private static final long serialVersionUID = 1313524616809598359L;

    @ApiModelProperty(value = "新闻id")
    private Integer news_id; //'主键'
    @ApiModelProperty(value = "新闻编号")
    private String news_no; //'新闻编号(非id,且唯一)'

    //店铺id
    @ApiModelProperty(hidden = true)
    private Integer mer_id;

    @ApiModelProperty(value = "新闻标题")
    private String news_title;// '新闻标题'
    @ApiModelProperty(value = "副标题")
    private String second_title; // '副标题'
    @ApiModelProperty(value = "新闻内容")
    private String news_content; // '新闻内容'
    @ApiModelProperty(hidden = true)
    private Integer play_num;// '浏览量'
    @ApiModelProperty(hidden = true)
    private Integer status; // '发布状态(0:审核中,1:审核通过,2:审核未通过)'
    @ApiModelProperty(hidden = true)
    private Integer create_time;// '发布时间'
    @ApiModelProperty(value = "新闻封面图")
    private String image;//'新闻封面图'
    @ApiModelProperty(hidden = true)
    private Integer admin_id;
    @ApiModelProperty(hidden = true)
    private String name;

    public Integer getMer_id() {
        return mer_id;
    }

    public void setMer_id(Integer mer_id) {
        this.mer_id = mer_id;
    }

    public Integer getNews_id() {
        return news_id;
    }

    public void setNews_id(Integer news_id) {
        this.news_id = news_id;
    }

    public String getNews_no() {
        return news_no;
    }

    public void setNews_no(String news_no) {
        this.news_no = news_no;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getSecond_title() {
        return second_title;
    }

    public void setSecond_title(String second_title) {
        this.second_title = second_title;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public Integer getPlay_num() {
        return play_num;
    }

    public void setPlay_num(Integer play_num) {
        this.play_num = play_num;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Integer create_time) {
        this.create_time = create_time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "News{" +
                "news_id=" + news_id +
                ", news_no='" + news_no + '\'' +
                ", mer_id=" + mer_id +
                ", news_title='" + news_title + '\'' +
                ", second_title='" + second_title + '\'' +
                ", news_content='" + news_content + '\'' +
                ", play_num=" + play_num +
                ", status=" + status +
                ", create_time=" + create_time +
                ", image='" + image + '\'' +
                ", admin_id=" + admin_id +
                ", name='" + name + '\'' +
                '}';
    }
}
