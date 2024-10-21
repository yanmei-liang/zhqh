package com.ruoyi.government.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.government.domain.vo.ExportFile;
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
     * 导出类别
     *
     */
    @Override
    public List<ExportFile> exportSelStatisticallevel(String superiorsCode){
        return dmAdministrativeDivisionsMapper.exportSelStatisticallevel(superiorsCode);
    }

    /**
     * 导出面积统计
     *
     */
    @Override
    public List<ExportFile> exportselAreaRadius(String superiorsCode){
        return dmAdministrativeDivisionsMapper.exportselAreaRadius(superiorsCode);
    }

    /**
     * 查询总条数
     *
     */
    @Override
    public Integer selectDmAdministrativeCount(DmAdministrativeDivisions dmAdministrativeDivisions) {
        return dmAdministrativeDivisionsMapper.selectDmAdministrativeCount(dmAdministrativeDivisions);
    }

    /**
     * 范围筛选数据
     *
     */
    @Override
    public List<Map<String,Integer>> selAreaRadius(String superiorsCode){
        return dmAdministrativeDivisionsMapper.selAreaRadius(superiorsCode);
    }

    /**
     * 统计级别
     *
     */
    @Override
    public List<Map<String,Integer>> selStatisticallevel(String superiorsCode){
        return dmAdministrativeDivisionsMapper.selStatisticallevel(superiorsCode);
    }

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
