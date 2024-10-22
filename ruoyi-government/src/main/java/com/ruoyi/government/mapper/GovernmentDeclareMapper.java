package com.ruoyi.government.mapper;

import java.util.List;
import com.ruoyi.government.domain.GovernmentDeclare;
import com.ruoyi.government.domain.StatusCount;

/**
 * 地名申报Mapper接口
 * 
 * @author ruoyi
 * @date 2024-10-15
 */
public interface GovernmentDeclareMapper 
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
    public int insertGovernmentDeclare(GovernmentDeclare governmentDeclare);

    /**
     * 修改地名申报
     * 
     * @param governmentDeclare 地名申报
     * @return 结果
     */
    public int updateGovernmentDeclare(GovernmentDeclare governmentDeclare);

    /**
     * 删除地名申报
     * 
     * @param declareId 地名申报主键
     * @return 结果
     */
    public int deleteGovernmentDeclareByDeclareId(Long declareId);

    /**
     * 批量删除地名申报
     * 
     * @param declareIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGovernmentDeclareByDeclareIds(Long[] declareIds);
}
