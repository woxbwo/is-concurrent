package com.xb.service.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: ThreadPoolCreateThread
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.29 1:42
 */
public class ThreadPoolCreateThread {
    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()->{
            System.out.println(Thread.currentThread().getName());
        });
    }
}
