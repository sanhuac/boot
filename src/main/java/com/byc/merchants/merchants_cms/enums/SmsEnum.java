package com.byc.merchants.merchants_cms.enums;


/**
 * @author 胡丛
 * @time 2018年9月16日
 * @type SmsEnum.java
 */
public enum SmsEnum {

	/*定义了8个短信发送类型*/
    CODE_REGISTER("323539", "注册验证码"),
    CODE_VALIDCODE("157424", "验证码"),
    CODE_FORGET_PASSWORD("157423", "修改密码");
	
	/*两个属性*/
    private String code;
    private String msg;
   /*构造函数*/
    private SmsEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
   /*属性的setter和getter*/
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
