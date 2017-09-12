package com.silencetao.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

/**
 * MulticastSocket�����
 * @author Silence
 * create time 2017��7��27�� ����9:45:46
 * @version 1.0.1
 */
public class MulticastSocketTest implements Runnable {
    //ʹ�ó�����Ϊ������Ķ��㲥IP��ַ
    private static final String BROADCAST_IP = "230.0.0.1";
    //ʹ�ó�����Ϊ������Ķ��㲥Ŀ�ĵض˿�
    private static final int BROADCAST_POST = 30000;
    //����ÿ�����ݱ��Ĵ�С���Ϊ4KB
    private static final int DATA_LEN = 4096;
    //���屾�����MulticastSocketʵ��
    private MulticastSocket socket = null;
    private InetAddress broadcastAddress = null;
    //��������������ݵ��ֽ�����
    byte[] inBuff = new byte[DATA_LEN];
    //��ָ���ֽ����鴴��׼���������ݵ�DatagramPacket����
    private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
    //����һ�����ڷ��͵�DatagramPacket����
    private DatagramPacket outPacket = null;
    
    public void init() throws IOException {
        try (
                Scanner scan = new Scanner(System.in);
            ) {
            //�������ڷ��͡��������ݵ�MulticastSocket����
            //���ڸ�MulticastSocket������Ҫ�������ݣ�������ָ���˿�
            socket = new MulticastSocket(BROADCAST_POST);
            broadcastAddress = InetAddress.getByName(BROADCAST_IP);
            //����socket����ָ���Ķ��㲥��ַ
            socket.joinGroup(broadcastAddress);
            //���ñ�MulticastSocket���͵����ݱ��ᱻ���͵�����
            socket.setLoopbackMode(false);
            //��ʼ�������õ�DatagramSocket��������һ������Ϊ0���ֽ�����
            outPacket = new DatagramPacket(new byte[0], 0, broadcastAddress, BROADCAST_POST);
            //�����Ա�ʵ����run()������Ϊ�߳�ִ������߳�
            new Thread(this).start();
            //���ϵض�ȡ��������
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
