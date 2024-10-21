package com.ruoyi.government.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.flowable.common.constant.ProcessConstants;
import com.ruoyi.flowable.common.enums.FlowComment;
import com.ruoyi.flowable.factory.FlowServiceFactory;
import com.ruoyi.government.service.GFlowableService;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class GFlowableServiceImpl extends FlowServiceFactory implements GFlowableService {

    @Value(value = "${myFlowable.inquiry.procDefKey}")
    private String inquiryProcDefKey;

    @Value(value = "${myFlowable.record.procDefKey}")
    private String recordProcDefKey;

    @Value(value = "${myFlowable.declare.procDefKey}")
    private String declareProcDefKey;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public AjaxResult flowTaskStartInquiry(String toponym){
        Map variables = new HashMap();
        String inquiryFormJson = "{\"widgetList\":[{\"type\":\"input\",\"icon\":\"text-field\",\"formItemFlag\":true,\"options\":{\"name\":\"input100020\",\"label\":\"预审地名\",\"labelAlign\":\"\",\"type\":\"text\",\"defaultValue\":\"\",\"placeholder\":\"\",\"columnWidth\":\"200px\",\"size\":\"\",\"labelWidth\":null,\"labelHidden\":false,\"readonly\":false,\"disabled\":false,\"hidden\":false,\"clearable\":true,\"showPassword\":false,\"required\":false,\"requiredHint\":\"\",\"validation\":\"\",\"validationHint\":\"\",\"customClass\":[],\"labelIconClass\":null,\"labelIconPosition\":\"rear\",\"labelTooltip\":null,\"minLength\":null,\"maxLength\":null,\"showWordLimit\":false,\"prefixIcon\":\"\",\"suffixIcon\":\"\",\"appendButton\":false,\"appendButtonDisabled\":false,\"buttonIcon\":\"el-icon-search\",\"onCreated\":\"\",\"onMounted\":\"\",\"onInput\":\"\",\"onChange\":\"\",\"onFocus\":\"\",\"onBlur\":\"\",\"onValidate\":\"\",\"onAppendButtonClick\":\"\",\"prependText\":\"\",\"appendText\":\"\"},\"id\":\"input100020\"}],\"formConfig\":{\"modelName\":\"formData\",\"refName\":\"vForm\",\"rulesName\":\"rules\",\"labelWidth\":80,\"labelPosition\":\"left\",\"size\":\"\",\"labelAlign\":\"label-left-align\",\"cssCode\":\"\",\"customClass\":\"\",\"functions\":\"\",\"layoutType\":\"PC\",\"onFormCreated\":\"\",\"onFormMounted\":\"\",\"onFormDataChange\":\"\",\"onFormValidate\":\"\"}}";
        JSONObject oldVariables = JSONObject.parseObject(inquiryFormJson);
        variables.put("formJson",oldVariables);
        variables.put("input100020",toponym);
        return flowTaskStart(inquiryProcDefKey,variables);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public AjaxResult flowTaskStartRecord(String recordName){
        Map variables = new HashMap();
        String inquiryFormJson = "{\"widgetList\":[{\"type\":\"input\",\"icon\":\"text-field\",\"formItemFlag\":true,\"options\":{\"name\":\"input55952\",\"label\":\"备案标题\",\"labelAlign\":\"\",\"type\":\"text\",\"defaultValue\":\"\",\"placeholder\":\"\",\"columnWidth\":\"200px\",\"size\":\"\",\"labelWidth\":null,\"labelHidden\":false,\"readonly\":false,\"disabled\":false,\"hidden\":false,\"clearable\":true,\"showPassword\":false,\"required\":false,\"requiredHint\":\"\",\"validation\":\"\",\"validationHint\":\"\",\"customClass\":[],\"labelIconClass\":null,\"labelIconPosition\":\"rear\",\"labelTooltip\":null,\"minLength\":null,\"maxLength\":null,\"showWordLimit\":false,\"prefixIcon\":\"\",\"suffixIcon\":\"\",\"appendButton\":false,\"appendButtonDisabled\":false,\"buttonIcon\":\"el-icon-search\",\"onCreated\":\"\",\"onMounted\":\"\",\"onInput\":\"\",\"onChange\":\"\",\"onFocus\":\"\",\"onBlur\":\"\",\"onValidate\":\"\",\"onAppendButtonClick\":\"\",\"prependText\":\"\",\"appendText\":\"\"},\"id\":\"input100020\"}],\"formConfig\":{\"modelName\":\"formData\",\"refName\":\"vForm\",\"rulesName\":\"rules\",\"labelWidth\":80,\"labelPosition\":\"left\",\"size\":\"\",\"labelAlign\":\"label-left-align\",\"cssCode\":\"\",\"customClass\":\"\",\"functions\":\"\",\"layoutType\":\"PC\",\"onFormCreated\":\"\",\"onFormMounted\":\"\",\"onFormDataChange\":\"\",\"onFormValidate\":\"\"}}";
        JSONObject oldVariables = JSONObject.parseObject(inquiryFormJson);
        variables.put("formJson",oldVariables);
        variables.put("input55952",recordName);
        return flowTaskStart(recordProcDefKey,variables);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public AjaxResult flowTaskStartDeclare(String toponym) {
        Map variables = new HashMap();
        String inquiryFormJson = "{\"widgetList\":[{\"type\":\"input\",\"icon\":\"text-field\",\"formItemFlag\":true,\"options\":{\"name\":\"input100020\",\"label\":\"预审地名\",\"labelAlign\":\"\",\"type\":\"text\",\"defaultValue\":\"\",\"placeholder\":\"\",\"columnWidth\":\"200px\",\"size\":\"\",\"labelWidth\":null,\"labelHidden\":false,\"readonly\":false,\"disabled\":false,\"hidden\":false,\"clearable\":true,\"showPassword\":false,\"required\":false,\"requiredHint\":\"\",\"validation\":\"\",\"validationHint\":\"\",\"customClass\":[],\"labelIconClass\":null,\"labelIconPosition\":\"rear\",\"labelTooltip\":null,\"minLength\":null,\"maxLength\":null,\"showWordLimit\":false,\"prefixIcon\":\"\",\"suffixIcon\":\"\",\"appendButton\":false,\"appendButtonDisabled\":false,\"buttonIcon\":\"el-icon-search\",\"onCreated\":\"\",\"onMounted\":\"\",\"onInput\":\"\",\"onChange\":\"\",\"onFocus\":\"\",\"onBlur\":\"\",\"onValidate\":\"\",\"onAppendButtonClick\":\"\",\"prependText\":\"\",\"appendText\":\"\"},\"id\":\"input100020\"}],\"formConfig\":{\"modelName\":\"formData\",\"refName\":\"vForm\",\"rulesName\":\"rules\",\"labelWidth\":80,\"labelPosition\":\"left\",\"size\":\"\",\"labelAlign\":\"label-left-align\",\"cssCode\":\"\",\"customClass\":\"\",\"functions\":\"\",\"layoutType\":\"PC\",\"onFormCreated\":\"\",\"onFormMounted\":\"\",\"onFormDataChange\":\"\",\"onFormValidate\":\"\"}}";
        JSONObject oldVariables = JSONObject.parseObject(inquiryFormJson);
        variables.put("formJson",oldVariables);
        variables.put("input100020",toponym);
        return flowTaskStart(declareProcDefKey,variables);
    }

    @Transactional(rollbackFor = Exception.class)
    public AjaxResult flowTaskStart(String processDefinitionKey,Map variables){
        try {
            ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey(processDefinitionKey)
                    .latestVersion().singleResult();
            if (Objects.nonNull(processDefinition) && processDefinition.isSuspended()) {
                return AjaxResult.error("流程已被挂起,请先激活流程");
            }
            // 设置流程发起人Id到流程中
            SysUser sysUser = SecurityUtils.getLoginUser().getUser();
            identityService.setAuthenticatedUserId(sysUser.getUserId().toString());
            variables.put(ProcessConstants.PROCESS_INITIATOR, sysUser.getUserId());

            // 流程发起时 跳过发起人节点
            ProcessInstance processInstance = runtimeService.startProcessInstanceById(processDefinition.getId(), variables);
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
//    public static void main(String[] args) {
//        JSONObject oldVariables = JSONObject.parseObject(formJson);
//        List<JSONObject> oldFields = JSON.parseObject(JSON.toJSONString(oldVariables.get("widgetList")), new TypeReference<List<JSONObject>>() {
//        });
//        for (JSONObject oldField : oldFields) {
//            JSONObject options = oldField.getJSONObject("options");
//            options.put("disabled", true);
//        }
//        System.out.println(oldVariables);
//    }

    }
