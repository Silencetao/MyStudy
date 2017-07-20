package com.silencetao.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * ������ÿ���߳�ͨ�ŵ��߳���
 * @author Silence
 * create time 2017��7��20�� ����12:17:57
 * @version 1.0.1
 */
public class ServerThread implements Runnable {
    //���嵱ǰ�߳��������socket
    private Socket s = null;
    //���߳��������Socket��Ӧ��������
    private BufferedReader br = null;
    
    public ServerThread(Socket s) throws IOException {
        this.s = s;
        //��ʼ����socket��Ӧ��������
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }
    
    @Override
    public void run() {
        System.out.println("��С�����������");
        try {
            String content = null;
            //����ѭ�����ϵش�Socket�ж�ȡ�ͻ��˷��͹���������
            while ((content = readFromClient()) != null) {
                //����socketList�е�ÿ��Socket
                //��������������ÿ��Socket����һ��
                for (Socket socket : MyServer.sockets) {
//                    if (socket.equals(s)) {
//                        continue ;
//                    }
                    PrintStream ps = new PrintStream(socket.getOutputStream());
                    //������ͨ��IO����
                    ps.println(content);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * �����ȡ�ͻ������ݵķ���
     * @return
     */
    private String readFromClient() {
        try {
            return br.readLine();
        } catch (IOException e) {
            System.out.println("��С���Ͽ�������");
            //ɾ����socket
            MyServer.sockets.remove(s);
        }
        return null;
    }
}
