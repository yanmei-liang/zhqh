package com.ruoyi.government.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.government.mapper.DmDmlbMapper;
import com.ruoyi.government.domain.DmDmlb;
import com.ruoyi.government.service.IDmDmlbService;

/**
 * 地名类别Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-14
 */
@Service
public class DmDmlbServiceImpl implements IDmDmlbService 
{
    @Autowired
    private DmDmlbMapper dmDmlbMapper;

    /**
     * 查询地名类别
     * 
     * @param id 地名类别主键
     * @return 地名类别
     */
    @Override
    public DmDmlb selectDmDmlbById(String id)
    {
        return dmDmlbMapper.selectDmDmlbById(id);
    }

    /**
     * 查询地名类别列表
     * 
     * @param dmDmlb 地名类别
     * @return 地名类别
     */
    @Override
    public List<DmDmlb> selectDmDmlbList(DmDmlb dmDmlb)
    {
        return dmDmlbMapper.selectDmDmlbList(dmDmlb);
    }

    /**
     * 新增地名类别
     * 
     * @param dmDmlb 地名类别
     * @return 结果
     */
    @Override
    public int insertDmDmlb(DmDmlb dmDmlb)
    {
        dmDmlb.setCreateTime(DateUtils.getNowDate());
        return dmDmlbMapper.insertDmDmlb(dmDmlb);
    }

    /**
     * 修改地名类别
     * 
     * @param dmDmlb 地名类别
     * @return 结果
     */
    @Override
    public int updateDmDmlb(DmDmlb dmDmlb)
    {
        dmDmlb.setUpdateTime(DateUtils.getNowDate());
        return dmDmlbMapper.updateDmDmlb(dmDmlb);
    }

    /**
     * 批量删除地名类别
     * 
     * @param ids 需要删除的地名类别主键
     * @return 结果
     */
    @Override
    public int deleteDmDmlbByIds(String[] ids)
    {
        return dmDmlbMapper.deleteDmDmlbByIds(ids);
    }

    /**
     * 删除地名类别信息
     * 
     * @param id 地名类别主键
     * @return 结果
     */
    @Override
    public int deleteDmDmlbById(String id)
    {
        return dmDmlbMapper.deleteDmDmlbById(id);
    }
}
