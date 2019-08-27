package com.xb.service.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: UnSafeThread
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.28 1:20
 */
public class UnSafeThread {
    private static int num = 0;
    //并发工具类
    private static CountDownLatch downLatch = new CountDownLatch(10);
    private static void addNum(){
        num++;
    }

    public static void main(String[] args) {
        for(int i= 0;i<10;i++){
            new Thread(()->{
                for(int j= 0;j<100;j++){
                    addNum();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                downLatch.countDown();
            }).start();
        }
        while (true){
            if (downLatch.getCount() == 0) {
                System.out.println(num);
                break;
            }
        }
    }
}
