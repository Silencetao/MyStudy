package com.silencetao.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * 负责处理每个线程通信的线程类
 * @author Silence
 * create time 2017年7月20日 下午12:17:57
 * @version 1.0.1
 */
public class ServerThread implements Runnable {
    //定义当前线程所处理的socket
    private Socket s = null;
    //该线程所处理的Socket对应的输入流
    private BufferedReader br = null;
    
    public ServerThread(Socket s) throws IOException {
        this.s = s;
        //初始化该socket对应的输入流
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }
    
    @Override
    public void run() {
        System.out.println("有小伙伴连上来了");
        try {
            String content = null;
            //采用循环不断地从Socket中读取客户端发送过来的数据
            while ((content = readFromClient()) != null) {
                //遍历socketList中的每个Socket
                //将读到的内容向每个Socket发送一次
                for (Socket socket : MyServer.sockets) {
//                    if (socket.equals(s)) {
//                        continue ;
//                    }
                    PrintStream ps = new PrintStream(socket.getOutputStream());
                    //进行普通的IO操作
                    ps.println(content);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 定义读取客户端数据的方法
     * @return
     */
    private String readFromClient() {
        try {
            return br.readLine();
        } catch (IOException e) {
            System.out.println("有小伙伴断开连接了");
            //删除该socket
            MyServer.sockets.remove(s);
        }
        return null;
    }
}
