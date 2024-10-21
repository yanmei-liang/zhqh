package com.ruoyi.government.mapper;

import java.util.List;
import com.ruoyi.government.domain.DmLimitMark;

/**
 * 界桩Mapper接口
 * 
 * @author ruoyi
 * @date 2024-10-21
 */
public interface DmLimitMarkMapper 
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
     * 删除界桩
     * 
     * @param limitId 界桩主键
     * @return 结果
     */
    public int deleteDmLimitMarkByLimitId(Long limitId);

    /**
     * 批量删除界桩
     * 
     * @param limitIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDmLimitMarkByLimitIds(Long[] limitIds);
}
