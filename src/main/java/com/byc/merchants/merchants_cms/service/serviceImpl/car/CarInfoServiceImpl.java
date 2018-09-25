package com.byc.merchants.merchants_cms.service.serviceImpl.car;

import com.byc.merchants.merchants_cms.dao.car.CarFilmMapper;
import com.byc.merchants.merchants_cms.dao.car.CarImageMapper;
import com.byc.merchants.merchants_cms.dao.car.CarInfoMapper;
import com.byc.merchants.merchants_cms.dao.car.CarTermMapper;
import com.byc.merchants.merchants_cms.model.car.*;
import com.byc.merchants.merchants_cms.service.car.CarInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/12 17:16
 * @Description: 车辆信息业务层
 */
@Service("carInfoService")
@Slf4j
public class CarInfoServiceImpl implements CarInfoService{

    @Autowired
    private CarInfoMapper carInfoDao;

    @Autowired
    private CarImageMapper carImageDao;

    @Autowired
    private CarTermMapper carTermDao;

    @Autowired
    private CarFilmMapper carFilmDao;

    /**
     *@描述 初步保存车辆信息
     *@参数 CarInfoModel
     *@返回值 int
     *@创建人  胡丛
     *@创建时间  2018/9/12
     *@修改人和其它信息
     */
    public int firstSaveCarInfo(CarInfoModel model){
        int i = carInfoDao.firstSave(model);
        return i;
    }


    /**
     *@描述 进一步提交车辆信息资料
     *@参数
     *@返回值 int
     *@创建人  胡丛
     *@创建时间  2018/9/17
     *@修改人和其它信息
     */
    @Transactional(rollbackFor = Exception.class)
    public int secondSave(CarSecondModel model){

        //基本信息
        log.info("获取车辆基本信息:"+model.getBasic_information());
        //基本性能
        log.info("获取车辆基本性能:"+model.getBasic_performance());
        //购车说明
        log.info("获取车辆购车说明:"+model.getCar_show());
        CarInfoTwoModel info = new CarInfoTwoModel();
        info.setCar_id(model.getCar_id());
        info.setBasic_information(model.getBasic_information());
        info.setBasic_performance(model.getBasic_performance());
        info.setCar_show(model.getCar_show());
        carInfoDao.updateSencod(info);
        //保存分期方案
        log.info("获取分期方案参数:"+model.getTerms());
        String terms = model.getTerms();
        String[] term = terms.split(",");
        for(int i=0;i<term.length;i++){
            String[] split = term[i].split("、");
            CarTermModel term_model = new CarTermModel();
            for(int j=0;j<3;j++){
                term_model.setCar_id(model.getCar_id());
                term_model.setDown_pay(new BigDecimal(split[0]));
                term_model.setMonthly_pay(new BigDecimal(split[1]));
                term_model.setTerm(Integer.parseInt(split[2]));
            }
            carTermDao.insert(term_model);
        }
        //保存车辆图片
        log.info("车辆图片参数:"+model.getCar_images());
        String images = model.getCar_images();
        String[] car_images = images.split(",");
        for(int k=0;k<car_images.length;k++){
            CarImageModel image = new CarImageModel();
            image.setCar_id(model.getCar_id());
            image.setImage_url(car_images[k]);
            carImageDao.insert(image);
        }


        //车辆实拍
        log.info("获取车辆实拍内容:"+model.getFilm_content()+"      图片:"+model.getFilm_image()+"      标题:"+model.getFilm_title());
        CarFilm film = new CarFilm();
        film.setCar_id(model.getCar_id());
        film.setFilm_content(model.getFilm_content());
        film.setFilm_image(model.getFilm_image());
        film.setFilm_title(model.getFilm_title());
        carFilmDao.insert(film);
        return 0;
    }
}
