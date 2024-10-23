package com.ruoyi.government.mapper;

import java.util.List;
import com.ruoyi.government.domain.DmDmtm;

/**
 * 通名管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-10-22
 */
public interface DmDmtmMapper 
{
    /**
     * 查询通名管理
     * 
     * @param Id 通名管理主键
     * @return 通名管理
     */
    public DmDmtm selectDmDmtmById(Integer Id);

    /**
     * 查询通名管理列表
     * 
     * @param dmDmtm 通名管理
     * @return 通名管理集合
     */
    public List<DmDmtm> selectDmDmtmList(DmDmtm dmDmtm);

    /**
     * 新增通名管理
     * 
     * @param dmDmtm 通名管理
     * @return 结果
     */
    public int insertDmDmtm(DmDmtm dmDmtm);

    /**
     * 修改通名管理
     * 
     * @param dmDmtm 通名管理
     * @return 结果
     */
    public int updateDmDmtm(DmDmtm dmDmtm);

    /**
     * 删除通名管理
     * 
     * @param Id 通名管理主键
     * @return 结果
     */
    public int deleteDmDmtmById(Integer Id);

    /**
     * 批量删除通名管理
     * 
     * @param Ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDmDmtmByIds(Integer[] Ids);
}
