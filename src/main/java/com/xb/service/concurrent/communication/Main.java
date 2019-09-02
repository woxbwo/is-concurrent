package com.xb.service.concurrent.communication;

/**
 * @ClassName: Main
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.09.03 1:05
 */
public class Main {
    public static void main(String[] args) {
        Medium medium = new Medium();
        new Thread(new Consumer(medium)).start();
        new Thread(new Consumer(medium)).start();
        new Thread(new Consumer(medium)).start();

        new Thread(new Producer(medium)).start();
        new Thread(new Producer(medium)).start();
        new Thread(new Producer(medium)).start();
    }
}
