package com.byc.merchants.merchants_cms.dao.apply;

import com.byc.merchants.merchants_cms.bean.apply.MerApply;
import com.byc.merchants.merchants_cms.bean.apply.MerEarnest;
import com.byc.merchants.merchants_cms.qo.ApplyQueryObject;
import com.byc.merchants.merchants_cms.qo.EarnestQueryObject;
import com.byc.merchants.merchants_cms.util.ValidatorUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * created by pht on 2018/9/17 0017
 */
public interface ApplyMapper {


    /**
     * 查询数量
     *
     * @param mer_id
     * @param qo
     * @return
     */
    @SelectProvider(type = ApplySql.class, method = "queryCount")
    Integer queryForCount(Integer mer_id, ApplyQueryObject qo);


    /**
     * 查询列表
     *
     * @param mer_id
     * @param qo
     * @return
     */
    @SelectProvider(type = ApplySql.class, method = "queryList")
    List<MerApply> queryForList(Integer mer_id, ApplyQueryObject qo);


    /**
     * 查询定金预约表总数
     *
     * @param mer_id
     * @param qo
     * @return
     */
    @SelectProvider(type = ApplySql.class, method = "queryEarnestCount")
    Integer queryForEarnestCount(Integer mer_id, EarnestQueryObject qo);


    /**
     * 查询定金预约列表
     *
     * @param mer_id
     * @param qo
     * @return
     */
    @SelectProvider(type = ApplySql.class, method = "queryEarnestList")
    List<MerEarnest> queryForEarnestList(Integer mer_id, EarnestQueryObject qo);


    /**
     * 查询今日收入
     *
     * @param mer_id
     * @param startTime
     * @param endTime
     * @return
     */
    @Select("SELECT SUM(meo.earnest_amount) FROM mer_earnest_order meo LEFT JOIN mer_car_info mci ON meo.car_id = mci.car_id WHERE mci.mer_id = #{mer_id} AND meo.pay_time >= #{startTime} AND meo.pay_time <= #{endTime} AND meo.pay_status = 2")
    Double selectTotalCount(@Param("mer_id") Integer mer_id, @Param("startTime") int startTime, @Param("endTime") int endTime);

    /**
     * 今日预约
     *
     * @param mer_id
     * @param startTime
     * @param endTime
     * @return
     */
    @Select("SELECT ma.*,mci.car_name,mci.car_color,mci.index_image,mcp.down_pay,mcp.monthly_pay,mcp.term,mci.car_type,mci.car_model " +
            " FROM mer_apply ma LEFT JOIN mer_car_info mci ON ma.car_id = mci.car_id " +
            " JOIN mer_car_plan mcp ON ma.plan_id = mcp.plan_id WHERE mci.mer_id = #{mer_id} AND ma.apply_time >= #{startTime} AND ma.apply_time <= #{endTime} LIMIT 2")
    List<MerApply> selectTotalApply(@Param("mer_id") Integer mer_id, @Param("startTime") int startTime, @Param("endTime") int endTime);

    /**
     * 今日定金
     *
     * @param mer_id
     * @param startTime
     * @param endTime
     * @return
     */
    @Select("SELECT meo.*,mci.car_name,mci.car_color,mci.index_image,mci.car_type,mci.car_model  " +
            "FROM mer_earnest_order meo LEFT JOIN mer_car_info mci ON meo.car_id = mci.car_id WHERE mci.mer_id = #{mer_id} AND meo.apply_time >= #{startTime} AND meo.apply_time <= #{endTime} LIMIT 2")
    List<MerEarnest> selectTotalEarnest(@Param("mer_id") Integer mer_id, @Param("startTime") int startTime, @Param("endTime") int endTime);


    /**
     * 动态sql
     */
    class ApplySql {


