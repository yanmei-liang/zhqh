package com.ruoyi.government.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.flowable.common.constant.ProcessConstants;
import com.ruoyi.flowable.common.enums.FlowComment;
import com.ruoyi.flowable.domain.vo.FlowTaskVo;
import com.ruoyi.flowable.factory.FlowServiceFactory;
import com.ruoyi.flowable.service.IFlowDefinitionService;
import com.ruoyi.flowable.service.IFlowTaskService;
import com.ruoyi.flowable.service.ISysDeployFormService;
import com.ruoyi.flowable.service.ISysFormService;
import com.ruoyi.government.service.GFlowableService;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.system.service.ISysUserService;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class GFlowableServiceImpl extends FlowServiceFactory implements GFlowableService {

    @Resource
    private IFlowTaskService flowTaskService;

    @Resource
    private IFlowDefinitionService flowDefinitionService;
    @Resource
    private ISysUserService sysUserService;
    @Resource
    private ISysRoleService sysRoleService;
    @Resource
    private ISysDeployFormService sysInstanceFormService;
    @Resource
    private ISysFormService sysFormService;

    private String procDefId = "toponym_inquiry:1:10044";


    @Transactional(rollbackFor = Exception.class)
    @Override
    public AjaxResult flowTaskStart(){
        //发起流程获取下一节点
        FlowTaskVo flowTaskVo = new FlowTaskVo();
        flowTaskVo.setDeploymentId("10041");
        flowTaskService.getNextFlowNodeByStart(flowTaskVo);

        //
        Map variables = new HashMap();
        JSONObject oldVariables = JSONObject.parseObject("{\"modelName\":\"formData\",\"refName\":\"vForm\",\"rulesName\":\"rules\",\"labelWidth\":80,\"labelPosition\":\"left\",\"size\":\"\",\"labelAlign\":\"label-left-align\",\"cssCode\":\"\",\"customClass\":\"\",\"functions\":\"\",\"layoutType\":\"H5\",\"onFormCreated\":\"\",\"onFormMounted\":\"\",\"onFormDataChange\":\"\",\"onFormValidate\":\"\"}");
        variables.put("formJson",oldVariables);


        try {
            ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(procDefId)
                    .latestVersion().singleResult();
            if (Objects.nonNull(processDefinition) && processDefinition.isSuspended()) {
                return AjaxResult.error("流程已被挂起,请先激活流程");
            }
            // 设置流程发起人Id到流程中
            SysUser sysUser = SecurityUtils.getLoginUser().getUser();
            identityService.setAuthenticatedUserId(sysUser.getUserId().toString());
            variables.put(ProcessConstants.PROCESS_INITIATOR, sysUser.getUserId());

            // 流程发起时 跳过发起人节点
            ProcessInstance processInstance = runtimeService.startProcessInstanceById(procDefId, variables);
            // 给第一步申请人节点设置任务执行人和意见
            Task task = taskService.createTaskQuery().processInstanceId(processInstance.getProcessInstanceId()).singleResult();
            if (Objects.nonNull(task)) {
                taskService.addComment(task.getId(), processInstance.getProcessInstanceId(), FlowComment.NORMAL.getType(), sysUser.getNickName() + "发起流程申请");
                taskService.complete(task.getId(), variables);
            }
            return AjaxResult.success("流程启动成功",processInstance.getProcessInstanceId());
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("流程启动错误");
        }
    }
    }
