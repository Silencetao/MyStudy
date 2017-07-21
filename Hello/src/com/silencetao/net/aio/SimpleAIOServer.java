package com.silencetao.net.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

/**
 * ����AsynchronousServerSocketChannel�ķ�������
 * @author Silence
 * create time 2017��7��21�� ����3:56:28
 * @version 1.0.1
 */
public class SimpleAIOServer {
    static final int PORT = 30000;
    
    public static void main(String[] args) {
        try (
                //����AsynchronousServerSocketChannel����
                AsynchronousServerSocketChannel serverChannel = 
                AsynchronousServerSocketChannel.open();
            ) {
            //ָ����ָ����ַ���˿ڼ���
            serverChannel.bind(new InetSocketAddress(PORT));
            while (true) {
                //����ѭ���������Կͻ��˵�����
                Future<AsynchronousSocketChannel> future = serverChannel.accept();
                //��ȡ������ɺ󷵻ص�AsynchronousSocketChannel
                AsynchronousSocketChannel socketChannel = future.get();
                //ִ�����
                socketChannel.write(ByteBuffer.wrap("��ð�������".getBytes("UTF-8"))).get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
