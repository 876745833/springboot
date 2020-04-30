package com.crc.flowable.handler;

import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;

/**
 * @Author CRC
 * @Date 2020/4/30
 */
public class BossTaskHandler implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        delegateTask.setAssignee("boss");
    }
}
