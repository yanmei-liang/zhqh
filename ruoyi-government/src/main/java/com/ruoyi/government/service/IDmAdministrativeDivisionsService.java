package com.ruoyi.government.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.government.domain.DmAdministrativeDivisions;
import com.ruoyi.government.domain.vo.ExportFile;

/**
 * 行政区划Service接口
 * 
 * @author ruoyi
 * @date 2024-10-14
 */
public interface IDmAdministrativeDivisionsService
{

    /**
     * 导出类别
     *
     */
    public List<ExportFile> exportSelStatisticallevel(String superiorsCode);

    /**
     * 导出面积统计
     *
     */
    public List<ExportFile> exportselAreaRadius(String superiorsCode);

    /**
     * 查询总条数
     *
     */
    public Integer selectDmAdministrativeCount(DmAdministrativeDivisions dmAdministrativeDivisions);

    /**
     * 范围筛选数据
     *
     */
    public List<Map<String,Integer>> selAreaRadius(String superiorsCode);

    /**
     * 返回行政级别下拉框
     *
     */
    public List<Map<String,Integer>> selStatisticallevel(String superiorsCode);

    /**
     * 返回行政级别下拉框
     *
     */
    public List<String> selectDmAdministrativeByAdministrativeLevel();

    /**
     * 查询行政区划
     * 
     * @param ID 行政区划主键
     * @return 行政区划
     */
    public DmAdministrativeDivisions selectDmAdministrativeDivisionsByID(Long ID);

    /**
     * 查询行政区划列表
     * 
     * @param dmAdministrativeDivisions 行政区划
     * @return 行政区划集合
     */
    public List<DmAdministrativeDivisions> selectDmAdministrativeDivisionsList(DmAdministrativeDivisions dmAdministrativeDivisions);

    /**
     * 新增行政区划
     * 
     * @param dmAdministrativeDivisions 行政区划
     * @return 结果
     */
    public int insertDmAdministrativeDivisions(DmAdministrativeDivisions dmAdministrativeDivisions);

    /**
     * 修改行政区划
     * 
     * @param dmAdministrativeDivisions 行政区划
     * @return 结果
     */
    public int updateDmAdministrativeDivisions(DmAdministrativeDivisions dmAdministrativeDivisions);

    /**
     * 批量删除行政区划
     * 
     * @param IDs 需要删除的行政区划主键集合
     * @return 结果
     */
    public int deleteDmAdministrativeDivisionsByIDs(Long[] IDs);

    /**
     * 删除行政区划信息
     * 
     * @param ID 行政区划主键
     * @return 结果
     */
    public int deleteDmAdministrativeDivisionsByID(Long ID);
}
