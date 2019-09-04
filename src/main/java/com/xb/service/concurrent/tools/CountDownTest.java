package com.xb.service.concurrent.tools;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: CountDownTest
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.09.05 0:16
 */
public class CountDownTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(8);
        new Thread(()->{
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1000米赛跑介绍，准备清空跑到并继续跨栏比赛");
        }).start();
        for (int i = 0; i < 8; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    Thread.sleep(finalI *1000);
                    System.out.println(Thread.currentThread().getName()+"到达终点");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }) .start();
        }
    }
}
