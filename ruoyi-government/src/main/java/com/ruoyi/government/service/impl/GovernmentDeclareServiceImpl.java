package com.ruoyi.government.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.government.mapper.GovernmentDeclareMapper;
import com.ruoyi.government.domain.GovernmentDeclare;
import com.ruoyi.government.service.IGovernmentDeclareService;

/**
 * 地名申报Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-15
 */
@Service
public class GovernmentDeclareServiceImpl implements IGovernmentDeclareService 
{
    @Autowired
    private GovernmentDeclareMapper governmentDeclareMapper;

    /**
     * 查询地名申报
     * 
     * @param declareId 地名申报主键
     * @return 地名申报
     */
    @Override
    public GovernmentDeclare selectGovernmentDeclareByDeclareId(Long declareId)
    {
        return governmentDeclareMapper.selectGovernmentDeclareByDeclareId(declareId);
    }

    /**
     * 查询地名申报列表
     * 
     * @param governmentDeclare 地名申报
     * @return 地名申报
     */
    @Override
    public List<GovernmentDeclare> selectGovernmentDeclareList(GovernmentDeclare governmentDeclare)
    {
        return governmentDeclareMapper.selectGovernmentDeclareList(governmentDeclare);
    }

    /**
     * 新增地名申报
     * 
     * @param governmentDeclare 地名申报
     * @return 结果
     */
    @Override
    public int insertGovernmentDeclare(GovernmentDeclare governmentDeclare)
    {
        governmentDeclare.setCreateTime(DateUtils.getNowDate());
        return governmentDeclareMapper.insertGovernmentDeclare(governmentDeclare);
    }

    /**
     * 修改地名申报
     * 
     * @param governmentDeclare 地名申报
     * @return 结果
     */
    @Override
    public int updateGovernmentDeclare(GovernmentDeclare governmentDeclare)
    {
        governmentDeclare.setUpdateTime(DateUtils.getNowDate());
        return governmentDeclareMapper.updateGovernmentDeclare(governmentDeclare);
    }

    /**
     * 批量删除地名申报
     * 
     * @param declareIds 需要删除的地名申报主键
     * @return 结果
     */
    @Override
    public int deleteGovernmentDeclareByDeclareIds(Long[] declareIds)
    {
        return governmentDeclareMapper.deleteGovernmentDeclareByDeclareIds(declareIds);
    }

    /**
     * 删除地名申报信息
     * 
     * @param declareId 地名申报主键
     * @return 结果
     */
    @Override
    public int deleteGovernmentDeclareByDeclareId(Long declareId)
    {
        return governmentDeclareMapper.deleteGovernmentDeclareByDeclareId(declareId);
    }
}
