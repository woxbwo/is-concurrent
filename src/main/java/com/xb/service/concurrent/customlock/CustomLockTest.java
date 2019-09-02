package com.xb.service.concurrent.customlock;

/**
 * @ClassName: CustomLockTest
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.09.01 3:30
 */
public class CustomLockTest {
    private CustomLock customLock = new CustomLock();
    public void methodA(){
        customLock.lock();
        System.out.println("进入方法A");
        methodB();
        customLock.unlock();
    }
    public void methodB(){
        customLock.lock();
        System.out.println("进入方法B");
        customLock.unlock();
    }

    public static void main(String[] args) {
        CustomLockTest test = new CustomLockTest();
        test.methodA();
    }
}
