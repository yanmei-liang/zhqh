package com.ruoyi.gis.service.impl;

import java.util.List;

import com.ruoyi.gis.domain.GeographicalNames;
import com.ruoyi.gis.mapper.GeographicalNamesMapper;
import com.ruoyi.gis.service.IGeographicalNamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 地名标志Service业务层处理
 *
 * @author ruoyi
 * @date 2024-10-21
 */
@Service
public class GeographicalNamesServiceImpl implements IGeographicalNamesService
{
    @Autowired
    private GeographicalNamesMapper geographicalNamesMapper;

    @Override
    public List<GeographicalNames> queryByXZQHCode(String code) {
        return geographicalNamesMapper.queryByXZQHCode(code);
    }

    /**
     * 查询地名标志
     *
     * @param OBJECTID 地名标志主键
     * @return 地名标志
     */
    @Override
    public GeographicalNames selectGeographicalNamesByOBJECTID(Integer OBJECTID)
    {
        return geographicalNamesMapper.selectGeographicalNamesByOBJECTID(OBJECTID);
    }

    /**
     * 查询地名标志列表
     *
     * @param geographicalNames 地名标志
     * @return 地名标志
     */
    @Override
    public List<GeographicalNames> selectGeographicalNamesList(GeographicalNames geographicalNames)
    {
        return geographicalNamesMapper.selectGeographicalNamesList(geographicalNames);
    }

    /**
     * 新增地名标志
     *
     * @param geographicalNames 地名标志
     * @return 结果
     */
    @Override
    public int insertGeographicalNames(GeographicalNames geographicalNames)
    {
        return geographicalNamesMapper.insertGeographicalNames(geographicalNames);
    }

    /**
     * 修改地名标志
     *
     * @param geographicalNames 地名标志
     * @return 结果
     */
    @Override
    public int updateGeographicalNames(GeographicalNames geographicalNames)
    {
        return geographicalNamesMapper.updateGeographicalNames(geographicalNames);
    }

    /**
     * 批量删除地名标志
     *
     * @param OBJECTIDs 需要删除的地名标志主键
     * @return 结果
     */
    @Override
    public int deleteGeographicalNamesByOBJECTIDs(Integer[] OBJECTIDs)
    {
        return geographicalNamesMapper.deleteGeographicalNamesByOBJECTIDs(OBJECTIDs);
    }

    /**
     * 删除地名标志信息
     *
     * @param OBJECTID 地名标志主键
     * @return 结果
     */
    @Override
    public int deleteGeographicalNamesByOBJECTID(Integer OBJECTID)
    {
        return geographicalNamesMapper.deleteGeographicalNamesByOBJECTID(OBJECTID);
    }

}
