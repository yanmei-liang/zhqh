package com.ruoyi.government.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.government.mapper.GovernmentInquiryMapper;
import com.ruoyi.government.domain.GovernmentInquiry;
import com.ruoyi.government.service.IGovernmentInquiryService;

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
    @Override
    public int insertGovernmentInquiry(GovernmentInquiry governmentInquiry)
    {
        governmentInquiry.setCreateTime(DateUtils.getNowDate());
        return governmentInquiryMapper.insertGovernmentInquiry(governmentInquiry);
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
