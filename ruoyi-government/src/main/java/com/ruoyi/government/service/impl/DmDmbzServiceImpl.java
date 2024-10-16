package com.ruoyi.government.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.government.mapper.DmDmbzMapper;
import com.ruoyi.government.domain.DmDmbz;
import com.ruoyi.government.service.IDmDmbzService;

/**
 * 地名标志Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-14
 */
@Service
public class DmDmbzServiceImpl implements IDmDmbzService 
{
    @Autowired
    private DmDmbzMapper dmDmbzMapper;

    /**
     * 查询地名标志
     * 
     * @param dmbzId 地名标志主键
     * @return 地名标志
     */
    @Override
    public DmDmbz selectDmDmbzByDmbzId(Long dmbzId)
    {
        return dmDmbzMapper.selectDmDmbzByDmbzId(dmbzId);
    }

    /**
     * 查询地名标志列表
     * 
     * @param dmDmbz 地名标志
     * @return 地名标志
     */
    @Override
    public List<DmDmbz> selectDmDmbzList(DmDmbz dmDmbz)
    {
        return dmDmbzMapper.selectDmDmbzList(dmDmbz);
    }

    /**
     * 新增地名标志
     * 
     * @param dmDmbz 地名标志
     * @return 结果
     */
    @Override
    public int insertDmDmbz(DmDmbz dmDmbz)
    {
        dmDmbz.setCreateTime(DateUtils.getNowDate());
        return dmDmbzMapper.insertDmDmbz(dmDmbz);
    }

    /**
     * 修改地名标志
     * 
     * @param dmDmbz 地名标志
     * @return 结果
     */
    @Override
    public int updateDmDmbz(DmDmbz dmDmbz)
    {
        dmDmbz.setUpdateTime(DateUtils.getNowDate());
        return dmDmbzMapper.updateDmDmbz(dmDmbz);
    }

    /**
     * 批量删除地名标志
     * 
     * @param dmbzIds 需要删除的地名标志主键
     * @return 结果
     */
    @Override
    public int deleteDmDmbzByDmbzIds(Long[] dmbzIds)
    {
        return dmDmbzMapper.deleteDmDmbzByDmbzIds(dmbzIds);
    }

    /**
     * 删除地名标志信息
     * 
     * @param dmbzId 地名标志主键
     * @return 结果
     */
    @Override
    public int deleteDmDmbzByDmbzId(Long dmbzId)
    {
        return dmDmbzMapper.deleteDmDmbzByDmbzId(dmbzId);
    }
}
