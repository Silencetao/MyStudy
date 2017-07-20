package com.silencetao.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * 负责处理和服务端的Socket通信
 * @author Silence
 * create time 2017年7月20日 下午12:46:34
 * @version 1.0.1
 */
class ClientThread implements Runnable {
    //该线程负责处理的socket
    private Socket s;
    //该线程所处理的Socket对应的输入流
    BufferedReader br = null;
    
    public ClientThread(Socket s) throws IOException {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }
    
    @Override
    public void run() {
        try {
            String content = null;
            //不断地读取Socket输入流中的内容，并将这些内容打印输出
            while ((content = br.readLine()) != null) {
                System.out.println("ClientThread--->" + content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * 客户端程序
 * @author Silence
 * create time 2017年7月20日 下午12:45:23
 * @version 1.0.1
 */
public class MyClient {

    public static void main(String[] args) throws Exception {
        Socket s = new Socket("127.0.0.01", 30000);
        //客户端启动ClientThread线程不断地读取来自服务器的数据
        new Thread(new ClientThread(s)).start();
        //获取该socket对应的输出流
        PrintStream ps = new PrintStream(s.getOutputStream());
        String line = null;
        //不断的读取键盘输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((line = br.readLine()) != null) {
            //将用户的键盘输入内容写入Socket对应的输出流
            ps.println(line);
        }
    }

}
