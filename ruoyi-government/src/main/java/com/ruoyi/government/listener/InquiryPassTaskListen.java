package com.ruoyi.government.listener;

import com.ruoyi.common.enums.FlowableStatus;
import com.ruoyi.government.domain.GovernmentInquiry;
import com.ruoyi.government.factory.GovernmentServiceFactory;
import com.ruoyi.government.service.IGovernmentInquiryService;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 预审通过任务监听器
 */

@Slf4j
@Component
public class InquiryPassTaskListen  implements TaskListener  {

    private static IGovernmentInquiryService governmentInquiryService;

    @Resource
    public void setIGovernmentInquiryService(IGovernmentInquiryService governmentInquiryService) {
        this.governmentInquiryService = governmentInquiryService;
    }

    @Override
    public void notify(DelegateTask delegateTask) {
        String processInstanceId = delegateTask.getProcessInstanceId();
        GovernmentInquiry governmentInquiry = governmentInquiryService.selectGovernmentInquiryByProcInsId(processInstanceId);
        governmentInquiry.setInquiryStatus(FlowableStatus.PASS.getInfo());
        governmentInquiryService.updateGovernmentInquiry(governmentInquiry);
    }
}
