package com.xb.service.concurrent.communication;


/**
 * @ClassName: WaitNotifyDemo
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.09.03 0:34
 */
public class WaitNotifyDemo {
    private static volatile boolean flag = false;
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        new Thread(()->{
            while (!flag){
                try {
                    synchronized (obj){
                        obj.wait();
                    }
                    System.out.println("flag is false");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("flag is true");
        }).start();
        new Thread(()->{
            while (!flag){
                try {
                    synchronized (obj){
                        obj.wait();
                    }
                    System.out.println("flag is false");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("flag is true");
        }).start();
        Thread.sleep(1000L);
        new Thread(()->{
            flag = true;
            synchronized (obj){
                obj.notifyAll();
            }
        }).start();
    }
}
