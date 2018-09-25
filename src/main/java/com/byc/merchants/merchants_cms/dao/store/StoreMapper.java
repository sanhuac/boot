package com.byc.merchants.merchants_cms.dao.store;

import com.byc.merchants.merchants_cms.bean.store.BrowHistory;
import com.byc.merchants.merchants_cms.model.image.StoreImageModel;
import com.byc.merchants.merchants_cms.model.user.UpdateMerModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/11 09:18
 * @Description:
 */
public interface StoreMapper {

    /**
     * @描述 修改商铺logo
     * @参数 mer_id
     * @返回值 int
     * @创建人 胡丛
     * @创建时间 2018/9/11
     * @修改人和其它信息
     */
    @Update("UPDATE mer_store SET store_logo = #{store_logo} WHERE mer_id = #{mer_id}")
    int updateStoreLogo(UpdateMerModel mer);

    /**
     * @描述 修改商铺名字
     * @参数 mer_id
     * @返回值 int
     * @创建人 胡丛
     * @创建时间 2018/9/11
     * @修改人和其它信息
     */
    @Update("UPDATE mer_store SET store_name = #{store_name} WHERE mer_id = #{mer_id}")
    int updateStoreName(UpdateMerModel mer);

    /**
     * @描述 修改商铺门店简介
     * @参数 mer_id
     * @返回值 int
     * @创建人 胡丛
     * @创建时间 2018/9/11
     * @修改人和其它信息
     */
    @Update("UPDATE mer_store SET store_introduction = #{store_introduction} WHERE mer_id = #{mer_id}")
    int updateStoreIntroduce(UpdateMerModel mer);

    /**
     * @描述 修改商铺客服电话
     * @参数 mer_id
     * @返回值 int
     * @创建人 胡丛
     * @创建时间 2018/9/11
     * @修改人和其它信息
     */
    @Update("UPDATE mer_store SET customer_photo = #{customer_photo} WHERE mer_id = #{mer_id}")
    int updateStorePhone(UpdateMerModel mer);

    /**
     * @描述 修改商铺门店地址
     * @参数 mer_id
     * @返回值 int
     * @创建人 胡丛
     * @创建时间 2018/9/11
     * @修改人和其它信息
     */
    @Update("UPDATE mer_store SET province_code = #{province_code},city_code = #{city_code},area_code = #{area_code},store_address = #{store_address},lat = #{lat},lng = #{lng} WHERE mer_id = #{mer_id}")
    int updateStoreAddress(UpdateMerModel mer);

    /**
     * @描述 修改商铺门店销售品牌
     * @参数 mer_id
     * @返回值 int
     * @创建人 胡丛
     * @创建时间 2018/9/11
     * @修改人和其它信息
     */
    @Update("UPDATE mer_store SET sale_brands = #{sale_brands} WHERE mer_id = #{mer_id}")
    int updateStoreBrand(UpdateMerModel mer);

    /**
     * @描述 修改商铺门店活动
     * @参数 mer_id
     * @返回值 int
     * @创建人 胡丛
     * @创建时间 2018/9/11
     * @修改人和其它信息
     */
    @Update("UPDATE mer_store SET notice_label = #{notice_label},favor_label = #{favor_label} WHERE mer_id = #{mer_id}")
    int updateStoreActive(UpdateMerModel mer);

    /**
     * @描述 修改商铺门店二维码
     * @参数 mer_id
     * @返回值 int
     * @创建人 胡丛
     * @创建时间 2018/9/11
     * @修改人和其它信息
     */
    @Update("UPDATE mer_store SET store_ercode = #{store_ercode} WHERE mer_id = #{mer_id}")
    int updateStoreErcode(UpdateMerModel mer);

    /**
     * @描述 修改商铺门店首页图
     * @参数 mer_id
     * @返回值 int
     * @创建人 胡丛
     * @创建时间 2018/9/11
     * @修改人和其它信息
     */
    @Insert("INSERT INTO mer_store_image(mer_id,image_type,image_url,create_time,start_time,end_time)VALUES(#{mer_id},#{image_type},#{image_url},UNIX_TIMESTAMP(),#{start_time},#{end_time})")
    int updateStoreIndex(StoreImageModel image);


    /**
     * 查询店铺关注人数
     *
     * @param mer_id
     * @return
     */
    @Select("SELECT count(0) FROM mer_follow WHERE mer_id = #{mer_id}")
    int selectFollowNum(Integer mer_id);

    /**
     * 查询浏览记录
     *
     * @param mer_id
     * @return
     */
    @Select("SELECT mbh.*,u.avatar_url,u.login_mobile FROM mer_browsing_history mbh LEFT JOIN user u ON mbh.user_id = u.user_id WHERE mbh.mer_id = #{mer_id} ORDER BY mbh.browse_time DESC LIMIT 5")
    List<BrowHistory> selectBrowHistory(Integer mer_id);
}
