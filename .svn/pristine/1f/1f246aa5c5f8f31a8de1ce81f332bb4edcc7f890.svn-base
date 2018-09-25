package com.byc.merchants.merchants_cms.dao.extra;

import com.byc.merchants.merchants_cms.model.extra.CfgParams;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CfgParamsMapper {

    @Select("select * from cfg_params")
    @Results({
            @Result(property = "pmCate", column = "pm_cate"),
            @Result(property = "pmKey", column = "pm_key"),
            @Result(property = "pmValue", column = "pm_value"),
            @Result(property = "pmRemark", column = "pm_remark")
    })
    public List<CfgParams> getValues();

    @Select("select pm_value from cfg_params where pm_cate=#{pmCate} and pm_key=#{pmKey}")
    public String getValue(@Param("pmCate") String pmCate, @Param("pmKey") String pmKey);

}
