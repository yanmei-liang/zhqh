package com.ruoyi.government.service;

import java.util.List;
import com.ruoyi.government.domain.DmDmlb;

/**
 * 地名类别Service接口
 * 
 * @author ruoyi
 * @date 2024-10-14
 */
public interface IDmDmlbService 
{
    /**
     * 查询地名类别
     * 
     * @param id 地名类别主键
     * @return 地名类别
     */
    public DmDmlb selectDmDmlbById(String id);

    /**
     * 查询地名类别列表
     * 
     * @param dmDmlb 地名类别
     * @return 地名类别集合
     */
    public List<DmDmlb> selectDmDmlbList(DmDmlb dmDmlb);

    /**
     * 新增地名类别
     * 
     * @param dmDmlb 地名类别
     * @return 结果
     */
    public int insertDmDmlb(DmDmlb dmDmlb);

    /**
     * 修改地名类别
     * 
     * @param dmDmlb 地名类别
     * @return 结果
     */
    public int updateDmDmlb(DmDmlb dmDmlb);

    /**
     * 批量删除地名类别
     * 
     * @param ids 需要删除的地名类别主键集合
     * @return 结果
     */
    public int deleteDmDmlbByIds(String[] ids);

    /**
     * 删除地名类别信息
     * 
     * @param id 地名类别主键
     * @return 结果
     */
    public int deleteDmDmlbById(String id);
}
