package com.xb.service.concurrent.communication;

/**
 * @ClassName: Medium
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.09.03 0:50
 */
public class Medium {
    private int num  = 0;
    private static final int TOTAL = 20;
    /**
     *@description:
     * 生产数据
     **/
    public synchronized void put(){
        if(num<TOTAL){
            System.out.println("新增库存，当前库存"+num++);
            notifyAll();
        }else{
            try {
                System.out.println("库存已满"+num);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    /**
     *@description:
     * 消费数据
     **/
    public synchronized void take(){
        if(num>0){
            System.out.println("消费库存，当前库存："+num--);
            notifyAll();
        }else{
            try {
                System.out.println("库存不足："+num);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
