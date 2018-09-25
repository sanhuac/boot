package com.byc.merchants.merchants_cms.dao.image;

import com.byc.merchants.merchants_cms.model.image.StoreImageModel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/10 15:35
 * @Description: 商户店铺纯图片表
 */
public interface StoreImageMapper {

    /**
     *@描述 查询商铺首页图
     *@参数 mer_id
     *@返回值 StoreImageModel
     *@创建人  胡丛
     *@创建时间  2018/9/10
     *@修改人和其它信息
     */
     @Select("select image_url,start_time,end_time from mer_store_image where mer_id = #{mer_id} and image_type = 0 and image_status = 0")
     List<StoreImageModel> selectStoreIndexImsge(Integer mer_id);
}
