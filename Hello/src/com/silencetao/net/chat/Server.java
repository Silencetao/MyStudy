package com.silencetao.net.chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端监听处理类
 * @author Silence
 * create time 2017年7月20日 下午2:38:40
 * @version 1.0.1
 */
public class Server {
    private static final int SERVER_PORT = 30000;
    //使用CrazyitMap对象来保存每个客户名字和对应输出流之间的对应关系
    public static CrazyitMap<String, PrintStream> clients = new CrazyitMap<String, PrintStream>();
    
    public void init() {
        try (
                //建立监听的ServerSocket
                ServerSocket ss = new ServerSocket(SERVER_PORT);
            ) {
            //采用死循环来不断地接收来自客户端的请求
            while (true) {
                Socket socket = ss.accept();
                new ServerThread(socket).start();
            }
        } catch (IOException e) {
            System.err.println("服务器启动失败，请检查是否端口" + SERVER_PORT + "已被占用");
        }
    }
    
    public static void main(String[] args) {
        Server server = new Server();
        server.init();
    }
}
