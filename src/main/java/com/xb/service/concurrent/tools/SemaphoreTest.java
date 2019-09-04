package com.xb.service.concurrent.tools;

import java.util.concurrent.Semaphore;

/**
 * @ClassName: SemaphoreTest
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.09.05 1:02
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"开始执行");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }).start();
        }
    }
}
