package com.ruoyi.government.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.government.mapper.DmDmtmMapper;
import com.ruoyi.government.domain.DmDmtm;
import com.ruoyi.government.service.IDmDmtmService;

/**
 * 通名管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-22
 */
@Service
public class DmDmtmServiceImpl implements IDmDmtmService 
{
    @Autowired
    private DmDmtmMapper dmDmtmMapper;

    /**
     * 查询通名管理
     * 
     * @param Id 通名管理主键
     * @return 通名管理
     */
    @Override
    public DmDmtm selectDmDmtmById(Integer Id)
    {
        return dmDmtmMapper.selectDmDmtmById(Id);
    }

    /**
     * 查询通名管理列表
     * 
     * @param dmDmtm 通名管理
     * @return 通名管理
     */
    @Override
    public List<DmDmtm> selectDmDmtmList(DmDmtm dmDmtm)
    {
        return dmDmtmMapper.selectDmDmtmList(dmDmtm);
    }

    /**
     * 新增通名管理
     * 
     * @param dmDmtm 通名管理
     * @return 结果
     */
    @Override
    public int insertDmDmtm(DmDmtm dmDmtm)
    {
        return dmDmtmMapper.insertDmDmtm(dmDmtm);
    }

    /**
     * 修改通名管理
     * 
     * @param dmDmtm 通名管理
     * @return 结果
     */
    @Override
    public int updateDmDmtm(DmDmtm dmDmtm)
    {
        return dmDmtmMapper.updateDmDmtm(dmDmtm);
    }

    /**
     * 批量删除通名管理
     * 
     * @param Ids 需要删除的通名管理主键
     * @return 结果
     */
    @Override
    public int deleteDmDmtmByIds(Integer[] Ids)
    {
        return dmDmtmMapper.deleteDmDmtmByIds(Ids);
    }

    /**
     * 删除通名管理信息
     * 
     * @param Id 通名管理主键
     * @return 结果
     */
    @Override
    public int deleteDmDmtmById(Integer Id)
    {
        return dmDmtmMapper.deleteDmDmtmById(Id);
    }
}
