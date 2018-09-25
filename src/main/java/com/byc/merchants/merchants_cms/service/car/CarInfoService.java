package com.byc.merchants.merchants_cms.service.car;

import com.byc.merchants.merchants_cms.model.car.CarInfoModel;
import com.byc.merchants.merchants_cms.model.car.CarSecondModel;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/12 17:14
 * @Description: 车辆信息接口
 */
public interface CarInfoService {


    /**
     *@描述 初步保存车辆信息
     *@参数 CarInfoModel
     *@返回值 int
     *@创建人  胡丛
     *@创建时间  2018/9/12
     *@修改人和其它信息
     */
    int firstSaveCarInfo(CarInfoModel model);


    /**
     *@描述 进一步提交车辆信息资料
     *@参数
     *@返回值 int
     *@创建人  胡丛
     *@创建时间  2018/9/17
     *@修改人和其它信息
     */
    int secondSave(CarSecondModel model);
}
