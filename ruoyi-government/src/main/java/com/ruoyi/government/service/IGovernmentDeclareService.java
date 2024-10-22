package com.ruoyi.government.service;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.government.domain.GovernmentDeclare;
import com.ruoyi.government.domain.StatusCount;

/**
 * 地名申报Service接口
 * 
 * @author ruoyi
 * @date 2024-10-15
 */
public interface IGovernmentDeclareService 
{
    /**
     * 查询地名申报
     * 
     * @param declareId 地名申报主键
     * @return 地名申报
     */
    public GovernmentDeclare selectGovernmentDeclareByDeclareId(Long declareId);


    public List<StatusCount> selectGovernmentDeclareStatusCount();

    /**
     * 查询地名申报
     *
     * @param procInsId 流程实例ID
     * @return 地名申报
     */
    public GovernmentDeclare selectGovernmentDeclareByProcInsId(String procInsId);

    /**
     * 查询地名申报列表
     * 
     * @param governmentDeclare 地名申报
     * @return 地名申报集合
     */
    public List<GovernmentDeclare> selectGovernmentDeclareList(GovernmentDeclare governmentDeclare);

    /**
     * 新增地名申报
     * 
     * @param governmentDeclare 地名申报
     * @return 结果
     */
    public AjaxResult insertGovernmentDeclare(GovernmentDeclare governmentDeclare);

    /**
     * 修改地名申报
     * 
     * @param governmentDeclare 地名申报
     * @return 结果
     */
    public int updateGovernmentDeclare(GovernmentDeclare governmentDeclare);

    /**
     * 批量删除地名申报
     * 
     * @param declareIds 需要删除的地名申报主键集合
     * @return 结果
     */
    public int deleteGovernmentDeclareByDeclareIds(Long[] declareIds);

    /**
     * 删除地名申报信息
     * 
     * @param declareId 地名申报主键
     * @return 结果
     */
    public int deleteGovernmentDeclareByDeclareId(Long declareId);
}
