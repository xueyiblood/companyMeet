package com.yuanch.common.manager;

import com.yuanch.common.utils.SpringBeanUtils;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


/**
 * @Description:
 * @Author: mary
 * @Date: 2020/8/14 0014 19:07
 */
public class AsyncManager {

    /**
     * 异步操作任务调度线程池
     */
    private ThreadPoolTaskExecutor executor = SpringBeanUtils.getBean("threadPoolTaskExecutor");

    /**
     * 单例模式
     */
    private AsyncManager() {
    }

    private static AsyncManager me = new AsyncManager();

    public static AsyncManager me() {
        return me;
    }

    /**
     * 执行任务
     *
     * @param task 任务
     */
    public void execute(Runnable task) {
        executor.execute(task);
    }

    /**
     * 停止任务线程池
     */
    public void shutdown() {
        if (executor != null) {
            executor.shutdown();
        }
    }
}
