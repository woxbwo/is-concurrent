package com.xb.service.concurrent.communication.pipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.stream.Collectors;

/**
 * @ClassName: Reader
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.09.03 1:14
 */
public class Reader implements Runnable {
    private PipedInputStream pipedInputStream;

    public Reader(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        if (this.pipedInputStream != null) {
            String collect = new BufferedReader(new InputStreamReader(pipedInputStream)).lines().collect(Collectors.joining("\n"));
            System.out.println(Thread.currentThread().getName()+":"+collect);
        }

        try {
            pipedInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
