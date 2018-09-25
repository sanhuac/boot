package com.byc.merchants.merchants_cms.dao.store;


import com.byc.merchants.merchants_cms.model.user.InsuranceModel;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/21 14:17
 * @Description: 保险接口
 */
public interface InsuranceUMapper {

    /**
     * @描述 查询保险进一步信息
     * @参数 mer_id
     * @返回值 UserModel
     * @创建人 胡丛
     * @创建时间 2018/9/10
     * @修改人和其它信息
     */
    @Select("SELECT store_logo,store_name,store_introduction,customer_photo,store_address,province_code,city_code,area_code,lat,lng,index_image FROM mer_store WHERE mer_id = #{mer_id} and store_type = 2")
    InsuranceModel selectStoreById(Integer mer_id);

    /**
     * @描述 修改保险logo
     * @参数 mer_id
     * @返回值 int
     * @创建人 胡丛
     * @创建时间 2018/9/11
     * @修改人和其它信息
     */
    @Update("UPDATE mer_store SET store_logo = #{store_logo} WHERE mer_id = #{mer_id}")
    int updateInsuranceLogo(InsuranceModel mer);

    /**
     * @描述 修改保险名字
     * @参数 mer_id
     * @返回值 int
     * @创建人 胡丛
     * @创建时间 2018/9/11
     * @修改人和其它信息
     */
    @Update("UPDATE mer_store SET store_name = #{store_name} WHERE mer_id = #{mer_id}")
    int updateInsuranceName(InsuranceModel mer);

    /**
     * @描述 修改保险门店简介
     * @参数 mer_id
     * @返回值 int
     * @创建人 胡丛
     * @创建时间 2018/9/11
     * @修改人和其它信息
     */
    @Update("UPDATE mer_store SET store_introduction = #{store_introduction} WHERE mer_id = #{mer_id}")
    int updateInsuranceIntroduce(InsuranceModel mer);

    /**
     * @描述 修改保险客服电话
     * @参数 mer_id
     * @返回值 int
     * @创建人 胡丛
     * @创建时间 2018/9/11
     * @修改人和其它信息
     */
    @Update("UPDATE mer_store SET customer_photo = #{customer_photo} WHERE mer_id = #{mer_id}")
    int updateInsurancePhone(InsuranceModel mer);

    /**
     * @描述 修改保险门店地址
     * @参数 mer_id
     * @返回值 int
     * @创建人 胡丛
     * @创建时间 2018/9/11
     * @修改人和其它信息
     */
    @Update("UPDATE mer_store SET province_code = #{province_code},city_code = #{city_code},area_code = #{area_code},store_address = #{store_address},lat = #{lat},lng = #{lng} WHERE mer_id = #{mer_id}")
    int updateInsuranceAddress(InsuranceModel mer);

    /**
     * @描述 修改保险Banner
     * @参数 mer_id
     * @返回值 int
     * @创建人 胡丛
     * @创建时间 2018/9/11
     * @修改人和其它信息
     */
    @Update("UPDATE mer_store SET index_image = #{index_image} WHERE mer_id = #{mer_id}")
    int updateInsuranceBanner(InsuranceModel mer);
}
