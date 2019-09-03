package com.xb.service.concurrent.synccontainer;

import java.util.*;

/**
 * @ClassName: VectorTest
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.09.04 0:34
 */
public class VectorTest {
    static Vector<Integer> vector = new Vector<Integer>();

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            for (int i = 0; i < 10; i++)
                vector.add(i);
            Thread thread1 = new Thread() {
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            Integer remove = vector.remove(i);
                            System.out.println("thread1 remove:" + remove);
                        }
                    }

                }
            };
            Thread thread2 = new Thread() {
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            Integer integer = vector.get(i);
                            System.out.println("thread2 get:" + integer);
                        }

                    }

                }
            };
            thread1.start();
            thread2.start();
            while (Thread.activeCount() > 10) {

            }
        }
    }
}
