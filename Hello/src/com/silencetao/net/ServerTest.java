package com.silencetao.net;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ʹ��socketͨ�ţ������
 * @author Silence
 * create time 2017��7��20�� ����11:04:15
 * @version 1.0.1
 */
public class ServerTest {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception {
        //����һ��ServerSocket�����ڼ����ͻ���Socket����������
        ServerSocket ss = new ServerSocket(30000);
        //����ѭ�����ϵĽ������Կͻ��˵�����
        while (true) {
            //ÿ�����յ��ͻ���socket������ʱ����������Ҳ��Ӧ����һ��Socket
            Socket s = ss.accept();
            //��Socket��Ӧ���������װ��PrintStream
            PrintStream ps = new PrintStream(s.getOutputStream());
            //������ͨ��IO����
            ps.println("���ã�Silence");
            //�ر���������ر�Socket
            ps.close();
            s.close();
        }
    }
}
