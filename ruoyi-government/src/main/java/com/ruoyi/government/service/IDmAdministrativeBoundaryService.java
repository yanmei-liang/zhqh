package com.ruoyi.government.service;

import java.util.List;
import com.ruoyi.government.domain.DmAdministrativeBoundary;
import com.ruoyi.government.domain.vo.ExportFileDmAdministrativeBoundary;

/**
 * 行政界线Service接口
 * 
 * @author ruoyi
 * @date 2024-10-14
 */
public interface IDmAdministrativeBoundaryService 
{

    /**
     * 查询总条数
     *
     */
    public Integer selectDmAdministrativeBoundaryCount(DmAdministrativeBoundary dmAdministrativeBoundary);

    /**
     * 按界线等级统计
     */
    public List<ExportFileDmAdministrativeBoundary> selectRankStatistics();

    /**
     * 按界线区划统计
     */
    public  List<ExportFileDmAdministrativeBoundary> selectDivisionStatistics();

    /**
     * 查询行政界线
     * 
     * @param boundaryId 行政界线主键
     * @return 行政界线
     */
    public DmAdministrativeBoundary selectDmAdministrativeBoundaryByBoundaryId(Long boundaryId);

    /**
     * 查询行政界线列表
     * 
     * @param dmAdministrativeBoundary 行政界线
     * @return 行政界线集合
     */
    public List<DmAdministrativeBoundary> selectDmAdministrativeBoundaryList(DmAdministrativeBoundary dmAdministrativeBoundary);

    /**
     * 新增行政界线
     * 
     * @param dmAdministrativeBoundary 行政界线
     * @return 结果
     */
    public int insertDmAdministrativeBoundary(DmAdministrativeBoundary dmAdministrativeBoundary);

    /**
     * 修改行政界线
     * 
     * @param dmAdministrativeBoundary 行政界线
     * @return 结果
     */
    public int updateDmAdministrativeBoundary(DmAdministrativeBoundary dmAdministrativeBoundary);

    /**
     * 批量删除行政界线
     * 
     * @param boundaryIds 需要删除的行政界线主键集合
     * @return 结果
     */
    public int deleteDmAdministrativeBoundaryByBoundaryIds(Long[] boundaryIds);

    /**
     * 删除行政界线信息
     * 
     * @param boundaryId 行政界线主键
     * @return 结果
     */
    public int deleteDmAdministrativeBoundaryByBoundaryId(Long boundaryId);
}
