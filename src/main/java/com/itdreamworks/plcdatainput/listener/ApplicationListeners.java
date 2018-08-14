package com.itdreamworks.plcdatainput.listener;

import com.itdreamworks.plcdatainput.task.ScheduledTasks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

//@Component
public class ApplicationListeners implements ApplicationListener<ContextRefreshedEvent> {

    private Logger logger = LoggerFactory.getLogger(ApplicationListeners.class);

    @Autowired
    ScheduledTasks ScheduledTasks;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.info("。。。。。。。。。。。。。。。。。服务启动，缓存设备数据。。。。。。。。。。。。。。。。。。。。");
        ScheduledTasks.getDeviceArrayInfo();
    }
}
