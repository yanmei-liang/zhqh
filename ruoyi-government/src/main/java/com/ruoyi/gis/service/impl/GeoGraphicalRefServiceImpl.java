package com.ruoyi.gis.service.impl;

import com.ruoyi.gis.domain.GeoGraphicalRef;
import com.ruoyi.gis.mapper.GeoGraphicalRefMapper;
import com.ruoyi.gis.service.IGeoGraphicalRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 地图空间数据和地名关联Service业务层处理
 *
 * @author ruoyi
 * @date 2024-10-22
 */
@Service
public class GeoGraphicalRefServiceImpl implements IGeoGraphicalRefService
{
    @Autowired
    private GeoGraphicalRefMapper geoGraphicalRefMapper;

    /**
     * 查询地图空间数据和地名关联
     *
     * @param OBJECTID 地图空间数据和地名关联主键
     * @return 地图空间数据和地名关联
     */
    @Override
    public GeoGraphicalRef selectGeoGraphicalRefByOBJECTID(Integer OBJECTID)
    {
        return geoGraphicalRefMapper.selectGeoGraphicalRefByOBJECTID(OBJECTID);
    }

    /**
     * 查询地图空间数据和地名关联列表
     *
     * @param geoGraphicalRef 地图空间数据和地名关联
     * @return 地图空间数据和地名关联
     */
    @Override
    public List<GeoGraphicalRef> selectGeoGraphicalRefList(GeoGraphicalRef geoGraphicalRef)
    {
        return geoGraphicalRefMapper.selectGeoGraphicalRefList(geoGraphicalRef);
    }

    /**
     * 新增地图空间数据和地名关联
     *
     * @param geoGraphicalRef 地图空间数据和地名关联
     * @return 结果
     */
    @Override
    public int insertGeoGraphicalRef(GeoGraphicalRef geoGraphicalRef)
    {
        return geoGraphicalRefMapper.insertGeoGraphicalRef(geoGraphicalRef);
    }

    /**
     * 修改地图空间数据和地名关联
     *
     * @param geoGraphicalRef 地图空间数据和地名关联
     * @return 结果
     */
    @Override
    public int updateGeoGraphicalRef(GeoGraphicalRef geoGraphicalRef)
    {
        return geoGraphicalRefMapper.updateGeoGraphicalRef(geoGraphicalRef);
    }

    /**
     * 批量删除地图空间数据和地名关联
     *
     * @param OBJECTIDs 需要删除的地图空间数据和地名关联主键
     * @return 结果
     */
    @Override
    public int deleteGeoGraphicalRefByOBJECTIDs(Integer[] OBJECTIDs)
    {
        return geoGraphicalRefMapper.deleteGeoGraphicalRefByOBJECTIDs(OBJECTIDs);
    }

    /**
     * 删除地图空间数据和地名关联信息
     *
     * @param OBJECTID 地图空间数据和地名关联主键
     * @return 结果
     */
    @Override
    public int deleteGeoGraphicalRefByOBJECTID(Integer OBJECTID)
    {
        return geoGraphicalRefMapper.deleteGeoGraphicalRefByOBJECTID(OBJECTID);
    }

}
