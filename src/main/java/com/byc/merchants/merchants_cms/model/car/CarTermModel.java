package com.byc.merchants.merchants_cms.model.car;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/17 12:46
 * @Description:
 */
@ApiModel(value = "车辆分期方案参数",description = "车辆分期方案参数")
@Data
public class CarTermModel implements Serializable{

    @ApiModelProperty(value = "分期id(修改的时候穿传)",name = "plan_id",example = "1")
    private Integer plan_id;

    @ApiModelProperty(value = "车辆id",name = "car_id",example = "1")
    private Integer car_id;

    @ApiModelProperty(value = "首付价格",name = "down_pay",example = "99.99")
    private BigDecimal down_pay;

    @ApiModelProperty(value = "月付",name = "monthly_pay",example = "99.99")
    private BigDecimal monthly_pay;

    @ApiModelProperty(value = "分期期数",name = "term",example = "24")
    private Integer term;


}
