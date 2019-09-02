package com.xb.service.concurrent.threadsafe;

/**
 * @ClassName: LazySingletonThreadSafe
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.30 1:33
 */
public class LazySingletonThreadSafe {
    private static volatile LazySingletonThreadSafe lazySingleton = null;
    private LazySingletonThreadSafe (){

    }
    public static LazySingletonThreadSafe getInstance(){
        if(null == lazySingleton){
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (LazySingletonThreadSafe.class){
                if (null == lazySingleton){
                    lazySingleton =  new LazySingletonThreadSafe();
                }
            }

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
