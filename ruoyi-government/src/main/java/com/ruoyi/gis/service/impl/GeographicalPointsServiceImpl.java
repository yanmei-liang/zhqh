package com.ruoyi.gis.service.impl;

import com.ruoyi.gis.domain.GeographicalPoints;
import com.ruoyi.gis.mapper.GeographicalPointsMapper;
import com.ruoyi.gis.service.IGeographicalPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 点状标志Service业务层处理
 *
 * @author ruoyi
 * @date 2024-10-22
 */
@Service
public class GeographicalPointsServiceImpl implements IGeographicalPointsService
{
    @Autowired
    private GeographicalPointsMapper geographicalPointsMapper;

    /**
     * 查询点状标志
     *
     * @param OBJECTID 点状标志主键
     * @return 点状标志
     */
    @Override
    public GeographicalPoints selectGeographicalPointsByOBJECTID(Integer OBJECTID)
    {
        return geographicalPointsMapper.selectGeographicalPointsByOBJECTID(OBJECTID);
    }

    /**
     * 查询点状标志列表
     *
     * @param geographicalPoints 点状标志
     * @return 点状标志
     */
    @Override
    public List<GeographicalPoints> selectGeographicalPointsList(GeographicalPoints geographicalPoints)
    {
        return geographicalPointsMapper.selectGeographicalPointsList(geographicalPoints);
    }

    /**
     * 新增点状标志
     *
     * @param geographicalPoints 点状标志
     * @return 结果
     */
    @Override
    public int insertGeographicalPoints(GeographicalPoints geographicalPoints)
    {
        return geographicalPointsMapper.insertGeographicalPoints(geographicalPoints);
    }

    /**
     * 修改点状标志
     *
     * @param geographicalPoints 点状标志
     * @return 结果
     */
    @Override
    public int updateGeographicalPoints(GeographicalPoints geographicalPoints)
    {
        return geographicalPointsMapper.updateGeographicalPoints(geographicalPoints);
    }

    /**
     * 批量删除点状标志
     *
     * @param OBJECTIDs 需要删除的点状标志主键
     * @return 结果
     */
    @Override
    public int deleteGeographicalPointsByOBJECTIDs(Integer[] OBJECTIDs)
    {
        return geographicalPointsMapper.deleteGeographicalPointsByOBJECTIDs(OBJECTIDs);
    }

    /**
     * 删除点状标志信息
     *
     * @param OBJECTID 点状标志主键
     * @return 结果
     */
    @Override
    public int deleteGeographicalPointsByOBJECTID(Integer OBJECTID)
    {
        return geographicalPointsMapper.deleteGeographicalPointsByOBJECTID(OBJECTID);
    }

}
