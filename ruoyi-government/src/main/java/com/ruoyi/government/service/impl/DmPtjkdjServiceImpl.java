package com.ruoyi.government.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.government.mapper.DmPtjkdjMapper;
import com.ruoyi.government.domain.DmPtjkdj;
import com.ruoyi.government.service.IDmPtjkdjService;

/**
 * 平台接口对接模块Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-24
 */
@Service
public class DmPtjkdjServiceImpl implements IDmPtjkdjService 
{
    @Autowired
    private DmPtjkdjMapper dmPtjkdjMapper;

    /**
     * 查询平台接口对接模块
     * 
     * @param ID 平台接口对接模块主键
     * @return 平台接口对接模块
     */
    @Override
    public DmPtjkdj selectDmPtjkdjByID(Integer ID)
    {
        return dmPtjkdjMapper.selectDmPtjkdjByID(ID);
    }

    /**
     * 查询平台接口对接模块列表
     * 
     * @param dmPtjkdj 平台接口对接模块
     * @return 平台接口对接模块
     */
    @Override
    public List<DmPtjkdj> selectDmPtjkdjList(DmPtjkdj dmPtjkdj)
    {
        return dmPtjkdjMapper.selectDmPtjkdjList(dmPtjkdj);
    }

    /**
     * 新增平台接口对接模块
     * 
     * @param dmPtjkdj 平台接口对接模块
     * @return 结果
     */
    @Override
    public int insertDmPtjkdj(DmPtjkdj dmPtjkdj)
    {
        return dmPtjkdjMapper.insertDmPtjkdj(dmPtjkdj);
    }

    /**
     * 修改平台接口对接模块
     * 
     * @param dmPtjkdj 平台接口对接模块
     * @return 结果
     */
    @Override
    public int updateDmPtjkdj(DmPtjkdj dmPtjkdj)
    {
        return dmPtjkdjMapper.updateDmPtjkdj(dmPtjkdj);
    }

    /**
     * 批量删除平台接口对接模块
     * 
     * @param IDs 需要删除的平台接口对接模块主键
     * @return 结果
     */
    @Override
    public int deleteDmPtjkdjByIDs(Integer[] IDs)
    {
        return dmPtjkdjMapper.deleteDmPtjkdjByIDs(IDs);
    }

    /**
     * 删除平台接口对接模块信息
     * 
     * @param ID 平台接口对接模块主键
     * @return 结果
     */
    @Override
    public int deleteDmPtjkdjByID(Integer ID)
    {
        return dmPtjkdjMapper.deleteDmPtjkdjByID(ID);
    }
}
