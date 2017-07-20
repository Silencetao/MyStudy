package com.silencetao.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ServerSocket����˼�����
 * @author Silence
 * create time 2017��7��20�� ����12:28:23
 * @version 1.0.1
 */
public class MyServer {
    //���屣������Socket��ArrayList���������װΪ�̰߳�ȫ��
    public static List<Socket> sockets = Collections.synchronizedList(new ArrayList<Socket>());
    
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(30000);
        while (true) {
            //�˴������������һֱ�ȴ��ͻ��˵�����
            Socket socket = ss.accept();
            sockets.add(socket);
            //ÿ���ͻ������ӳɹ�������һ��ServerThread�߳�Ϊ�ÿͻ��˷���
            new Thread(new ServerThread(socket)).start();
        }
    }
}
