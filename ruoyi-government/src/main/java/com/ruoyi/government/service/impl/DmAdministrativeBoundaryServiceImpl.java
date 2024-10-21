package com.ruoyi.government.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.government.domain.vo.ExportFileDmAdministrativeBoundary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.government.mapper.DmAdministrativeBoundaryMapper;
import com.ruoyi.government.domain.DmAdministrativeBoundary;
import com.ruoyi.government.service.IDmAdministrativeBoundaryService;

/**
 * 行政界线Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-14
 */
@Service
public class DmAdministrativeBoundaryServiceImpl implements IDmAdministrativeBoundaryService 
{
    @Autowired
    private DmAdministrativeBoundaryMapper dmAdministrativeBoundaryMapper;

    /**
     * 查询总条数
     *
     */
    @Override
    public Integer selectDmAdministrativeBoundaryCount(DmAdministrativeBoundary dmAdministrativeBoundary){
        return dmAdministrativeBoundaryMapper.selectDmAdministrativeBoundaryCount(dmAdministrativeBoundary);
    }

    /**
     * 按界线等级统计
     */
    @Override
    public List<ExportFileDmAdministrativeBoundary> selectRankStatistics(){
        return dmAdministrativeBoundaryMapper.selectRankStatistics();
    }

    /**
     * 按界线区划统计
     */
    @Override
    public  List<ExportFileDmAdministrativeBoundary> selectDivisionStatistics(){
        return dmAdministrativeBoundaryMapper.selectDivisionStatistics();
    }

    /**
     * 查询行政界线
     * 
     * @param boundaryId 行政界线主键
     * @return 行政界线
     */
    @Override
    public DmAdministrativeBoundary selectDmAdministrativeBoundaryByBoundaryId(Long boundaryId)
    {
        return dmAdministrativeBoundaryMapper.selectDmAdministrativeBoundaryByBoundaryId(boundaryId);
    }

    /**
     * 查询行政界线列表
     * 
     * @param dmAdministrativeBoundary 行政界线
     * @return 行政界线
     */
    @Override
    public List<DmAdministrativeBoundary> selectDmAdministrativeBoundaryList(DmAdministrativeBoundary dmAdministrativeBoundary)
    {
        return dmAdministrativeBoundaryMapper.selectDmAdministrativeBoundaryList(dmAdministrativeBoundary);
    }

    /**
     * 新增行政界线
     * 
     * @param dmAdministrativeBoundary 行政界线
     * @return 结果
     */
    @Override
    public int insertDmAdministrativeBoundary(DmAdministrativeBoundary dmAdministrativeBoundary)
    {
        dmAdministrativeBoundary.setCreateTime(DateUtils.getNowDate());
        return dmAdministrativeBoundaryMapper.insertDmAdministrativeBoundary(dmAdministrativeBoundary);
    }

    /**
     * 修改行政界线
     * 
     * @param dmAdministrativeBoundary 行政界线
     * @return 结果
     */
    @Override
    public int updateDmAdministrativeBoundary(DmAdministrativeBoundary dmAdministrativeBoundary)
    {
        dmAdministrativeBoundary.setUpdateTime(DateUtils.getNowDate());
        return dmAdministrativeBoundaryMapper.updateDmAdministrativeBoundary(dmAdministrativeBoundary);
    }

    /**
     * 批量删除行政界线
     * 
     * @param boundaryIds 需要删除的行政界线主键
     * @return 结果
     */
    @Override
    public int deleteDmAdministrativeBoundaryByBoundaryIds(Long[] boundaryIds)
    {
        return dmAdministrativeBoundaryMapper.deleteDmAdministrativeBoundaryByBoundaryIds(boundaryIds);
    }

    /**
     * 删除行政界线信息
     * 
     * @param boundaryId 行政界线主键
     * @return 结果
     */
    @Override
    public int deleteDmAdministrativeBoundaryByBoundaryId(Long boundaryId)
    {
        return dmAdministrativeBoundaryMapper.deleteDmAdministrativeBoundaryByBoundaryId(boundaryId);
    }
}
