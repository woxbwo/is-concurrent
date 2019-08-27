package com.xb.service.concurrent;

/**
 * @ClassName: DeadLock
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.28 0:53
 */
public class DeadLock {

    private static final Object DATA_A = new Object();
    private static final Object DATA_B = new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (DATA_A){
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (DATA_B){
                    System.out.println("A 成功获取到B的数据");
                }
            }
        }).start();
        new Thread(()->{
            synchronized (DATA_B){
                synchronized (DATA_A){
                    System.out.println("B 成功获取到A的数据");
                }
            }
        }).start();
    }
}
