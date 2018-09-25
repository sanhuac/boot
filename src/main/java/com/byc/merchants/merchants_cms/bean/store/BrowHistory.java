package com.byc.merchants.merchants_cms.bean.store;

/**
 * created by pht on 2018/9/18 0018
 */

import java.io.Serializable;

/**
 * 浏览记录实体
 *
 * @author pht
 * @program merchants_cms
 * @date 2018/9/18 0018
 */
public class BrowHistory implements Serializable {

    private static final long serialVersionUID = -4820349411932690171L;
    //'浏览记录id',
    private Integer browse_id;
    //'商户id',
    private Integer mer_id;
    //'浏览用户id',
    private Integer user_id;
    //用户头像
    private String avatar_url;
    //用户手机号
    private String login_mobile;
    //'浏览时间',
    private Integer browse_time;


    public Integer getBrowse_id() {
        return browse_id;
    }

    public void setBrowse_id(Integer browse_id) {
        this.browse_id = browse_id;
    }

    public Integer getMer_id() {
        return mer_id;
    }

    public void setMer_id(Integer mer_id) {
        this.mer_id = mer_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getLogin_mobile() {
        return login_mobile;
    }

    public void setLogin_mobile(String login_mobile) {
        this.login_mobile = login_mobile;
    }

    public Integer getBrowse_time() {
        return browse_time;
    }

    public void setBrowse_time(Integer browse_time) {
        this.browse_time = browse_time;
    }

    @Override
    public String toString() {
        return "BrowHistory{" +
                "browse_id=" + browse_id +
                ", mer_id=" + mer_id +
                ", user_id=" + user_id +
                ", avatar_url='" + avatar_url + '\'' +
                ", login_mobile='" + login_mobile + '\'' +
                ", browse_time=" + browse_time +
                '}';
    }
}
