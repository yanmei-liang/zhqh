package com.ruoyi.gis.mapper;

import com.ruoyi.gis.domain.GeographicalLines;

import java.util.List;

/**
 * 线状标志Mapper接口
 *
 * @author ruoyi
 * @date 2024-10-22
 */
public interface GeographicalLinesMapper
{

    /**
     * 查询线状标志
     *
     * @param ID 线状标志主键
     * @return 线状标志
     */
    public GeographicalLines selectGeographicalLinesByOBJECTID(Integer ID);

    /**
     * 查询线状标志列表
     *
     * @param geographicalLines 线状标志
     * @return 线状标志集合
     */
    public List<GeographicalLines> selectGeographicalLinesList(GeographicalLines geographicalLines);

    /**
     * 新增线状标志
     *
     * @param geographicalLines 线状标志
     * @return 结果
     */
    public int insertGeographicalLines(GeographicalLines geographicalLines);

    /**
     * 修改线状标志
     *
     * @param geographicalLines 线状标志
     * @return 结果
     */
    public int updateGeographicalLines(GeographicalLines geographicalLines);

    /**
     * 删除线状标志
     *
     * @param ID 线状标志主键
     * @return 结果
     */
    public int deleteGeographicalLinesByOBJECTID(Integer ID);

    /**
     * 批量删除线状标志
     *
     * @param IDS 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGeographicalLinesByOBJECTIDs(Integer[] IDS);

    List<GeographicalLines> queryByXZQHCode(String code);
}
