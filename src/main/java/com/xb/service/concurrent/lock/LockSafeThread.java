package com.xb.service.concurrent.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: LockSafeThread
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.28 1:20
 */
public class LockSafeThread {
    private  static   int num = 0;
    //并发工具类synchronize关机字，使得操作具有原子性
    private static CountDownLatch downLatch = new CountDownLatch(10);

    private static Lock lock = new ReentrantLock();

    private  static void addNum(){
        lock.lock();
        num++;
        lock.unlock();
    }

    public  static void main(String[] args) {
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
                System.out.println("多线程并发访问时，使用Lock得到正确结果:"+num);
                break;
            }
        }
    }
}
