package com.ruoyi.government.service;

import java.util.List;
import com.ruoyi.government.domain.GovernmentInquiry;

/**
 * 地名预审格Service接口
 * 
 * @author ruoyi
 * @date 2024-10-15
 */
public interface IGovernmentInquiryService 
{
    /**
     * 查询地名预审格
     * 
     * @param inquiryId 地名预审格主键
     * @return 地名预审格
     */
    public GovernmentInquiry selectGovernmentInquiryByInquiryId(Long inquiryId);

    /**
     * 查询地名预审格列表
     * 
     * @param governmentInquiry 地名预审格
     * @return 地名预审格集合
     */
    public List<GovernmentInquiry> selectGovernmentInquiryList(GovernmentInquiry governmentInquiry);

    /**
     * 新增地名预审格
     * 
     * @param governmentInquiry 地名预审格
     * @return 结果
     */
    public int insertGovernmentInquiry(GovernmentInquiry governmentInquiry);

    /**
     * 修改地名预审格
     * 
     * @param governmentInquiry 地名预审格
     * @return 结果
     */
    public int updateGovernmentInquiry(GovernmentInquiry governmentInquiry);

    /**
     * 批量删除地名预审格
     * 
     * @param inquiryIds 需要删除的地名预审格主键集合
     * @return 结果
     */
    public int deleteGovernmentInquiryByInquiryIds(Long[] inquiryIds);

    /**
     * 删除地名预审格信息
     * 
     * @param inquiryId 地名预审格主键
     * @return 结果
     */
    public int deleteGovernmentInquiryByInquiryId(Long inquiryId);
}
