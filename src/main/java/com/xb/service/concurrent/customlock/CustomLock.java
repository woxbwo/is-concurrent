package com.xb.service.concurrent.customlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName: CustomLock
 * 自定义锁
 * 实现lock()
 * 实现unLock()
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.09.01 3:04
 */
public class CustomLock implements Lock {
    private boolean isHoldLock = false;
    private int reentryLockCount = 0 ;
    private Thread holdLockThread = null;
    /**
     *@description:
     * 同一时刻，只能有一个线程获取锁，其他的线程只能等到该线程释放锁之后，才能获取到锁
     * 实现重入锁。
     *@params:  []
     *@return:  void
     **/
    @Override
    public synchronized void lock() {
        if(isHoldLock&&Thread.currentThread() != holdLockThread){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isHoldLock = true;
        holdLockThread = Thread.currentThread();
        reentryLockCount++;
    }
    @Override
    public synchronized void unlock() {
        //判断当前线程是否是持有锁的线程，是的话重入次数减一，不是则什么都不做
        if(Thread.currentThread()==holdLockThread){
            reentryLockCount--;
        }
        if(reentryLockCount==0){
            notify();
            isHoldLock = false;
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
