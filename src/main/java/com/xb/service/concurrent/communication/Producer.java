package com.xb.service.concurrent.communication;

/**
 * @ClassName: Producer
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.09.03 0:50
 */
public class Producer implements Runnable{
    private Medium medium;

    public Producer(Medium medium){
        this.medium = medium;
    }
    @Override
    public void run() {
        while (true){
            medium.put();
        }
    }
}
