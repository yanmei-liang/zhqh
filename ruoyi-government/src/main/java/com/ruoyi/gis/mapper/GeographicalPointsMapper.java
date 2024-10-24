package com.ruoyi.gis.mapper;

import com.ruoyi.gis.domain.GeographicalPoints;
import com.ruoyi.gis.domain.GeographicalPoints;

import java.util.List;

/**
 * 点状标志Mapper接口
 *
 * @author ruoyi
 * @date 2024-10-22
 */
public interface GeographicalPointsMapper
{

    /**
     * 查询点状标志
     *
     * @param ID 点状标志主键
     * @return 点状标志
     */
    public GeographicalPoints selectGeographicalPointsByOBJECTID(Integer ID);

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
     * 删除点状标志
     *
     * @param ID 点状标志主键
     * @return 结果
     */
    public int deleteGeographicalPointsByOBJECTID(Integer ID);

    /**
     * 批量删除点状标志
     *
     * @param IDS 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGeographicalPointsByOBJECTIDs(Integer[] IDS);

    List<GeographicalPoints> queryByXZQHCode(String code);
}
