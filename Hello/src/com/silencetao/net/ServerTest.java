package com.silencetao.net;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 使用socket通信，服务端
 * @author Silence
 * create time 2017年7月20日 上午11:04:15
 * @version 1.0.1
 */
public class ServerTest {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        //创建一个ServerSocket，用于监听客户端Socket的连接请求
        ServerSocket ss = new ServerSocket(30000);
        //采用循环不断的接收来自客户端的请求
        while (true) {
            //每当接收到客户端socket的请求时，服务器端也对应产生一个Socket
            Socket s = ss.accept();
            //将Socket对应的输出流包装成PrintStream
            PrintStream ps = new PrintStream(s.getOutputStream());
            //进行普通的IO操作
            ps.println("您好，Silence");
            //关闭输出流，关闭Socket
            ps.close();
            s.close();
        }
    }
}
