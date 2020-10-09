package com.yuanch.common.task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: mary
 * @Date: 2020/8/13 0003 11:05
 */
public abstract class TaskRunningPool<T extends Runnable& CloseTask> {
    List<T> currentTasks = new ArrayList<>();
    List<Thread> currentThreads = new ArrayList<>();

    public void executeWithFixedTask(int taskNum) throws Exception {
        for (int i = 0; i < taskNum; i++) {
            T t = createTask();
            Thread thread = new Thread(t);
            currentTasks.add(t);
            currentThreads.add(thread);
            thread.start();
        }
    }

    protected abstract T createTask() throws Exception;

    public void shutdown() throws IOException {
        for (T t : currentTasks) {
            t.close();
        }
        for (Thread t : currentThreads) {
            t.interrupt();
        }
    }
}
