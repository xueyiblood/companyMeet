package com.yuanch.common.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Description: 线程启动类
 * @Author: mary
 * @Date: 2020/8/13 0003 11:32
 */
@Component
public class RunningPoolComponent {
    private Logger log = LoggerFactory.getLogger(RunningPoolComponent.class);

    @PostConstruct
    public void init() throws Exception {
        /**
         * 定位数据线程启动
         */
//        LocationRecordRunningPool.getInstance().executeWithFixedTask(1);
//        log.info("SuspectInfoRunningPool --------------start-----------------");
    }
}
