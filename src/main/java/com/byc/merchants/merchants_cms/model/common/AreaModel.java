package com.byc.merchants.merchants_cms.model.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/7 16:19
 * @Description: 地区编码模板
 */

@ApiModel(value = "获取省市区所需参数",description = "获取省市区所需参数")
@Data
public class AreaModel implements Serializable{

    /**
     * 地区编码
     */
    @ApiModelProperty(value = "地区编码[获取省的直接传0]",name = "area_no",example = "330000")
    private String area_no;
}
