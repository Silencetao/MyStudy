package com.silencetao.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {
    //���巢�����ݵ�Ŀ�ĵ�
    public static final int DEST_POST = 30000;
    public static final String DEST_IP = "127.0.0.1";
    //����ÿ�����ݱ��Ĵ�С���Ϊ4KB
    private static final int DATA_LEN = 4096;
    //��������������ݵ��ֽ�����
    byte[] inBuff = new byte[DATA_LEN];
    
    //��ָ���ֽ����鴴��׼���������ݵ�DatagramPacket����
    private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
    //����һ�����ڷ��͵�DatagramPacket����
    private DatagramPacket outPacket;
    
    /**
     * �ͻ�����������
     * @version 1.0.1 
     * @throws IOException
     */
    public void init() throws IOException {
        try (
                //����һ���ͻ���DatagramSocket��ʹ������˿�
                DatagramSocket socket = new DatagramSocket();
            ) {
            //��ʼ�������õ�DatagramSocket����������һ������Ϊ0���ֽ�����
            outPacket = new DatagramPacket(new byte[0], 0, InetAddress.getByName(DEST_IP), DEST_POST);
            //��������������
            Scanner scanner = new Scanner(System.in);
            //���ϵĶ�ȡ��������
            while (scanner.hasNextLine()) {
                //�����������һ���ַ���ת�����ֽ�����
                byte[] buff = scanner.nextLine().getBytes();
                //���÷����õ�DatagramPacket�е��ֽ�����
                outPacket.setData(buff);
                //�������ݱ�
                socket.send(outPacket);
                //��ȡSocket�е����ݣ����������ݷ���inPacket����װ���ֽ�������
                socket.receive(inPacket);
                System.out.println(new String(inBuff, 0, inBuff.length));
            }
        }
    }
    
    /**
     * ���������
     * @version 1.0.1 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        new UdpClient().init();
    }
}
