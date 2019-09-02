package com.xb.service.concurrent.threadsafe;

/**
 * @ClassName: HungerSingleton
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.30 1:20
 */
public class HungerSingleton {
    private static HungerSingleton singleton = new HungerSingleton();
    public static HungerSingleton getInstance(){
        return singleton;
    }
    private HungerSingleton(){

    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(()->{
                System.out.println(getInstance().toString());
            }).start();
        }
    }
}
