package com.xb.service.concurrent.communication.join;

/**
 * @ClassName: Main
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.09.03 1:34
 */
public class Main {
    public static void main(String[] args) {
        final Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ":开始运行");
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":结束运行");
        }, "线程一");

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+":开始运行");
            thread1.start();
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":结束运行");
        },"线程二").start();
    }
}
