package com.silencetao.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * ������ͷ���˵�Socketͨ��
 * @author Silence
 * create time 2017��7��20�� ����12:46:34
 * @version 1.0.1
 */
class ClientThread implements Runnable {
    //���̸߳������socket
    private Socket s;
    //���߳��������Socket��Ӧ��������
    BufferedReader br = null;
    
    public ClientThread(Socket s) throws IOException {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }
    
    @Override
    public void run() {
        try {
            String content = null;
            //���ϵض�ȡSocket�������е����ݣ�������Щ���ݴ�ӡ���
            while ((content = br.readLine()) != null) {
                System.out.println("ClientThread--->" + content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * �ͻ��˳���
 * @author Silence
 * create time 2017��7��20�� ����12:45:23
 * @version 1.0.1
 */
public class MyClient {

    public static void main(String[] args) throws Exception {
        Socket s = new Socket("127.0.0.01", 30000);
        //�ͻ�������ClientThread�̲߳��ϵض�ȡ���Է�����������
        new Thread(new ClientThread(s)).start();
        //��ȡ��socket��Ӧ�������
        PrintStream ps = new PrintStream(s.getOutputStream());
        String line = null;
        //���ϵĶ�ȡ��������
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((line = br.readLine()) != null) {
            //���û��ļ�����������д��Socket��Ӧ�������
            ps.println(line);
        }
    }

}
