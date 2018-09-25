package com.byc.merchants.merchants_cms.service.serviceImpl.apply;/**
 * created by pht on 2018/9/17 0017
 */

import com.byc.merchants.merchants_cms.bean.apply.MerApply;
import com.byc.merchants.merchants_cms.bean.apply.MerEarnest;
import com.byc.merchants.merchants_cms.constant.Constant;
import com.byc.merchants.merchants_cms.dao.apply.ApplyMapper;
import com.byc.merchants.merchants_cms.exception.UnifiedException;
import com.byc.merchants.merchants_cms.qo.ApplyQueryObject;
import com.byc.merchants.merchants_cms.qo.EarnestQueryObject;
import com.byc.merchants.merchants_cms.qo.PageResult;
import com.byc.merchants.merchants_cms.service.apply.ApplyService;
import com.byc.merchants.merchants_cms.util.TimeUtils;
import com.byc.merchants.merchants_cms.util.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author pht
 * @program merchants_cms
 * @date 2018/9/17 0017
 */
@Service
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private ApplyMapper applyMapper;

    /**
     * 预约列表
     *
     * @param mer_id
     * @param qo
     * @return
     */
    @Override
    public PageResult subscribeList(Integer mer_id, ApplyQueryObject qo) throws UnifiedException {

        //多余的校验
        if (ValidatorUtils.isNull(mer_id)) {
            throw new UnifiedException(200014);
        }
        //时间处理
        Date applyDate = qo.getApplyDate();
        if (ValidatorUtils.isNotNull(applyDate)) {
            String format = TimeUtils.format(applyDate, "yyyy-MM-dd");
            //日期转时间戳
            long stampByDate = TimeUtils.getTimeStampByDate(format, "yyyy-MM-dd");
            //拿到一天的开始
            long startTime = TimeUtils.getDayTimeBegin(stampByDate) / 1000;
            //拿到结束时间
            long endTime = TimeUtils.getDayTimeEnd(stampByDate) / 1000;
            qo.setStartTime(Integer.parseInt(startTime + ""));
            qo.setEndTime(Integer.parseInt(endTime + ""));
        }
        //查询总数
        Integer count = applyMapper.queryForCount(mer_id, qo);
        PageResult pageResult = PageResult.emptyResult();
        if (count > 0) {
            List<MerApply> applyList = applyMapper.queryForList(mer_id, qo);
            for (MerApply merApply : applyList) {
                merApply.setIndex_image(Constant.getInstance().PIC_URL_PREFIX + merApply.getIndex_image());
            }
            pageResult = new PageResult(qo.getCurrentPage(), qo.getPageSize(), count, applyList);
        }
        //查询列表
        return pageResult;
    }

    /**
     * 定金预约列表
     *
     * @param mer_id
     * @param qo
     * @return
     */
    @Override
    public PageResult earnestList(Integer mer_id, EarnestQueryObject qo) throws UnifiedException {
        //不必要的校验
        if (ValidatorUtils.isNull(mer_id)) {
            throw new UnifiedException(200014);
        }
        //时间处理
        Date applyDate = qo.getApplyDate();
        if (ValidatorUtils.isNotNull(applyDate)) {
            String format = TimeUtils.format(applyDate, "yyyy-MM-dd");
            //日期转时间戳
            long stampByDate = TimeUtils.getTimeStampByDate(format, "yyyy-MM-dd");
            //拿到结束时间
            long endTime = TimeUtils.getDayTimeEnd(stampByDate) / 1000;
            //拿到一天的开始
            long startTime = TimeUtils.getDayTimeBegin(stampByDate) / 1000;
            qo.setStartTime(Integer.parseInt(startTime + ""));
            qo.setEndTime(Integer.parseInt(endTime + ""));
        }

        //查询总数
        Integer count = applyMapper.queryForEarnestCount(mer_id, qo);
        PageResult pageResult = PageResult.emptyResult();
        if (count > 0) {
            List<MerEarnest> earnestList = applyMapper.queryForEarnestList(mer_id, qo);
            for (MerEarnest earnest : earnestList) {
                earnest.setIndex_image(Constant.getInstance().PIC_URL_PREFIX + earnest.getIndex_image());
            }
            pageResult = new PageResult(qo.getCurrentPage(), qo.getPageSize(), count, earnestList);
        }
        //查询列表
        return pageResult;
    }
}
