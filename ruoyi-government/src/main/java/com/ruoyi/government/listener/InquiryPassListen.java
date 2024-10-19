package com.ruoyi.government.listener;

import com.ruoyi.government.domain.GovernmentInquiry;
import com.ruoyi.government.factory.GovernmentServiceFactory;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;
import org.springframework.stereotype.Component;

/**
 * 预审通过任务监听器
 */

@Slf4j
@Component()
public class InquiryPassListen extends GovernmentServiceFactory implements TaskListener  {

    @Override
    public void notify(DelegateTask delegateTask) {
        GovernmentInquiry governmentInquiry = governmentInquiryService.selectGovernmentInquiryByProcInsId(delegateTask.getProcessInstanceId());
        governmentInquiry.setInquiryStatus("已通过");
        governmentInquiryService.updateGovernmentInquiry(governmentInquiry);
    }
}
