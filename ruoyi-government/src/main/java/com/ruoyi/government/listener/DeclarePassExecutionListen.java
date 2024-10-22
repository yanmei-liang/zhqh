package com.ruoyi.government.listener;

import com.ruoyi.common.enums.FlowableStatus;
import com.ruoyi.government.domain.GovernmentDeclare;
import com.ruoyi.government.domain.GovernmentInquiry;
import com.ruoyi.government.service.IGovernmentDeclareService;
import com.ruoyi.government.service.IGovernmentInquiryService;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 申报通过任务监听器
 */

@Slf4j
@Component
public class DeclarePassExecutionListen implements ExecutionListener {

    private static IGovernmentDeclareService governmentDeclareService;

    @Resource
    public void setIGovernmentDeclareService(IGovernmentDeclareService governmentDeclareService) {
        this.governmentDeclareService = governmentDeclareService;
    }

    @Override
    public void notify(DelegateExecution execution) {
        String processInstanceId = execution.getProcessInstanceId();
        GovernmentDeclare governmentDeclare = governmentDeclareService.selectGovernmentDeclareByProcInsId(processInstanceId);
        governmentDeclare.setDeclareStatus(FlowableStatus.PASS.getInfo());
        governmentDeclareService.updateGovernmentDeclare(governmentDeclare);
    }
}
