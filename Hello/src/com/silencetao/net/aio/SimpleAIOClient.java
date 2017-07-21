package com.silencetao.net.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;

/**
 * ����AsynchronousSocketChannel�Ŀͻ���
 * @author Silence
 * create time 2017��7��21�� ����4:04:00
 * @version 1.0.1
 */
public class SimpleAIOClient {
    static final int PORT = 30000;
    
    public static void main(String[] args) {
        //���ڶ�ȡ���ݵ�ByteBuffer
        ByteBuffer buff = ByteBuffer.allocate(1024);
        Charset utf = Charset.forName("UTF-8");
        try (
                //����AsynchronousSocketChannel����
                AsynchronousSocketChannel clientChannel = 
                AsynchronousSocketChannel.open();
            ) {
            //���ӷ�����
            clientChannel.connect(new InetSocketAddress("127.0.0.1", PORT)).get();
            buff.clear();
            //��clientChannel�ж�ȡ����
            clientChannel.read(buff).get();
            buff.flip();
            //��buff�е��ַ�����ת�����ַ���
            String content = utf.decode(buff).toString();
            System.out.println("��������Ϣ:" + content);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
