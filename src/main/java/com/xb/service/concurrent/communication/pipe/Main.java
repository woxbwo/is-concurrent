package com.xb.service.concurrent.communication.pipe;

import java.io.*;

/**
 * @ClassName: Main
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.09.03 1:19
 */
public class Main {
    public static void main(String[] args) throws IOException {
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        pipedOutputStream.connect(pipedInputStream);
        new Thread(new Reader(pipedInputStream)).start();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            pipedOutputStream.write(bufferedReader.readLine().getBytes());
        } finally {
            pipedOutputStream.close();
            if(bufferedReader!=null){
                bufferedReader.close();
            }
        }
    }
}
