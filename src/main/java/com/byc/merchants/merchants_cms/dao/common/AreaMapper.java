package com.byc.merchants.merchants_cms.dao.common;

import com.byc.merchants.merchants_cms.bean.common.Area;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/7 16:23
 * @Description: 省市区库
 */
public interface AreaMapper {

    /**
     * 根据父编码查询子编码
     *
     * @param areaNo
     * @return
     */
    @Select("select area_no,area_name from area where parent_area_no=#{areaNo}  order by area_no asc")
    List<Area> areas(String areaNo);

    /**
     * 查询编码个数
     * @param areaNo
     * @return
     */
    @Select("select count(0) c from area where area_no=#{areaNo} order by area_no asc")
    int areaNum(String areaNo);


    /**
     * 查询编码名字
     * @param areaNo
     * @return
     */
    @Select("select area_name from area where area_no=#{areaNo} and area_status = 1")
    String areaName(String areaNo);
}
