package com.xb.service.concurrent.communication;

/**
 * @ClassName: Consumer
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.09.03 0:50
 */
public class Consumer implements Runnable{
    private Medium medium;

    public Consumer(Medium medium){
        this.medium = medium;
    }
    @Override
    public void run() {
        while (true){
            medium.take();
        }
    }
}
