package com.ruoyi.gis.service.impl;

import com.ruoyi.gis.domain.GeographicalLines;
import com.ruoyi.gis.domain.GeographicalLines;
import com.ruoyi.gis.mapper.GeographicalLinesMapper;
import com.ruoyi.gis.service.IGeographicalLinesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 线状标志Service业务层处理
 *
 * @author ruoyi
 * @date 2024-10-22
 */
@Service
public class GeographicalLinesServiceImpl implements IGeographicalLinesService
{
    @Autowired
    private GeographicalLinesMapper geographicalLinesMapper;

    @Override
    public List<GeographicalLines> queryByXZQHCode(String code) {
        return geographicalLinesMapper.queryByXZQHCode(code);
    }

    /**
     * 查询线状标志
     *
     * @param OBJECTID 线状标志主键
     * @return 线状标志
     */
    @Override
    public GeographicalLines selectGeographicalLinesByOBJECTID(Integer OBJECTID)
    {
        return geographicalLinesMapper.selectGeographicalLinesByOBJECTID(OBJECTID);
    }

    /**
     * 查询线状标志列表
     *
     * @param geographicalLines 线状标志
     * @return 线状标志
     */
    @Override
    public List<GeographicalLines> selectGeographicalLinesList(GeographicalLines geographicalLines)
    {
        return geographicalLinesMapper.selectGeographicalLinesList(geographicalLines);
    }

    /**
     * 新增线状标志
     *
     * @param geographicalLines 线状标志
     * @return 结果
     */
    @Override
    public int insertGeographicalLines(GeographicalLines geographicalLines)
    {
        return geographicalLinesMapper.insertGeographicalLines(geographicalLines);
    }

    /**
     * 修改线状标志
     *
     * @param geographicalLines 线状标志
     * @return 结果
     */
    @Override
    public int updateGeographicalLines(GeographicalLines geographicalLines)
    {
        return geographicalLinesMapper.updateGeographicalLines(geographicalLines);
    }

    /**
     * 批量删除线状标志
     *
     * @param OBJECTIDs 需要删除的线状标志主键
     * @return 结果
     */
    @Override
    public int deleteGeographicalLinesByOBJECTIDs(Integer[] OBJECTIDs)
    {
        return geographicalLinesMapper.deleteGeographicalLinesByOBJECTIDs(OBJECTIDs);
    }

    /**
     * 删除线状标志信息
     *
     * @param OBJECTID 线状标志主键
     * @return 结果
     */
    @Override
    public int deleteGeographicalLinesByOBJECTID(Integer OBJECTID)
    {
        return geographicalLinesMapper.deleteGeographicalLinesByOBJECTID(OBJECTID);
    }

}
