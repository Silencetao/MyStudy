package com.silencetao.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * ʹ��socketͨ�ţ��ͻ���
 * @author Silence
 * create time 2017��7��20�� ����11:12:39
 * @version 1.0.1
 */
public class ClientTest {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 30000);
        //��Socket��Ӧ����������װ��BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //������ͨIO����
        String line = br.readLine();
        System.out.println("���Է�����������:" + line);
        //�ر����������ر�Socket
        br.close();
        socket.close();
    }
}
