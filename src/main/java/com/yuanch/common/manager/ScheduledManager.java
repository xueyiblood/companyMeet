package com.yuanch.common.manager;

import com.yuanch.common.utils.SpringBeanUtils;
import com.yuanch.common.utils.Threads;

import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 异步任务管理器
 * 
 * @author sj
 */
public class ScheduledManager
{
    /**
     * 操作延迟10毫秒
     */
    private final int OPERATE_DELAY_TIME = 10;

    /**
     * 异步操作任务调度线程池
     */
    private ScheduledExecutorService executor = SpringBeanUtils.getBean("scheduledExecutorService");

    /**
     * 单例模式
     */
    private ScheduledManager(){}

    private static ScheduledManager me = new ScheduledManager();

    public static ScheduledManager me()
    {
        return me;
    }

    /**
     * 执行任务
     * 
     * @param task 任务
     */
    public void execute(TimerTask task)
    {
        executor.schedule(task, OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
    }

    /**
     * 停止任务线程池
     */
    public void shutdown()
    {
        Threads.shutdownAndAwaitTermination(executor);
    }
}
