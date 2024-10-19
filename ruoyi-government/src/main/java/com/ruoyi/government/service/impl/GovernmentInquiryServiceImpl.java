package com.ruoyi.government.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.flowable.domain.vo.FlowTaskVo;
import com.ruoyi.flowable.service.IFlowDefinitionService;
import com.ruoyi.flowable.service.IFlowTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.government.mapper.GovernmentInquiryMapper;
import com.ruoyi.government.domain.GovernmentInquiry;
import com.ruoyi.government.service.IGovernmentInquiryService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static com.ruoyi.common.core.domain.AjaxResult.DATA_TAG;

/**
 * 地名预审格Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-15
 */
@Service
public class GovernmentInquiryServiceImpl implements IGovernmentInquiryService 
{
    @Autowired
    private GovernmentInquiryMapper governmentInquiryMapper;

    @Resource GFlowableServiceImpl gFlowableService;

    /**
     * 查询地名预审格
     * 
     * @param inquiryId 地名预审格主键
     * @return 地名预审格
     */
    @Override
    public GovernmentInquiry selectGovernmentInquiryByInquiryId(Long inquiryId)
    {
        return governmentInquiryMapper.selectGovernmentInquiryByInquiryId(inquiryId);
    }


    /**
     * 查询地名预审格
     *
     * @param procInsId 流程实例ID
     * @return 地名预审格
     */
    @Override
    public GovernmentInquiry selectGovernmentInquiryByProcInsId(String procInsId) {
        return governmentInquiryMapper.selectGovernmentInquiryByProcInsId(procInsId);
    }

    /**
     * 查询地名预审格列表
     * 
     * @param governmentInquiry 地名预审格
     * @return 地名预审格
     */
    @Override
    public List<GovernmentInquiry> selectGovernmentInquiryList(GovernmentInquiry governmentInquiry)
    {
        return governmentInquiryMapper.selectGovernmentInquiryList(governmentInquiry);
    }

    /**
     * 新增地名预审格
     * 
     * @param governmentInquiry 地名预审格
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public AjaxResult insertGovernmentInquiry(GovernmentInquiry governmentInquiry) {
        GovernmentInquiry queryGovernmentInquiry  = new GovernmentInquiry();
        queryGovernmentInquiry.setToponym(governmentInquiry.getToponym());
        List<GovernmentInquiry> governmentInquiries = governmentInquiryMapper.selectGovernmentInquiryList(queryGovernmentInquiry);
        if(StringUtils.isNotEmpty(governmentInquiries)){
//            if(inquiry.getInquiryStatus().equals("待审核") || inquiry.getInquiryStatus().equals("已通过")){
//            }
            return AjaxResult.error("已存在地名名称为"+governmentInquiry.getToponym()+"预审申请");
        }

        AjaxResult ajaxResult = gFlowableService.flowTaskStart();
        governmentInquiry.setCreateTime(DateUtils.getNowDate());
        String procInsId = ajaxResult.get(DATA_TAG).toString();
        governmentInquiry.setProcInsId(procInsId);
        governmentInquiry.setInquiryStatus("待审核");
        GovernmentInquiry insertGovernmentInquiry = governmentInquiryMapper.insertGovernmentInquiry(governmentInquiry);

        return StringUtils.isNotNull(insertGovernmentInquiry) ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 修改地名预审格
     * 
     * @param governmentInquiry 地名预审格
     * @return 结果
     */
    @Override
    public int updateGovernmentInquiry(GovernmentInquiry governmentInquiry)
    {
        governmentInquiry.setUpdateTime(DateUtils.getNowDate());
        return governmentInquiryMapper.updateGovernmentInquiry(governmentInquiry);
    }

    /**
     * 批量删除地名预审格
     * 
     * @param inquiryIds 需要删除的地名预审格主键
     * @return 结果
     */
    @Override
    public int deleteGovernmentInquiryByInquiryIds(Long[] inquiryIds)
    {
        return governmentInquiryMapper.deleteGovernmentInquiryByInquiryIds(inquiryIds);
    }

    /**
     * 删除地名预审格信息
     * 
     * @param inquiryId 地名预审格主键
     * @return 结果
     */
    @Override
    public int deleteGovernmentInquiryByInquiryId(Long inquiryId)
    {
        return governmentInquiryMapper.deleteGovernmentInquiryByInquiryId(inquiryId);
    }
}
