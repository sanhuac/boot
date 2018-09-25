package com.byc.merchants.merchants_cms.model.user;

/**
 * created by pht on 2018/9/10 0010
 */

import java.io.Serializable;

/**
 * @author pht
 * @program merchants_cms
 * @date 2018/9/10 0010
 */
public class LoginLog implements Serializable {

    private static final long serialVersionUID = -224163057820541092L;

    //    日志id
    private Integer log_id;
    //    登录商户id
    private Integer mer_id;
    //    登录手机号
    private String mer_mobile;
    //    登录时间
    private Integer login_time;
    //    登录ip
    private String login_ip;
    //    登录地区编码
    private String login_area_code;
    //    经纬度
    private String longitude;
    private String latitude;

    public Integer getLog_id() {
        return log_id;
    }

    public void setLog_id(Integer log_id) {
        this.log_id = log_id;
    }

    public Integer getMer_id() {
        return mer_id;
    }

    public void setMer_id(Integer mer_id) {
        this.mer_id = mer_id;
    }

    public String getMer_mobile() {
        return mer_mobile;
    }

    public void setMer_mobile(String mer_mobile) {
        this.mer_mobile = mer_mobile;
    }

    public Integer getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Integer login_time) {
        this.login_time = login_time;
    }

    public String getLogin_ip() {
        return login_ip;
    }

    public void setLogin_ip(String login_ip) {
        this.login_ip = login_ip;
    }

    public String getLogin_area_code() {
        return login_area_code;
    }

    public void setLogin_area_code(String login_area_code) {
        this.login_area_code = login_area_code;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "log_id=" + log_id +
                ", mer_id=" + mer_id +
                ", mer_mobile='" + mer_mobile + '\'' +
                ", login_time=" + login_time +
                ", login_ip=" + login_ip +
                ", login_area_code='" + login_area_code + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
