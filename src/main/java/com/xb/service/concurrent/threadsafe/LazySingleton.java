package com.xb.service.concurrent.threadsafe;

/**
 * @ClassName: LazySingleton
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.30 1:26
 */
public class LazySingleton {
    private static LazySingleton lazySingleton = null;
    private LazySingleton (){

    }
    public static LazySingleton getInstance(){
        if(null == lazySingleton){
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new LazySingleton();
        }
        return lazySingleton;
    }

    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            new Thread(()->{
                System.out.println(getInstance().toString());
            }).start();
        }
    }
}
