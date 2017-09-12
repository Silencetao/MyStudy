package com.silencetao.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * upd服务器端
 * @author Silence
 * create time 2017年7月24日 下午3:49:11
 * @version 1.0.1
 */
public class UdpServer {
    public static final int PROT = 30000;
    //定义每个数据报的大小最大为4KB
    private static final int DATA_LEN = 4096;
    //定义接收网络数据的字节数组
    byte[] inBuff = new byte[DATA_LEN];
    
    //以指定字节数组创建准备接收数据的DatagramPacket对象
    private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
    //定义一个用于发送的DatagramPacket对象
    private DatagramPacket outPacket;
    
    //定义一个字符串数组，服务器发送该数组的元素
    String[] books = new String[] {
        "疯狂Java讲义",
        "疯狂Android讲义",
        "疯狂Ajax讲义",
        "Java从入门到住院"
    };
    
    /**
     * 服务器启动方法
     * @version 1.0.1 
     * @throws IOException
     */
    public void init() throws IOException {
        try (
                //创建DatagramSocket对象
                DatagramSocket socket = new DatagramSocket(PROT);
            ) {
            //采用循环接收数据
            for (int i = 0; i < 1000; i++) {
                //读取Socket中的数据，读到的数据放入inPacket封装的数组里
                socket.receive(inPacket);
                //判断inPack.getData()和inBuff是否是同一个数组
                System.out.println(inBuff == inPacket.getData());
                //将收到的内容转换成字符串后输出
                System.out.println(new String(inBuff, 0, inPacket.getLength()));
                //从字符串数组中取出一个元素作为发送数据
                byte[] sendData = books[i % 4].getBytes();
                //以指定的字节数组作为发送数据，以刚接收的DatagramPacket的源SocketAddress
                //作为目标SocketAddress创建DatagramPacket
                outPacket = new DatagramPacket(sendData, sendData.length, inPacket.getSocketAddress());
                //发送数据
                socket.send(outPacket);
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
        new UdpServer().init();
    }
}
