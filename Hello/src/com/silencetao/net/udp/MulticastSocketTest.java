package com.silencetao.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

/**
 * MulticastSocket类测试
 * @author Silence
 * create time 2017年7月27日 上午9:45:46
 * @version 1.0.1
 */
public class MulticastSocketTest implements Runnable {
    //使用常量作为本程序的多点广播IP地址
    private static final String BROADCAST_IP = "230.0.0.1";
    //使用常量作为本程序的多点广播目的地端口
    private static final int BROADCAST_POST = 30000;
    //定义每个数据报的大小最大为4KB
    private static final int DATA_LEN = 4096;
    //定义本程序的MulticastSocket实列
    private MulticastSocket socket = null;
    private InetAddress broadcastAddress = null;
    //定义接收网络数据的字节数组
    byte[] inBuff = new byte[DATA_LEN];
    //以指定字节数组创建准备接收数据的DatagramPacket对象
    private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
    //定义一个用于发送的DatagramPacket对象
    private DatagramPacket outPacket = null;
    
    public void init() throws IOException {
        try (
                Scanner scan = new Scanner(System.in);
            ) {
            //创建用于发送、接收数据的MulticastSocket对象
            //用于该MulticastSocket对象需要接收数据，所以有指定端口
            socket = new MulticastSocket(BROADCAST_POST);
            broadcastAddress = InetAddress.getByName(BROADCAST_IP);
            //将该socket加入指定的多点广播地址
            socket.joinGroup(broadcastAddress);
            //设置本MulticastSocket发送的数据报会被回送到自身
            socket.setLoopbackMode(false);
            //初始化发送用的DatagramSocket，它包含一个长度为0的字节数组
            outPacket = new DatagramPacket(new byte[0], 0, broadcastAddress, BROADCAST_POST);
            //启动以本实例的run()方法作为线程执行体的线程
            new Thread(this).start();
            //不断地读取键盘输入
            while (scan.hasNextLine()) {
                byte[] buff = scan.nextLine().getBytes();
                outPacket.setData(buff);
                socket.send(outPacket);
            }
        } finally {
            socket.close();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                socket.receive(inPacket);
                System.out.println(new String(inBuff, 0, inBuff.length));
            }
        } catch (IOException e) {
            e.printStackTrace();
            try {
                if (socket != null) {
                    socket.leaveGroup(broadcastAddress);
                    socket.close();
                }
                System.exit(1);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new MulticastSocketTest().init();
    }
}
