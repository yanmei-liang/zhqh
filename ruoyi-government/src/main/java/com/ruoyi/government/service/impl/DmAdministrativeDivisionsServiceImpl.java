package com.ruoyi.government.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.government.mapper.DmAdministrativeDivisionsMapper;
import com.ruoyi.government.domain.DmAdministrativeDivisions;
import com.ruoyi.government.service.IDmAdministrativeDivisionsService;

/**
 * 行政区划Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-14
 */
@Service
public class DmAdministrativeDivisionsServiceImpl implements IDmAdministrativeDivisionsService 
{
    @Autowired
    private DmAdministrativeDivisionsMapper dmAdministrativeDivisionsMapper;

    /**
     * 返回行政级别下拉框
     *
     */
    @Override
    public List<String> selectDmAdministrativeByAdministrativeLevel() {
        return dmAdministrativeDivisionsMapper.selectDmAdministrativeByAdministrativeLevel();
    }

    /**
     * 查询行政区划
     * 
     * @param ID 行政区划主键
     * @return 行政区划
     */
    @Override
    public DmAdministrativeDivisions selectDmAdministrativeDivisionsByID(Long ID)
    {
        return dmAdministrativeDivisionsMapper.selectDmAdministrativeDivisionsByID(ID);
    }

    /**
     * 查询行政区划列表
     * 
     * @param dmAdministrativeDivisions 行政区划
     * @return 行政区划
     */
    @Override
    public List<DmAdministrativeDivisions> selectDmAdministrativeDivisionsList(DmAdministrativeDivisions dmAdministrativeDivisions)
    {
        return dmAdministrativeDivisionsMapper.selectDmAdministrativeDivisionsList(dmAdministrativeDivisions);
    }

    /**
     * 新增行政区划
     * 
     * @param dmAdministrativeDivisions 行政区划
     * @return 结果
     */
    @Override
    public int insertDmAdministrativeDivisions(DmAdministrativeDivisions dmAdministrativeDivisions)
    {
        dmAdministrativeDivisions.setCreateTime(DateUtils.getNowDate());
        return dmAdministrativeDivisionsMapper.insertDmAdministrativeDivisions(dmAdministrativeDivisions);
    }

    /**
     * 修改行政区划
     * 
     * @param dmAdministrativeDivisions 行政区划
     * @return 结果
     */
    @Override
    public int updateDmAdministrativeDivisions(DmAdministrativeDivisions dmAdministrativeDivisions)
    {
        dmAdministrativeDivisions.setUpdateTime(DateUtils.getNowDate());
        return dmAdministrativeDivisionsMapper.updateDmAdministrativeDivisions(dmAdministrativeDivisions);
    }

    /**
     * 批量删除行政区划
     * 
     * @param IDs 需要删除的行政区划主键
     * @return 结果
     */
    @Override
    public int deleteDmAdministrativeDivisionsByIDs(Long[] IDs)
    {
        return dmAdministrativeDivisionsMapper.deleteDmAdministrativeDivisionsByIDs(IDs);
    }

    /**
     * 删除行政区划信息
     * 
     * @param ID 行政区划主键
     * @return 结果
     */
    @Override
    public int deleteDmAdministrativeDivisionsByID(Long ID)
    {
        return dmAdministrativeDivisionsMapper.deleteDmAdministrativeDivisionsByID(ID);
    }
}
