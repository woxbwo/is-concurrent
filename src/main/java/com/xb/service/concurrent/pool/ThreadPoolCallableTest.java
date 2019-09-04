package com.xb.service.concurrent.pool;

import java.util.concurrent.*;

/**
 * @ClassName: ThreadPoolCallableTest
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.09.05 2:08
 */
public class ThreadPoolCallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LinkedBlockingQueue<Runnable> objects = new LinkedBlockingQueue<>();
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(10, 20, 3L, TimeUnit.SECONDS, objects);
        Future<String> submit = null;
        for (int i = 0; i < 100; i++) {
            submit = threadPoolExecutor.submit(new CallableTest());
        }
        for (int i = 0; i <100 ; i++) {
            System.out.println(submit.get());
        }
    }
}
