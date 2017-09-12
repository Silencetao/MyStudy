package com.silencetao.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * upd��������
 * @author Silence
 * create time 2017��7��24�� ����3:49:11
 * @version 1.0.1
 */
public class UdpServer {
    public static final int PROT = 30000;
    //����ÿ�����ݱ��Ĵ�С���Ϊ4KB
    private static final int DATA_LEN = 4096;
    //��������������ݵ��ֽ�����
    byte[] inBuff = new byte[DATA_LEN];
    
    //��ָ���ֽ����鴴��׼���������ݵ�DatagramPacket����
    private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
    //����һ�����ڷ��͵�DatagramPacket����
    private DatagramPacket outPacket;
    
    //����һ���ַ������飬���������͸������Ԫ��
    String[] books = new String[] {
        "���Java����",
        "���Android����",
        "���Ajax����",
        "Java�����ŵ�סԺ"
    };
    
    /**
     * ��������������
     * @version 1.0.1 
     * @throws IOException
     */
    public void init() throws IOException {
        try (
                //����DatagramSocket����
                DatagramSocket socket = new DatagramSocket(PROT);
            ) {
            //����ѭ����������
            for (int i = 0; i < 1000; i++) {
                //��ȡSocket�е����ݣ����������ݷ���inPacket��װ��������
                socket.receive(inPacket);
                //�ж�inPack.getData()��inBuff�Ƿ���ͬһ������
                System.out.println(inBuff == inPacket.getData());
                //���յ�������ת�����ַ��������
                System.out.println(new String(inBuff, 0, inPacket.getLength()));
                //���ַ���������ȡ��һ��Ԫ����Ϊ��������
                byte[] sendData = books[i % 4].getBytes();
                //��ָ�����ֽ�������Ϊ�������ݣ��Ըս��յ�DatagramPacket��ԴSocketAddress
                //��ΪĿ��SocketAddress����DatagramPacket
                outPacket = new DatagramPacket(sendData, sendData.length, inPacket.getSocketAddress());
                //��������
                socket.send(outPacket);
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
        new UdpServer().init();
    }
}
