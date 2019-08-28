package com.xb.service.concurrent.interrupt;

/**
 * @ClassName: FlagInterrupt
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.29 2:32
 */
public class FlagInterrupt implements Runnable {
    private static volatile boolean close = false;
    @Override
    public void run() {
        while (!close){
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Thread thread = new Thread(new FlagInterrupt());
        thread.start();
        Thread.sleep(1000L);
        close = true;
    }
}
