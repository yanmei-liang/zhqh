package com.ruoyi.government.mapper;

import java.util.List;
import com.ruoyi.government.domain.DmBase;

/**
 * 标准地名Mapper接口
 * 
 * @author ruoyi
 * @date 2024-10-14
 */
public interface DmBaseMapper 
{
    /**
     * 查询标准地名
     * 
     * @param id 标准地名主键
     * @return 标准地名
     */
    public DmBase selectDmBaseById(String id);

    /**
     * 查询标准地名列表
     * 
     * @param dmBase 标准地名
     * @return 标准地名集合
     */
    public List<DmBase> selectDmBaseList(DmBase dmBase);

    /**
     * 新增标准地名
     * 
     * @param dmBase 标准地名
     * @return 结果
     */
    public int insertDmBase(DmBase dmBase);

    /**
     * 修改标准地名
     * 
     * @param dmBase 标准地名
     * @return 结果
     */
    public int updateDmBase(DmBase dmBase);

    /**
     * 删除标准地名
     * 
     * @param id 标准地名主键
     * @return 结果
     */
    public int deleteDmBaseById(String id);

    /**
     * 批量删除标准地名
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDmBaseByIds(String[] ids);
}