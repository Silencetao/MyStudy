package com.silencetao.net.udp.chatroom;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketAddress;

import javax.swing.JOptionPane;

/**
 * ���콻����Ϣ�Ĺ�����
 * @author Silence
 * create time 2017��7��27�� ����12:29:32
 * @version 1.0.1
 */
public class ComUtil {
    public static final String CHARSET = "utf-8";
    private static final String BROADCAST_IP = "230.0.0.1";
    private static final int DATA_LEN = 4096;
    public static final int BROADCAST_PORT = 30000;
    private MulticastSocket socket = null;
    private DatagramSocket singleSocket = null;
    private InetAddress broadcastAddress = null;
    byte[] inBuff = new byte[DATA_LEN];
    private DatagramPacket inPacket = new DatagramPacket(inBuff, inBuff.length);
    private DatagramPacket outPacket = null;
    private LanTalk lanTalk;
    
    public ComUtil(LanTalk lanTalk) throws Exception {
        this.lanTalk = lanTalk;
        socket = new MulticastSocket(BROADCAST_PORT);
        singleSocket = new DatagramSocket(BROADCAST_PORT + 1);
        broadcastAddress = InetAddress.getByName(BROADCAST_IP);
        socket.joinGroup(broadcastAddress);
        socket.setLoopbackMode(false);
        outPacket = new DatagramPacket(new byte[0], 0, broadcastAddress, BROADCAST_PORT);
    }
    
    /**
     * �㲥��Ϣ�Ĺ��߷���
     * @version 1.0.1 
     * @param msg
     */
    public void broadCast(String msg) {
        try {
            byte[] buff = msg.getBytes(CHARSET);
            outPacket.setData(buff);
            socket.send(outPacket);
        } catch (IOException e) {
            e.printStackTrace();
            if (socket != null) {
                socket.close();
            }
            JOptionPane.showMessageDialog(null, "������Ϣ�쳣����ȷ��30000�˿ڿ��У���������������",
                    "�����쳣", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    
    /**
     * �����򵥶��û�������Ϣ�ķ���
     * @version 1.0.1 
     * @param msg
     * @param dest
     * @return
     */
    public void sendSingle(String msg, SocketAddress dest) {
        try {
            byte[] buff = msg.getBytes(CHARSET);
            DatagramPacket packet = new DatagramPacket(buff, buff.length, dest);
            singleSocket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
            if (singleSocket != null) {
                singleSocket.close();
            }
            JOptionPane.showMessageDialog(null, "������Ϣ�쳣����ȷ��30000�˿ڿ��У���������������",
                    "�����쳣", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    
    class ReadSingle extends Thread {
        byte[] singleBuff = new byte[DATA_LEN];
        private DatagramPacket singlePacket = new DatagramPacket(singleBuff, singleBuff.length);
        
        @Override
        public void run() {
            while (true) {
                try {
                    singleSocket.receive(singlePacket);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        }
    }
}