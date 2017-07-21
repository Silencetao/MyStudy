package com.silencetao.net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * ʹ��NIOʵ�ַ�����Socketͨ�ţ��ͻ���
 * @author Silence
 * create time 2017��7��21�� ����2:43:33
 * @version 1.0.1
 */
public class NClient {
    //������SocketChannel��Selector����
    private Selector selector = null;
    static final int PORT = 30000;
    //���崦�����ͽ�����ַ���
    private Charset charset = Charset.forName("UTF-8");
    //�ͻ���SocketChannel
    private SocketChannel sc = null;
    
    @SuppressWarnings("resource")
    public void init() throws IOException {
        selector = Selector.open();
        InetSocketAddress isa = new InetSocketAddress("127.0.0.1", PORT);
        //����open��̬�����������ӵ�ָ��������SocketChannel
        sc = SocketChannel.open(isa);
        //���ø�sc�Է����������������ӵ�ָ��������SocketChannel
        sc.configureBlocking(false);
        //��SocketChannel����ע�ᵽָ����Selector
        sc.register(selector, SelectionKey.OP_READ);
        
        //������ȡ�����������ݵ��߳�
        new ClientThread().start();
        
        //��������������
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            //��ȡ��������
            String line = scan.nextLine();
            //��������������������SocketChannel��
            sc.write(charset.encode(line));
        }
    }
    
    /**
     * �����ȡ�����������ݵ��߳�
     * @author Silence
     * create time 2017��7��21�� ����2:57:03
     * @version 1.0.1
     */
    private class ClientThread extends Thread {
        
        @Override
        public void run() {
            try {
                while (selector.select() > 0) {
                    //����ÿ���п���IO������Channel��Ӧ��SelectKey
                    for (SelectionKey sk : selector.selectedKeys()) {
                        //ɾ�����ڴ����SelectionKey
                        selector.selectedKeys().remove(sk);
                        //�����SelectionKey��Ӧ��Channel���пɶ�����
                        if (sk.isReadable()) {
                            //ʹ��NIO��ȡChannel�е�����
                            SocketChannel sc = (SocketChannel) sk.channel();
                            ByteBuffer buff = ByteBuffer.allocate(1024);
                            String content = "";
                            while (sc.read(buff) > 0) {
                                buff.flip();
                                content += charset.decode(buff);
                            }
                            //��ӡ�����ȡ������
                            System.out.println("������Ϣ:" + content);
                            //Ϊ��һ�ζ�ȡ��׼��
                            sk.interestOps(SelectionKey.OP_READ);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        new NClient().init();
    }
}
