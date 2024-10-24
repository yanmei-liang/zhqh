package com.ruoyi.gis.mapper;

import java.util.List;

import com.ruoyi.gis.domain.GeographicalNames;

/**
 * 地名标志Mapper接口
 *
 * @author ruoyi
 * @date 2024-10-21
 */
public interface GeographicalNamesMapper
{

    /**
     * 查询地名标志
     *
     * @param ID 地名标志主键
     * @return 地名标志
     */
    public GeographicalNames selectGeographicalNamesByOBJECTID(Integer ID);

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
     * 删除地名标志
     *
     * @param ID 地名标志主键
     * @return 结果
     */
    public int deleteGeographicalNamesByOBJECTID(Integer ID);

    /**
     * 批量删除地名标志
     *
     * @param IDS 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGeographicalNamesByOBJECTIDs(Integer[] IDS);

    List<GeographicalNames> queryByXZQHCode(String code);
}
