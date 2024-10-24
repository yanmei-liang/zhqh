package com.ruoyi.government.service;

import java.util.List;
import com.ruoyi.government.domain.DmPtjkdj;

/**
 * 平台接口对接模块Service接口
 * 
 * @author ruoyi
 * @date 2024-10-24
 */
public interface IDmPtjkdjService 
{
    /**
     * 查询平台接口对接模块
     * 
     * @param ID 平台接口对接模块主键
     * @return 平台接口对接模块
     */
    public DmPtjkdj selectDmPtjkdjByID(Integer ID);

    /**
     * 查询平台接口对接模块列表
     * 
     * @param dmPtjkdj 平台接口对接模块
     * @return 平台接口对接模块集合
     */
    public List<DmPtjkdj> selectDmPtjkdjList(DmPtjkdj dmPtjkdj);

    /**
     * 新增平台接口对接模块
     * 
     * @param dmPtjkdj 平台接口对接模块
     * @return 结果
     */
    public int insertDmPtjkdj(DmPtjkdj dmPtjkdj);

    /**
     * 修改平台接口对接模块
     * 
     * @param dmPtjkdj 平台接口对接模块
     * @return 结果
     */
    public int updateDmPtjkdj(DmPtjkdj dmPtjkdj);

    /**
     * 批量删除平台接口对接模块
     * 
     * @param IDs 需要删除的平台接口对接模块主键集合
     * @return 结果
     */
    public int deleteDmPtjkdjByIDs(Integer[] IDs);

    /**
     * 删除平台接口对接模块信息
     * 
     * @param ID 平台接口对接模块主键
     * @return 结果
     */
    public int deleteDmPtjkdjByID(Integer ID);
}
