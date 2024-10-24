package com.ruoyi.gis.service;

import com.ruoyi.gis.domain.GeographicalPoints;
import com.ruoyi.gis.domain.GeographicalPoints;

import java.util.List;

/**
 * 点状标志Service接口
 *
 * @author ruoyi
 * @date 2024-10-22
 */
public interface IGeographicalPointsService
{

    List<GeographicalPoints> queryByXZQHCode(String code);

    /**
     * 查询点状标志
     *
     * @param OBJECTID 点状标志主键
     * @return 点状标志
     */
    public GeographicalPoints selectGeographicalPointsByOBJECTID(Integer OBJECTID);

    /**
     * 查询点状标志列表
     *
     * @param geographicalPoints 点状标志
     * @return 点状标志集合
     */
    public List<GeographicalPoints> selectGeographicalPointsList(GeographicalPoints geographicalPoints);

    /**
     * 新增点状标志
     *
     * @param geographicalPoints 点状标志
     * @return 结果
     */
    public int insertGeographicalPoints(GeographicalPoints geographicalPoints);

    /**
     * 修改点状标志
     *
     * @param geographicalPoints 点状标志
     * @return 结果
     */
    public int updateGeographicalPoints(GeographicalPoints geographicalPoints);

    /**
     * 批量删除点状标志
     *
     * @param OBJECTIDs 需要删除的点状标志主键集合
     * @return 结果
     */
    public int deleteGeographicalPointsByOBJECTIDs(Integer[] OBJECTIDs);

    /**
     * 删除点状标志信息
     *
     * @param OBJECTID 点状标志主键
     * @return 结果
     */
    public int deleteGeographicalPointsByOBJECTID(Integer OBJECTID);
}
