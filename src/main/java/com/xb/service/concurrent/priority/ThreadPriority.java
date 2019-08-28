package com.xb.service.concurrent.priority;

/**
 * @ClassName: ThreadPriority
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.29 2:42
 */
public class ThreadPriority {
    public static void main(String[] args) {
        final Thread thread1 = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName());
            }
        }, "线程1");
        final Thread thread2 = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName());
            }
        }, "线程2");
        thread1.setDaemon(true);
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();
    }
}
