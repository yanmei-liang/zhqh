package com.ruoyi.government.service;

import java.util.List;
import com.ruoyi.government.domain.DmDmbz;
import com.ruoyi.government.domain.vo.ExportFile;

/**
 * 地名标志Service接口
 * 
 * @author ruoyi
 * @date 2024-10-14
 */
public interface IDmDmbzService 
{

    /**
     * 按地名标志区划统计
     *
     */
    public List<ExportFile> selectDmDmbzDivisionStatistics();

    /**
     * 按地名标志类别统计
     *
     */
    public List<ExportFile> selectDmDmbzCategoryStatistics();

    /**
     * 查询总条数
     * */
    public Integer selectDmDmbzCount(DmDmbz dmDmbz);

    /**
     * 查询地名标志
     * 
     * @param dmbzId 地名标志主键
     * @return 地名标志
     */
    public DmDmbz selectDmDmbzByDmbzId(Long dmbzId);

    /**
     * 查询地名标志列表
     * 
     * @param dmDmbz 地名标志
     * @return 地名标志集合
     */
    public List<DmDmbz> selectDmDmbzList(DmDmbz dmDmbz);

    /**
     * 新增地名标志
     * 
     * @param dmDmbz 地名标志
     * @return 结果
     */
    public int insertDmDmbz(DmDmbz dmDmbz);

    /**
     * 修改地名标志
     * 
     * @param dmDmbz 地名标志
     * @return 结果
     */
    public int updateDmDmbz(DmDmbz dmDmbz);

    /**
     * 批量删除地名标志
     * 
     * @param dmbzIds 需要删除的地名标志主键集合
     * @return 结果
     */
    public int deleteDmDmbzByDmbzIds(Long[] dmbzIds);

    /**
     * 删除地名标志信息
     * 
     * @param dmbzId 地名标志主键
     * @return 结果
     */
    public int deleteDmDmbzByDmbzId(Long dmbzId);
}
