package com.ruoyi.government.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.government.mapper.DmBaseMapper;
import com.ruoyi.government.domain.DmBase;
import com.ruoyi.government.service.IDmBaseService;

/**
 * 标准地名Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-14
 */
@Service
public class DmBaseServiceImpl implements IDmBaseService 
{
    @Autowired
    private DmBaseMapper dmBaseMapper;

    /**
     * 查询标准地名
     * 
     * @param id 标准地名主键
     * @return 标准地名
     */
    @Override
    public DmBase selectDmBaseById(String id)
    {
        return dmBaseMapper.selectDmBaseById(id);
    }

    /**
     * 查询标准地名列表
     * 
     * @param dmBase 标准地名
     * @return 标准地名
     */
    @Override
    public List<DmBase> selectDmBaseList(DmBase dmBase)
    {
        return dmBaseMapper.selectDmBaseList(dmBase);
    }

    /**
     * 新增标准地名
     * 
     * @param dmBase 标准地名
     * @return 结果
     */
    @Override
    public int insertDmBase(DmBase dmBase)
    {
        dmBase.setCreateTime(DateUtils.getNowDate());
        return dmBaseMapper.insertDmBase(dmBase);
    }

    /**
     * 修改标准地名
     * 
     * @param dmBase 标准地名
     * @return 结果
     */
    @Override
    public int updateDmBase(DmBase dmBase)
    {
        dmBase.setUpdateTime(DateUtils.getNowDate());
        return dmBaseMapper.updateDmBase(dmBase);
    }

    /**
     * 批量删除标准地名
     * 
     * @param ids 需要删除的标准地名主键
     * @return 结果
     */
    @Override
    public int deleteDmBaseByIds(String[] ids)
    {
        return dmBaseMapper.deleteDmBaseByIds(ids);
    }

    /**
     * 删除标准地名信息
     * 
     * @param id 标准地名主键
     * @return 结果
     */
    @Override
    public int deleteDmBaseById(String id)
    {
        return dmBaseMapper.deleteDmBaseById(id);
    }
}
