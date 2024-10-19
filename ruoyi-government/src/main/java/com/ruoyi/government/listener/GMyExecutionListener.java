package com.ruoyi.government.listener;


import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

/**
 *  自定义执行监听器
 */

@Slf4j
@Component
public class GMyExecutionListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution)  {
        System.out.println("============自定义执行监听器 start============");
        System.out.println("监听类"+execution);
        String eventName = execution.getEventName();
        String currentActivitiId = execution.getCurrentActivityId();
        System.out.println("事件名称：" + eventName);
        System.out.println("执行器：" + currentActivitiId);


        System.out.println("============自定义执行监听器  end============");
    }

}
