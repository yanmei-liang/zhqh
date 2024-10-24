package com.ruoyi.gis.service;

import java.util.List;

import com.ruoyi.gis.domain.GeographicalNames;

/**
 * 地名标志Service接口
 *
 * @author ruoyi
 * @date 2024-10-21
 */
public interface IGeographicalNamesService
{

    List<GeographicalNames> queryByXZQHCode(String code);

    /**
     * 查询地名标志
     *
     * @param OBJECTID 地名标志主键
     * @return 地名标志
     */
    public GeographicalNames selectGeographicalNamesByOBJECTID(Integer OBJECTID);

    /**
     * 查询地名标志列表
     *
     * @param geographicalNames 地名标志
     * @return 地名标志集合
     */
    public List<GeographicalNames> selectGeographicalNamesList(GeographicalNames geographicalNames);

    /**
     * 新增地名标志
     *
     * @param geographicalNames 地名标志
     * @return 结果
     */
    public int insertGeographicalNames(GeographicalNames geographicalNames);

    /**
     * 修改地名标志
     *
     * @param geographicalNames 地名标志
     * @return 结果
     */
    public int updateGeographicalNames(GeographicalNames geographicalNames);

    /**
     * 批量删除地名标志
     *
     * @param OBJECTIDs 需要删除的地名标志主键集合
     * @return 结果
     */
    public int deleteGeographicalNamesByOBJECTIDs(Integer[] OBJECTIDs);

    /**
     * 删除地名标志信息
     *
     * @param OBJECTID 地名标志主键
     * @return 结果
     */
    public int deleteGeographicalNamesByOBJECTID(Integer OBJECTID);
}
