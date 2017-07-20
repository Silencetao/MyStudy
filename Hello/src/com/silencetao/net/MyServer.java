package com.silencetao.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ServerSocket服务端监听类
 * @author Silence
 * create time 2017年7月20日 下午12:28:23
 * @version 1.0.1
 */
public class MyServer {
    //定义保存所有Socket的ArrayList，并将其包装为线程安全的
    public static List<Socket> sockets = Collections.synchronizedList(new ArrayList<Socket>());
    
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(30000);
        while (true) {
            //此代码会阻塞，将一直等待客户端的连接
            Socket socket = ss.accept();
            sockets.add(socket);
            //每当客户端连接成功后启动一个ServerThread线程为该客户端服务
            new Thread(new ServerThread(socket)).start();
        }
    }
}
