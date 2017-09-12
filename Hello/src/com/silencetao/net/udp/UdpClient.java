package com.silencetao.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {
    //定义发送数据的目的地
    public static final int DEST_POST = 30000;
    public static final String DEST_IP = "127.0.0.1";
    //定义每个数据报的大小最大为4KB
    private static final int DATA_LEN = 4096;
    //定义接收网络数据的字节数组
    byte[] inBuff = new byte[DATA_LEN];
    
    //以指定字节数组创建准备接收数据的DatagramPacket对象
    private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
    //定义一个用于发送的DatagramPacket对象
    private DatagramPacket outPacket;
    
    /**
     * 客户端启动方法
     * @version 1.0.1 
     * @throws IOException
     */
    public void init() throws IOException {
        try (
                //创建一个客户端DatagramSocket，使用随机端口
                DatagramSocket socket = new DatagramSocket();
            ) {
            //初始化发送用的DatagramSocket，它包含了一个长度为0的字节数组
            outPacket = new DatagramPacket(new byte[0], 0, InetAddress.getByName(DEST_IP), DEST_POST);
            //创建键盘输入流
            Scanner scanner = new Scanner(System.in);
            //不断的读取键盘输入
            while (scanner.hasNextLine()) {
                //讲键盘输入的一行字符串转换成字节数据
                byte[] buff = scanner.nextLine().getBytes();
                //设置发送用的DatagramPacket中的字节数组
                outPacket.setData(buff);
                //发送数据报
                socket.send(outPacket);
                //读取Socket中的数据，读到的数据放在inPacket所封装的字节数组中
                socket.receive(inPacket);
                System.out.println(new String(inBuff, 0, inBuff.length));
            }
        }
    }
    
    /**
     * 主程序入口
     * @version 1.0.1 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        new UdpClient().init();
    }
}
