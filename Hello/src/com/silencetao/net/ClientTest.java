package com.silencetao.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 使用socket通信，客户端
 * @author Silence
 * create time 2017年7月20日 上午11:12:39
 * @version 1.0.1
 */
public class ClientTest {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 30000);
        //将Socket对应的输入流包装成BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //进行普通IO操作
        String line = br.readLine();
        System.out.println("来自服务器的数据:" + line);
        //关闭输入流，关闭Socket
        br.close();
        socket.close();
    }
}
