package com.ruoyi.government.mapper;

import java.util.List;
import com.ruoyi.government.domain.DmAdministrativeDivisions;

/**
 * 行政区划Mapper接口
 * 
 * @author ruoyi
 * @date 2024-10-14
 */
public interface DmAdministrativeDivisionsMapper
{

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
     * 删除行政区划
     * 
     * @param ID 行政区划主键
     * @return 结果
     */
    public int deleteDmAdministrativeDivisionsByID(Long ID);

    /**
     * 批量删除行政区划
     * 
     * @param IDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDmAdministrativeDivisionsByIDs(Long[] IDs);
}
