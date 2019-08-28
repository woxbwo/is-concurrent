package com.xb.service.concurrent.interrupt;

/**
 * @ClassName: ThreadInterrupt
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.29 2:12
 */
public class ThreadInterrupt implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread threadInterrupt = new Thread(new ThreadInterrupt());
        threadInterrupt.start();
        Thread.sleep(2000L);
        threadInterrupt.interrupt();
    }
}
