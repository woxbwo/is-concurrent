package com.xb.service.concurrent.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: ThreadPoolTest
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.09.05 1:45
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        LinkedBlockingQueue<Runnable> objects = new LinkedBlockingQueue<>(20);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 3L, TimeUnit.SECONDS, objects);
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.submit(() -> {
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
