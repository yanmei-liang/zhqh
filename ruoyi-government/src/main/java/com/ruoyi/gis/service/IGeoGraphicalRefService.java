package com.ruoyi.gis.service;

import com.ruoyi.gis.domain.GeoGraphicalRef;
import com.ruoyi.gis.domain.GeoGraphicalRef;

import java.util.List;

/**
 * 地图空间数据和地名关联Service接口
 *
 * @author ruoyi
 * @date 2024-10-22
 */
public interface IGeoGraphicalRefService
{

    /**
     * 查询地图空间数据和地名关联
     *
     * @param OBJECTID 地图空间数据和地名关联主键
     * @return 地图空间数据和地名关联
     */
    public GeoGraphicalRef selectGeoGraphicalRefByOBJECTID(Integer OBJECTID);

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
     * 批量删除地图空间数据和地名关联
     *
     * @param OBJECTIDs 需要删除的地图空间数据和地名关联主键集合
     * @return 结果
     */
    public int deleteGeoGraphicalRefByOBJECTIDs(Integer[] OBJECTIDs);

    /**
     * 删除地图空间数据和地名关联信息
     *
     * @param OBJECTID 地图空间数据和地名关联主键
     * @return 结果
     */
    public int deleteGeoGraphicalRefByOBJECTID(Integer OBJECTID);
}
