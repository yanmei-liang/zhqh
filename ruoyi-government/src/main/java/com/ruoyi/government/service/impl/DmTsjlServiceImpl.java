package com.ruoyi.government.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.government.mapper.DmTsjlMapper;
import com.ruoyi.government.domain.DmTsjl;
import com.ruoyi.government.service.IDmTsjlService;

/**
 * 推送记录Service业务层处理
 *
 * @author ruoyi
 * @date 2024-10-24
 */
@Service
public class DmTsjlServiceImpl implements IDmTsjlService
{
    @Autowired
    private DmTsjlMapper dmTsjlMapper;

    /**
     * 查询推送记录
     *
     * @param tsjlId 推送记录主键
     * @return 推送记录
     */
    @Override
    public DmTsjl selectDmTsjlByTsjlId(Integer tsjlId)
    {
        return dmTsjlMapper.selectDmTsjlByTsjlId(tsjlId);
    }

    /**
     * 查询推送记录列表
     *
     * @param dmTsjl 推送记录
     * @return 推送记录
     */
    @Override
    public List<DmTsjl> selectDmTsjlList(DmTsjl dmTsjl)
    {
        return dmTsjlMapper.selectDmTsjlList(dmTsjl);
    }

    /**
     * 新增推送记录
     *
     * @param dmTsjl 推送记录
     * @return 结果
     */
    @Override
    public int insertDmTsjl(DmTsjl dmTsjl)
    {
        return dmTsjlMapper.insertDmTsjl(dmTsjl);
    }

    /**
     * 修改推送记录
     *
     * @param dmTsjl 推送记录
     * @return 结果
     */
    @Override
    public int updateDmTsjl(DmTsjl dmTsjl)
    {
        return dmTsjlMapper.updateDmTsjl(dmTsjl);
    }

    /**
     * 批量删除推送记录
     *
     * @param tsjlIds 需要删除的推送记录主键
     * @return 结果
     */
    @Override
    public int deleteDmTsjlByTsjlIds(Integer[] tsjlIds)
    {
        return dmTsjlMapper.deleteDmTsjlByTsjlIds(tsjlIds);
    }

    /**
     * 删除推送记录信息
     *
     * @param tsjlId 推送记录主键
     * @return 结果
     */
    @Override
    public int deleteDmTsjlByTsjlId(Integer tsjlId)
    {
        return dmTsjlMapper.deleteDmTsjlByTsjlId(tsjlId);
    }
}
