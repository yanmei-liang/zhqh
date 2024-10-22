package com.ruoyi.gis.mapper;

import com.ruoyi.gis.domain.GeoGraphicalRef;

import java.util.List;

/**
 * 地图空间数据和地名关联Mapper接口
 *
 * @author ruoyi
 * @date 2024-10-22
 */
public interface GeoGraphicalRefMapper
{

    /**
     * 查询地图空间数据和地名关联
     *
     * @param ID 地图空间数据和地名关联主键
     * @return 地图空间数据和地名关联
     */
    public GeoGraphicalRef selectGeoGraphicalRefByOBJECTID(Integer ID);

    /**
     * 查询地图空间数据和地名关联列表
     *
     * @param geoGraphicalRef 地图空间数据和地名关联
     * @return 地图空间数据和地名关联集合
     */
    public List<GeoGraphicalRef> selectGeoGraphicalRefList(GeoGraphicalRef geoGraphicalRef);

    /**
     * 新增地图空间数据和地名关联
     *
     * @param geoGraphicalRef 地图空间数据和地名关联
     * @return 结果
     */
    public int insertGeoGraphicalRef(GeoGraphicalRef geoGraphicalRef);

    /**
     * 修改地图空间数据和地名关联
     *
     * @param geoGraphicalRef 地图空间数据和地名关联
     * @return 结果
     */
    public int updateGeoGraphicalRef(GeoGraphicalRef geoGraphicalRef);

    /**
     * 删除地图空间数据和地名关联
     *
     * @param ID 地图空间数据和地名关联主键
     * @return 结果
     */
    public int deleteGeoGraphicalRefByOBJECTID(Integer ID);

    /**
     * 批量删除地图空间数据和地名关联
     *
     * @param IDS 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGeoGraphicalRefByOBJECTIDs(Integer[] IDS);

}
