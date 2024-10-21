package com.ruoyi.government.service.impl;

import java.util.*;

import cn.hutool.core.bean.BeanUtil;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.FlowableStatus;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.government.domain.StatusCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.ruoyi.government.mapper.GovernmentDeclareMapper;
import com.ruoyi.government.domain.GovernmentDeclare;
import com.ruoyi.government.service.IGovernmentDeclareService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static com.ruoyi.common.core.domain.AjaxResult.DATA_TAG;

/**
 * 地名申报Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-15
 */
@Service
public class GovernmentDeclareServiceImpl implements IGovernmentDeclareService 
{
    @Resource
    private GovernmentDeclareMapper governmentDeclareMapper;

    @Resource
    private GFlowableServiceImpl gFlowableService;

    @Value(value = "${government.statusType}")
    private String statusType;



    /**
     * 查询地名申报
     * 
     * @param declareId 地名申报主键
     * @return 地名申报
     */
    @Override
    public GovernmentDeclare selectGovernmentDeclareByDeclareId(Long declareId)
    {
        return governmentDeclareMapper.selectGovernmentDeclareByDeclareId(declareId);
    }

    @Override
    public List<StatusCount> selectGovernmentDeclareStatusCount() {
        List<StatusCount> statusCounts = governmentDeclareMapper.selectGovernmentDeclareStatusCount();
        Set<String> types = StringUtils.str2Set(statusType, ",");
        for (String type:types) {
            Integer integer = 0;
            for (StatusCount statusCount:statusCounts) {
                if(type.equals(statusCount.getStatus())){
                    integer++;
                }
            }
            if(integer == 0){
                StatusCount statusCount = new StatusCount();
                statusCount.setStatus(type);
                statusCount.setNum(0);
                statusCounts.add(statusCount);
            }
        }
        return statusCounts;
    }

    /**
     * 查询地名申报
     *
     * @param procInsId 流程实例ID
     * @return 地名申报
     */
    @Override
    public GovernmentDeclare selectGovernmentDeclareByProcInsId(String procInsId) {
        return governmentDeclareMapper.selectGovernmentDeclareByProcInsId(procInsId);
    }

    /**
     * 查询地名申报列表
     * 
     * @param governmentDeclare 地名申报
     * @return 地名申报
     */
    @Override
    public List<GovernmentDeclare> selectGovernmentDeclareList(GovernmentDeclare governmentDeclare)
    {
        return governmentDeclareMapper.selectGovernmentDeclareList(governmentDeclare);
    }

    /**
     * 新增地名申报
     * 
     * @param governmentDeclare 地名申报
     * @return 结果
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public AjaxResult insertGovernmentDeclare(GovernmentDeclare governmentDeclare)
    {
        AjaxResult ajaxResult = gFlowableService.flowTaskStartDeclare(governmentDeclare.getToponym());
        governmentDeclare.setCreateTime(DateUtils.getNowDate());
        String procInsId = ajaxResult.get(DATA_TAG).toString();
        governmentDeclare.setProcInsId(procInsId);
        governmentDeclare.setDeclareStatus(FlowableStatus.AWAIT.getInfo());
        Integer insertId =  governmentDeclareMapper.insertGovernmentDeclare(governmentDeclare);
        governmentDeclare.setCreateTime(DateUtils.getNowDate());
        return insertId > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    /**
     * 修改地名申报
     * 
     * @param governmentDeclare 地名申报
     * @return 结果
     */
    @Override
    public int updateGovernmentDeclare(GovernmentDeclare governmentDeclare)
    {
        governmentDeclare.setUpdateTime(DateUtils.getNowDate());
        return governmentDeclareMapper.updateGovernmentDeclare(governmentDeclare);
    }

    /**
     * 批量删除地名申报
     * 
     * @param declareIds 需要删除的地名申报主键
     * @return 结果
     */
    @Override
    public int deleteGovernmentDeclareByDeclareIds(Long[] declareIds)
    {
        return governmentDeclareMapper.deleteGovernmentDeclareByDeclareIds(declareIds);
    }

    /**
     * 删除地名申报信息
     * 
     * @param declareId 地名申报主键
     * @return 结果
     */
    @Override
    public int deleteGovernmentDeclareByDeclareId(Long declareId)
    {
        return governmentDeclareMapper.deleteGovernmentDeclareByDeclareId(declareId);
    }
}
