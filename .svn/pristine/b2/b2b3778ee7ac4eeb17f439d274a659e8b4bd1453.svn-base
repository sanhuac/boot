package com.byc.merchants.merchants_cms.dao.product;

import com.byc.merchants.merchants_cms.bean.product.CarImage;
import com.byc.merchants.merchants_cms.bean.product.CarInfo;
import com.byc.merchants.merchants_cms.bean.product.MerCarPlan;
import com.byc.merchants.merchants_cms.model.car.CarFilm;
import com.byc.merchants.merchants_cms.model.car.CarInfoModel;
import com.byc.merchants.merchants_cms.qo.CarQueryObject;
import com.byc.merchants.merchants_cms.util.ValidatorUtils;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * created by pht on 2018/9/18 0018
 */
public interface ProductMapper {

    /**
     * 查询总数
     *
     * @param mer_id
     * @param qo
     * @return
     */
    @SelectProvider(type = ProductSql.class, method = "queryForCarCount")
    int queryForCount(Integer mer_id, CarQueryObject qo);

    /**
     * 查询列表
     *
     * @param mer_id
     * @param qo
     * @return
     */
    @SelectProvider(type = ProductSql.class, method = "queryForCarList")
    List<CarInfo> queryForList(Integer mer_id, CarQueryObject qo);

    /**
     * 查询车辆信息
     *
     * @param car_id
     * @return
     */
    @Select("SELECT mci.*,mcp.monthly_pay,mcp.down_pay,mcp.term FROM mer_car_info mci LEFT JOIN mer_car_plan mcp ON mci.car_id = mcp.car_id WHERE mci.car_id = #{car_id}")
    CarInfoModel selectCarInfoByCarId(Integer car_id);

    /**
     * 上下架
     *
     * @param product_id
     * @return
     */
    @Update("UPDATE mer_car_info SET shelves_status = !shelves_status WHERE car_id = #{product_id}")
    int saleOrNot(Integer product_id);

    /**
     * 删除产品
     *
     * @param id
     * @return
     */
    @Delete("DELETE FROM mer_car_info WHERE car_id = #{id}")
    int deleteProduct(int id);

    /**
     * 查询商品图片
     *
     * @param car_id
     * @return
     */
    @Select("SELECT * FROM mer_car_image WHERE car_id = #{car_id}")
    List<CarImage> selectProductImage(Integer car_id);

    /**
     * 查询实拍
     *
     * @param car_film_id
     * @return
     */
    @Select("SELECT * FROM mer_car_film WHERE film_id = #{car_film_id}")
    CarFilm selectCarFilm(Integer car_film_id);

    /**
     * 查询分期方案
     *
     * @param car_id
     * @return
     */
    @Select("SELECT * FROM mer_car_plan WHERE car_id = #{car_id}")
    List<MerCarPlan> selectPlanList(Integer car_id);

    /**
     * 删除分期方案
     *
     * @param id
     * @return
     */
    @Delete("DELETE FROM mer_car_plan WHERE car_id = #{id}")
    int deleteCarPlanByCarId(int id);

    /**
     * 删除车辆图片
     *
     * @param id
     * @return
     */
    @Delete("DELETE FROM mer_car_image WHERE car_id = #{id}")
    int deleteCarImageByCarId(int id);

    /**
     * 删除车辆实拍
     *
     * @param id
     * @return
     */
    @Delete("DELETE FROM mer_car_film WHERE car_id = #{id}")
    int deleteCarFilmByCarId(int id);


    class ProductSql {
        /**
         * 4s产品查询总数
         *
         * @param mer_id
         * @param qo
         * @return
         */
        public String queryForCarCount(Integer mer_id, CarQueryObject qo) {
            String sql = "SELECT count(0) FROM mer_car_info where mer_id = " + mer_id;

            if (ValidatorUtils.isNotNull(qo.getBrandName())) {
                sql += " AND car_brand like concat('%','" + qo.getBrandName() + "','%') ";
            }

            return sql;
        }

        /**
         * 4s产品查询总数
         *
         * @param mer_id
         * @param qo
         * @return
         */
        public String queryForCarList(Integer mer_id, CarQueryObject qo) {
            String sql = "SELECT car_id,mer_id,car_name,guide_price,shelves_status,index_image,sales_volume FROM mer_car_info where mer_id = " + mer_id;

            if (ValidatorUtils.isNotNull(qo.getBrandName())) {
                sql += " AND car_brand like concat('%','" + qo.getBrandName() + "','%') ";
            }
            sql += " limit " + qo.getStartIndex() + "," + qo.getPageSize();
            return sql;
        }


    }


}
