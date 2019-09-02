package com.xb.service.concurrent.communication.threadlocal;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @ClassName: ThreadLocalDemo
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.09.03 1:52
 */
public class ThreadLocalDemo {
    ThreadLocal<Integer> num = ThreadLocal.withInitial(() -> 0);

    public void add() {
        Integer integer = num.get();
        integer++;
        System.out.println(Thread.currentThread().getName()+":"+integer);
        num.set(integer);
    }

    public static void main(String[] args) {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        for (int i = 1; i <3 ; i++) {
            int finali = i;
            new Thread(()->{
                while (true){
                    threadLocalDemo.add();
                    try {
                        Thread.sleep(finali*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
