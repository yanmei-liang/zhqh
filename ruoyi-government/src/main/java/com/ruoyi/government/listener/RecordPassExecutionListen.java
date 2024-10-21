package com.ruoyi.government.listener;

import com.ruoyi.common.enums.FlowableStatus;
import com.ruoyi.government.domain.GovernmentInquiry;
import com.ruoyi.government.domain.GovernmentRecord;
import com.ruoyi.government.service.IGovernmentInquiryService;
import com.ruoyi.government.service.IGovernmentRecordService;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 备案通过任务监听器
 */

@Slf4j
@Component
public class RecordPassExecutionListen implements ExecutionListener {

    private static IGovernmentRecordService governmentRecordService;

    @Resource
    public void setIGovernmentRecordService(IGovernmentRecordService governmentRecordService) {
        this.governmentRecordService = governmentRecordService;
    }

    @Override
    public void notify(DelegateExecution execution) {
        String processInstanceId = execution.getProcessInstanceId();
        GovernmentRecord governmentRecord = governmentRecordService.selectGovernmentRecordByProcInsId(processInstanceId);
        governmentRecord.setRecordStatus(FlowableStatus.PASS.getInfo());
        governmentRecordService.updateGovernmentRecord(governmentRecord);
    }
}
