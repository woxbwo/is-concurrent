package com.xb.service.concurrent;

import java.io.IOException;

/**
 * @ClassName: ThreadState
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.29 1:13
 */
public class ThreadState {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        System.out.println("t1状态："+t1.getState());
    }
}
