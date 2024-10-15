package com.ruoyi.government.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.government.mapper.GovernmentRecordMapper;
import com.ruoyi.government.domain.GovernmentRecord;
import com.ruoyi.government.service.IGovernmentRecordService;

/**
 * 地名备案Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-15
 */
@Service
public class GovernmentRecordServiceImpl implements IGovernmentRecordService 
{
    @Autowired
    private GovernmentRecordMapper governmentRecordMapper;

    /**
     * 查询地名备案
     * 
     * @param recordId 地名备案主键
     * @return 地名备案
     */
    @Override
    public GovernmentRecord selectGovernmentRecordByRecordId(Long recordId)
    {
        return governmentRecordMapper.selectGovernmentRecordByRecordId(recordId);
    }

    /**
     * 查询地名备案列表
     * 
     * @param governmentRecord 地名备案
     * @return 地名备案
     */
    @Override
    public List<GovernmentRecord> selectGovernmentRecordList(GovernmentRecord governmentRecord)
    {
        return governmentRecordMapper.selectGovernmentRecordList(governmentRecord);
    }

    /**
     * 新增地名备案
     * 
     * @param governmentRecord 地名备案
     * @return 结果
     */
    @Override
    public int insertGovernmentRecord(GovernmentRecord governmentRecord)
    {
        governmentRecord.setCreateTime(DateUtils.getNowDate());
        return governmentRecordMapper.insertGovernmentRecord(governmentRecord);
    }

    /**
     * 修改地名备案
     * 
     * @param governmentRecord 地名备案
     * @return 结果
     */
    @Override
    public int updateGovernmentRecord(GovernmentRecord governmentRecord)
    {
        governmentRecord.setUpdateTime(DateUtils.getNowDate());
        return governmentRecordMapper.updateGovernmentRecord(governmentRecord);
    }

    /**
     * 批量删除地名备案
     * 
     * @param recordIds 需要删除的地名备案主键
     * @return 结果
     */
    @Override
    public int deleteGovernmentRecordByRecordIds(Long[] recordIds)
    {
        return governmentRecordMapper.deleteGovernmentRecordByRecordIds(recordIds);
    }

    /**
     * 删除地名备案信息
     * 
     * @param recordId 地名备案主键
     * @return 结果
     */
    @Override
    public int deleteGovernmentRecordByRecordId(Long recordId)
    {
        return governmentRecordMapper.deleteGovernmentRecordByRecordId(recordId);
    }
}
