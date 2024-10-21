package com.ruoyi.government.listener;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.ExecutionListener;

public class InquiryRejectListen implements ExecutionListener {

    @Override
    public void notify(DelegateExecution delegateExecution) {
        System.out.println("============预审驳回执行监听器 start============");
        System.out.println("监听类"+delegateExecution);
        String eventName = delegateExecution.getEventName();
        String currentActivitiId = delegateExecution.getCurrentActivityId();
        System.out.println("事件名称：" + eventName);
        System.out.println("执行器：" + currentActivitiId);
        System.out.println("============预审驳回执行监听器  end============");
    }
}