        /**
         * 查询数量的sql
         *
         * @param mer_id
         * @param qo
         * @return
         */
        public String queryCount(Integer mer_id, ApplyQueryObject qo) {
            String sql = "SELECT COUNT(0) FROM mer_apply ma LEFT JOIN mer_car_info mci ON ma.car_id = mci.car_id WHERE mci.mer_id = " + mer_id;
            if (ValidatorUtils.isNotNull(qo.getKeyword())) {
                sql += " AND mci.car_name like concat('%','" + qo.getKeyword() + "','%') ";
            }
            if (ValidatorUtils.isNotNull(qo.getApplyDate())) {
                sql += " AND ma.apply_time >= " + qo.getStartTime() + " AND ma.apply_time <= " + qo.getEndTime();
            }
            return sql;
        }


        /**
         * 查询列表的sql
         *
         * @param mer_id
         * @param qo
         * @return
         */
        public String queryList(Integer mer_id, ApplyQueryObject qo) {
            String sql = "SELECT ma.*,mci.car_name,mci.car_color,mci.index_image,mcp.down_pay,mcp.monthly_pay,mcp.term,mci.car_type,mci.car_model " +
                    " FROM mer_apply ma LEFT JOIN mer_car_info mci ON ma.car_id = mci.car_id JOIN mer_car_plan mcp ON ma.plan_id = mcp.plan_id WHERE mci.mer_id = " + mer_id;

            if (ValidatorUtils.isNotNull(qo.getKeyword())) {
                sql += " AND mci.car_name like concat('%','" + qo.getKeyword() + "','%') ";
            }
            if (ValidatorUtils.isNotNull(qo.getApplyDate())) {
                sql += " AND ma.apply_time >= " + qo.getStartTime() + " AND ma.apply_time <= " + qo.getEndTime();
            }
            sql += " limit " + qo.getStartIndex() + "," + qo.getPageSize();
            return sql;
        }

        /**
         * 定金预约数量sql
         *
         * @param mer_id
         * @param qo
         * @return
         */
        public String queryEarnestCount(Integer mer_id, EarnestQueryObject qo) {
            String sql = "SELECT COUNT(0) FROM mer_earnest_order meo LEFT JOIN mer_car_info mci ON meo.car_id = mci.car_id WHERE mci.mer_id = " + mer_id;

            if (ValidatorUtils.isNotNull(qo.getUserName())) {
                sql += " AND meo.user_name like concat('%','" + qo.getUserName() + "','%') ";
            }
            if (ValidatorUtils.isNotNull(qo.getUserPhone())) {
                sql += " AND meo.user_mobile like concat('%','" + qo.getUserPhone() + "','%') ";
            }
            if (ValidatorUtils.isNotNull(qo.getApplyDate())) {
                sql += " AND meo.apply_time >= " + qo.getStartTime() + " AND meo.apply_time <= " + qo.getEndTime();
            }

            return sql;
        }

        /**
         * 定金预约列表sql
         *
         * @param mer_id
         * @param qo
         * @return
         */
        public String queryEarnestList(Integer mer_id, EarnestQueryObject qo) {
            String sql = "SELECT meo.*,mci.car_name,mci.car_color,mci.index_image,mci.car_type,mci.car_model  " +
                    " FROM mer_earnest_order meo LEFT JOIN mer_car_info mci ON meo.car_id = mci.car_id WHERE mci.mer_id = " + mer_id;
            if (ValidatorUtils.isNotNull(qo.getUserName())) {
                sql += " AND meo.user_name like concat('%','" + qo.getUserName() + "','%') ";
            }
            if (ValidatorUtils.isNotNull(qo.getUserPhone())) {
                sql += " AND meo.user_mobile like concat('%','" + qo.getUserPhone() + "','%') ";
            }
            if (ValidatorUtils.isNotNull(qo.getApplyDate())) {
                sql += " AND meo.apply_time >= " + qo.getStartTime() + " AND meo.apply_time <= " + qo.getEndTime();
            }

            sql += " limit " + qo.getStartIndex() + "," + qo.getPageSize();

            return sql;
        }

    }
}
