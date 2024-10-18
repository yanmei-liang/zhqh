package com.ruoyi.government.listener;

import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;
import org.springframework.stereotype.Component;

/**
 * 自定义任务监听器
 */

@Slf4j
@Component()
public class GMyTaskListener implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        System.out.println("============自定义任务监听器 start============");
        System.out.println("任务类"+delegateTask);
        String taskDefinitionKey = delegateTask.getTaskDefinitionKey();
        String eventName = delegateTask.getEventName();
        System.out.println("事件名称：" + eventName);
        System.out.println("监听器：" + taskDefinitionKey);
        System.out.println("============自定义任务监听器 end============");
    }
}
