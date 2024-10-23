package com.ruoyi.gis.service;

import com.ruoyi.gis.domain.GeographicalLines;
import com.ruoyi.gis.domain.GeographicalLines;

import java.util.List;

/**
 * 线状标志Service接口
 *
 * @author ruoyi
 * @date 2024-10-22
 */
public interface IGeographicalLinesService
{

    /**
     * 查询线状标志
     *
     * @param OBJECTID 线状标志主键
     * @return 线状标志
     */
    public GeographicalLines selectGeographicalLinesByOBJECTID(Integer OBJECTID);

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
     * 批量删除线状标志
     *
     * @param OBJECTIDs 需要删除的线状标志主键集合
     * @return 结果
     */
    public int deleteGeographicalLinesByOBJECTIDs(Integer[] OBJECTIDs);

    /**
     * 删除线状标志信息
     *
     * @param OBJECTID 线状标志主键
     * @return 结果
     */
    public int deleteGeographicalLinesByOBJECTID(Integer OBJECTID);
}
