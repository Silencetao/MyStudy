package com.silencetao.net.chat;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * 
 * @author Silence
 * create time 2017年7月20日 下午3:40:00
 * @version 1.0.1
 */
public class ClientThread extends Thread {
    //该客户端线程负责处理的输入流
    BufferedReader br = null;
    
    //使用一个网络输入流来创建客户端线程
    public ClientThread(BufferedReader br) {
        this.br = br;
    }
    
    @Override
    public void run() {
        try {
            String line = null;
            //不断地从输入流中读取数据，并将这些数据打印输出
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
