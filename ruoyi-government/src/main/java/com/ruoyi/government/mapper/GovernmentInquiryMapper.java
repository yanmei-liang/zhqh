package com.ruoyi.government.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.government.domain.GovernmentInquiry;
import org.apache.ibatis.annotations.Mapper;

/**
 * 地名预审格Mapper接口
 * 
 * @author ruoyi
 * @date 2024-10-15
 */
@Mapper
public interface GovernmentInquiryMapper
{
    /**
     * 查询地名预审格
     * 
     * @param inquiryId 地名预审格主键
     * @return 地名预审格
     */
    public GovernmentInquiry selectGovernmentInquiryByInquiryId(Long inquiryId);

    /**
     * 查询地名预审格
     *
     * @param procInsId 流程实例ID
     * @return 地名预审格
     */
    public GovernmentInquiry selectGovernmentInquiryByProcInsId(String procInsId);



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
     * 删除地名预审格
     * 
     * @param inquiryId 地名预审格主键
     * @return 结果
     */
    public int deleteGovernmentInquiryByInquiryId(Long inquiryId);

    /**
     * 批量删除地名预审格
     * 
     * @param inquiryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGovernmentInquiryByInquiryIds(Long[] inquiryIds);
}
