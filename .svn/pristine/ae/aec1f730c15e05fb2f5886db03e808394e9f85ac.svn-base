package com.byc.merchants.merchants_cms.service.serviceImpl.common;

import com.byc.merchants.merchants_cms.bean.common.Area;
import com.byc.merchants.merchants_cms.dao.common.AreaMapper;
import com.byc.merchants.merchants_cms.exception.UnifiedException;
import com.byc.merchants.merchants_cms.service.common.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 胡丛
 * @Date: 2018/9/7 16:29
 * @Description:
 */
@Service("areaService")
public class AreaServiceImpl implements AreaService{

    @Autowired
    private AreaMapper areaDao;

    /**
     * 根据父编码查询子编码
     * @return
     */
    public List<Area> subArea(String area_no) throws UnifiedException{

        if(!"0".equals(area_no)){
            int c = areaDao.areaNum(area_no);
            if(c<=0){
                throw new UnifiedException(300000);
            }
        }
        List<Area> list = areaDao.areas(area_no);
        if(list.size()<=0) {
            throw new UnifiedException(300001);
        }
        return list;

    }
}
