package com.ruoyi.government.service;

import java.util.List;
import com.ruoyi.government.domain.DmLimitMark;

/**
 * 界桩Service接口
 * 
 * @author ruoyi
 * @date 2024-10-21
 */
public interface IDmLimitMarkService 
{
    /**
     * 查询界桩
     * 
     * @param limitId 界桩主键
     * @return 界桩
     */
    public DmLimitMark selectDmLimitMarkByLimitId(Long limitId);

    /**
     * 查询界桩列表
     * 
     * @param dmLimitMark 界桩
     * @return 界桩集合
     */
    public List<DmLimitMark> selectDmLimitMarkList(DmLimitMark dmLimitMark);

    /**
     * 新增界桩
     * 
     * @param dmLimitMark 界桩
     * @return 结果
     */
    public int insertDmLimitMark(DmLimitMark dmLimitMark);

    /**
     * 修改界桩
     * 
     * @param dmLimitMark 界桩
     * @return 结果
     */
    public int updateDmLimitMark(DmLimitMark dmLimitMark);

    /**
     * 批量删除界桩
     * 
     * @param limitIds 需要删除的界桩主键集合
     * @return 结果
     */
    public int deleteDmLimitMarkByLimitIds(Long[] limitIds);

    /**
     * 删除界桩信息
     * 
     * @param limitId 界桩主键
     * @return 结果
     */
    public int deleteDmLimitMarkByLimitId(Long limitId);
}
