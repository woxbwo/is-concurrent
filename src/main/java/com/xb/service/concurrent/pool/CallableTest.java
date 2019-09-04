package com.xb.service.concurrent.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: CallableTest
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.09.05 1:56
 */
public class CallableTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        //Thread.sleep(5000L);
        return "woxbwo";
    }

    public static void main(String[] args) throws Exception {
        CallableTest callableTest = new CallableTest();
        FutureTask<String> stringFutureTask = new FutureTask<>(callableTest);
        new Thread(stringFutureTask).start();
        String s = stringFutureTask.get();
        System.out.println("CallableTest返回结果:" + s);
    }
}
