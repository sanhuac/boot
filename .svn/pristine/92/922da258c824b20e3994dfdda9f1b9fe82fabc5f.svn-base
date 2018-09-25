package com.byc.merchants.merchants_cms.dao.apply;

import com.byc.merchants.merchants_cms.bean.apply.MerInsuranceApply;
import com.byc.merchants.merchants_cms.qo.InsuranceQueryObject;
import com.byc.merchants.merchants_cms.util.ValidatorUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * created by pht on 2018/9/17 0017
 */
public interface InsuranceMapper {


    /**
     * 查询数量
     *
     * @param mer_id
     * @param qo
     * @return
     */
    @SelectProvider(type = InsuranceSql.class, method = "queryCount")
    Integer queryForCount(Integer mer_id, InsuranceQueryObject qo);

    /**
     * 查询列表
     *
     * @param mer_id
     * @param qo
     * @return
     */
    @SelectProvider(type = InsuranceSql.class, method = "queryList")
    List<MerInsuranceApply> queryForList(Integer mer_id, InsuranceQueryObject qo);

    /**
     * 总预约人数
     *
     * @param mer_id
     * @return
     */
    @Select("SELECT count(0) FROM mer_insurance_apply WHERE mer_id = #{mer_id}")
    int totalCount(Integer mer_id);


    /**
     * 查询当天预约人数
     *
     * @param mer_id
     * @param startTime
     * @param endTime
     * @return
     */
    @Select("SELECT count(0) FROM mer_insurance_apply WHERE mer_id = #{mer_id} AND apply_time >= #{startTime} AND apply_time <= #{endTime}")
    int todayCount(@Param("mer_id") Integer mer_id, @Param("startTime") int startTime, @Param("endTime") int endTime);


    /**
     * 获取今日预约列表
     * @param mer_id
     * @param startTime
     * @param endTime
     * @return
     */
    @Select("SELECT * FROM mer_insurance_apply WHERE mer_id = #{mer_id} AND apply_time >= #{startTime} AND apply_time <= #{endTime} LIMIT 6")
    List<MerInsuranceApply> todayList(@Param("mer_id") Integer mer_id, @Param("startTime") int startTime, @Param("endTime") int endTime);


    /**
     * 动态sql
     */
    class InsuranceSql {

        /**
         * 查询数量
         *
         * @param mer_id
         * @param qo
         * @return
         */
        public String queryCount(Integer mer_id, InsuranceQueryObject qo) {
            String sql = "select count(0) from mer_insurance_apply where mer_id =  " + mer_id;

            if (ValidatorUtils.isNotNull(qo.getUserName())) {
                sql += " AND user_name like concat('%','" + qo.getUserName() + "','%') ";
            }
            if (ValidatorUtils.isNotNull(qo.getAddress())) {
                sql += " AND address like concat('%','" + qo.getAddress() + "','%') ";
            }
            return sql;
        }

        /**
         * 查询列表sql
         *
         * @param mer_id
         * @param qo
         * @return
         */
        public String queryList(Integer mer_id, InsuranceQueryObject qo) {
            String sql = "select * from mer_insurance_apply where mer_id =  " + mer_id;

            if (ValidatorUtils.isNotNull(qo.getUserName())) {
                sql += " AND user_name like concat('%','" + qo.getUserName() + "','%') ";
            }
            if (ValidatorUtils.isNotNull(qo.getAddress())) {
                sql += " AND address like concat('%','" + qo.getAddress() + "','%') ";
            }
            sql += " limit " + qo.getStartIndex() + "," + qo.getPageSize();
            return sql;
        }
    }

}
