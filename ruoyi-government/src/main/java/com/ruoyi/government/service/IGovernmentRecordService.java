package com.ruoyi.government.service;

import java.util.List;
import com.ruoyi.government.domain.GovernmentRecord;

/**
 * 地名备案Service接口
 * 
 * @author ruoyi
 * @date 2024-10-15
 */
public interface IGovernmentRecordService 
{
    /**
     * 查询地名备案
     * 
     * @param recordId 地名备案主键
     * @return 地名备案
     */
    public GovernmentRecord selectGovernmentRecordByRecordId(Long recordId);

    /**
     * 查询地名备案列表
     * 
     * @param governmentRecord 地名备案
     * @return 地名备案集合
     */
    public List<GovernmentRecord> selectGovernmentRecordList(GovernmentRecord governmentRecord);

    /**
     * 新增地名备案
     * 
     * @param governmentRecord 地名备案
     * @return 结果
     */
    public int insertGovernmentRecord(GovernmentRecord governmentRecord);

    /**
     * 修改地名备案
     * 
     * @param governmentRecord 地名备案
     * @return 结果
     */
    public int updateGovernmentRecord(GovernmentRecord governmentRecord);

    /**
     * 批量删除地名备案
     * 
     * @param recordIds 需要删除的地名备案主键集合
     * @return 结果
     */
    public int deleteGovernmentRecordByRecordIds(Long[] recordIds);

    /**
     * 删除地名备案信息
     * 
     * @param recordId 地名备案主键
     * @return 结果
     */
    public int deleteGovernmentRecordByRecordId(Long recordId);
}
