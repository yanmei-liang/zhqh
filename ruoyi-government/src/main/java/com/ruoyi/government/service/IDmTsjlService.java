package com.ruoyi.government.service;

import java.util.List;
import com.ruoyi.government.domain.DmTsjl;

/**
 * 推送记录Service接口
 *
 * @author ruoyi
 * @date 2024-10-24
 */
public interface IDmTsjlService
{
    /**
     * 查询推送记录
     *
     * @param tsjlId 推送记录主键
     * @return 推送记录
     */
    public DmTsjl selectDmTsjlByTsjlId(Integer tsjlId);

    /**
     * 查询推送记录列表
     *
     * @param dmTsjl 推送记录
     * @return 推送记录集合
     */
    public List<DmTsjl> selectDmTsjlList(DmTsjl dmTsjl);

    /**
     * 新增推送记录
     *
     * @param dmTsjl 推送记录
     * @return 结果
     */
    public int insertDmTsjl(DmTsjl dmTsjl);

    /**
     * 修改推送记录
     *
     * @param dmTsjl 推送记录
     * @return 结果
     */
    public int updateDmTsjl(DmTsjl dmTsjl);

    /**
     * 批量删除推送记录
     *
     * @param tsjlIds 需要删除的推送记录主键集合
     * @return 结果
     */
    public int deleteDmTsjlByTsjlIds(Integer[] tsjlIds);

    /**
     * 删除推送记录信息
     *
     * @param tsjlId 推送记录主键
     * @return 结果
     */
    public int deleteDmTsjlByTsjlId(Integer tsjlId);
}
