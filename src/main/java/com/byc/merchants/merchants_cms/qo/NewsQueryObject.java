package com.byc.merchants.merchants_cms.qo;

/**
 * created by pht on 2018/9/11 0011
 */

import io.swagger.annotations.ApiModelProperty;

/**
 * @author pht
 * @program merchants_cms
 * @date 2018/9/11 0011
 */
public class NewsQueryObject extends QueryObject {


    @ApiModelProperty(value = "关键字查询,关键字", name = "keyword")
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "NewsQueryObject{" +
                "keyword='" + keyword + '\'' +
                '}';
    }
}
