package com.byc.merchants.merchants_cms.service.serviceImpl.apply;/**
 * created by pht on 2018/9/17 0017
 */

import com.byc.merchants.merchants_cms.bean.apply.MerInsuranceApply;
import com.byc.merchants.merchants_cms.dao.apply.InsuranceMapper;
import com.byc.merchants.merchants_cms.exception.UnifiedException;
import com.byc.merchants.merchants_cms.qo.InsuranceQueryObject;
import com.byc.merchants.merchants_cms.qo.PageResult;
import com.byc.merchants.merchants_cms.service.apply.InsuranceService;
import com.byc.merchants.merchants_cms.util.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pht
 * @program merchants_cms
 * @date 2018/9/17 0017
 */
@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    private InsuranceMapper insuranceMapper;


    /**
     * 保险预约列表
     *
     * @param mer_id
     * @param qo
     * @return
     */
    @Override
    public PageResult insuranceList(Integer mer_id, InsuranceQueryObject qo) throws UnifiedException {
        //校验
        if (ValidatorUtils.isNull(mer_id)) {
            throw new UnifiedException(200014);
        }

        //查询总数
        Integer count = insuranceMapper.queryForCount(mer_id, qo);
        PageResult pageResult = PageResult.emptyResult();
        if (count > 0) {
            List<MerInsuranceApply> applyList = insuranceMapper.queryForList(mer_id, qo);
            pageResult = new PageResult(qo.getCurrentPage(), qo.getPageSize(), count, applyList);
        }
        //查询列表
        return pageResult;
    }
}
