package com.xb.service.concurrent.tools;

import javax.sound.midi.SoundbankResource;
import java.util.concurrent.Exchanger;

/**
 * @ClassName: ExchangerTest
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.09.05 1:18
 */
public class ExchangerTest {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        String str1 = "woxbwo";
        String str2 = "zbbiex";
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"初始值："+str1);
            try {
                final String exchange = exchanger.exchange(str1);
                System.out.println(Thread.currentThread().getName()+"交换后的数据："+exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程一").start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"初始值："+str2);
            try {
                final String exchange = exchanger.exchange(str2);
                System.out.println(Thread.currentThread().getName()+"交换后的数据："+exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程二").start();
    }
}
