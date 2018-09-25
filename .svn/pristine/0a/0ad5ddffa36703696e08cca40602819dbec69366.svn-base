package com.byc.merchants.merchants_cms.model.sms;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/6 17:22
 * @Description: 短信验证码实体
 */

@ApiModel(value = "商户获取验证码所需参数",description = "商户获取验证码所需参数")
@Data
public class SmsCode implements Serializable{

    /**
     * 商户手机
     */
    @ApiModelProperty(value = "商户手机号",name = "mer_mobile",example = "15632562536")
    private String mer_mobile;


    /**
     * 验证码类型
     */
    @ApiModelProperty(value = "验证码类型[CODE_REGISTER:注册验证码 CODE_FORGET_PASSWORD:修改密码]",name = "code_type",example = "CODE_REGISTER")
    private String code_type;


}
