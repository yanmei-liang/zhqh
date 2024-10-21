package com.ruoyi.government.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.government.mapper.DmLimitMarkMapper;
import com.ruoyi.government.domain.DmLimitMark;
import com.ruoyi.government.service.IDmLimitMarkService;

/**
 * 界桩Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-21
 */
@Service
public class DmLimitMarkServiceImpl implements IDmLimitMarkService 
{
    @Autowired
    private DmLimitMarkMapper dmLimitMarkMapper;

    /**
     * 查询界桩
     * 
     * @param limitId 界桩主键
     * @return 界桩
     */
    @Override
    public DmLimitMark selectDmLimitMarkByLimitId(Long limitId)
    {
        return dmLimitMarkMapper.selectDmLimitMarkByLimitId(limitId);
    }

    /**
     * 查询界桩列表
     * 
     * @param dmLimitMark 界桩
     * @return 界桩
     */
    @Override
    public List<DmLimitMark> selectDmLimitMarkList(DmLimitMark dmLimitMark)
    {
        return dmLimitMarkMapper.selectDmLimitMarkList(dmLimitMark);
    }

    /**
     * 新增界桩
     * 
     * @param dmLimitMark 界桩
     * @return 结果
     */
    @Override
    public int insertDmLimitMark(DmLimitMark dmLimitMark)
    {
        dmLimitMark.setCreateTime(DateUtils.getNowDate());
        return dmLimitMarkMapper.insertDmLimitMark(dmLimitMark);
    }

    /**
     * 修改界桩
     * 
     * @param dmLimitMark 界桩
     * @return 结果
     */
    @Override
    public int updateDmLimitMark(DmLimitMark dmLimitMark)
    {
        dmLimitMark.setUpdateTime(DateUtils.getNowDate());
        return dmLimitMarkMapper.updateDmLimitMark(dmLimitMark);
    }

    /**
     * 批量删除界桩
     * 
     * @param limitIds 需要删除的界桩主键
     * @return 结果
     */
    @Override
    public int deleteDmLimitMarkByLimitIds(Long[] limitIds)
    {
        return dmLimitMarkMapper.deleteDmLimitMarkByLimitIds(limitIds);
    }

    /**
     * 删除界桩信息
     * 
     * @param limitId 界桩主键
     * @return 结果
     */
    @Override
    public int deleteDmLimitMarkByLimitId(Long limitId)
    {
        return dmLimitMarkMapper.deleteDmLimitMarkByLimitId(limitId);
    }
}
