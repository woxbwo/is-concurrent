package com.xb.service.concurrent.tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName: CyclicBarrierTest
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.09.05 0:33
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(8);
        for (int i = 0; i <8 ; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    Thread.sleep(finalI *1000);
                    System.out.println(Thread.currentThread().getName() + "选手准备就绪");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("开始比赛");
            }).start();

        }
    }

}
