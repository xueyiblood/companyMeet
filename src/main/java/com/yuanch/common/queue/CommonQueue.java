package com.yuanch.common.queue;


/**
 * @Description:
 * @Author: mary
 * @Date: 2020/8/13 0002 20:18
 */
public interface CommonQueue<T> {
    void put(T t) throws InterruptedException;

    T get() throws InterruptedException;

    boolean isEmpty();
}
