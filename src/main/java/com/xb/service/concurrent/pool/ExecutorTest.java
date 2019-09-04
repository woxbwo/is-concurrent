package com.xb.service.concurrent.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: ExecutorTest
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.09.05 2:48
 */
public class ExecutorTest {
    public static void main(String[] args) {
        Executor sxecutorCached = Executors.newCachedThreadPool();
        Executor executorFixed  = Executors.newFixedThreadPool(10);
        Executors.newScheduledThreadPool(10);
        Executors.newWorkStealingPool();
        Executors.newSingleThreadExecutor();
        Executors.newSingleThreadScheduledExecutor();
    }
}
