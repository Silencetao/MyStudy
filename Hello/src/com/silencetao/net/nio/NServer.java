package com.silencetao.net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * ʹ��NIOʵ�ַ�����Socketͨ�ţ���������
 * @author Silence
 * create time 2017��7��21�� ����1:11:38
 * @version 1.0.1
 */
public class NServer {
    //���ڼ�����е�Channel״̬��Selector
    private Selector selector = null;
    static final int PORT = 30000;
    //����ʵ�ֱ��롢������ַ�������
    private Charset charset = Charset.forName("UTF-8");
    
    public void init() throws IOException {
        selector = Selector.open();
        //ͨ��open��������һ��δ�󶨵�ServerSocketChannelʵ��
        ServerSocketChannel server = ServerSocketChannel.open();
        InetSocketAddress isa = new InetSocketAddress("127.0.0.1", PORT);
        //����ServerSocketChannel�󶨵�ָ��IP��ַ
        server.bind(isa);
        //����ServerSocket�Է�������ʽ����
        server.configureBlocking(false);
        //��serverע�ᵽָ����Selector����
        server.register(selector, SelectionKey.OP_ACCEPT);
        int len = 0;
        while ((len = selector.select()) > 0) {
            System.out.println("Ŀǰ��" + len + "��SelectionKey");
            //���δ���selector�ϵ�ÿ����ѡ���SelectionKey
            for (SelectionKey sk : selector.keys()) {
                //��selector�ϵ���ѡ��key����ɾ�����ڴ����SelectionKey
                selector.selectedKeys().remove(sk);
                //���sk��Ӧ��Channel�����ͻ��˵���������
                if (sk.isAcceptable()) {
                    //����accept�����������ӣ������������˵�SocketChannel
                    SocketChannel sc = server.accept();
                    if (sc == null) {
                        continue ;
                    }
                    //���ò��÷�����ģʽ
                    sc.configureBlocking(false);
                    //����SocketChannelҲע�ᵽselector
                    sc.register(selector, SelectionKey.OP_READ);
                    //����Ӧ��Channel���ó�׼��������������
                    sk.interestOps(SelectionKey.OP_ACCEPT);
                    System.out.println("��С�����������");
                }
                //���sk��Ӧ��Channel��������Ҫ��ȡ
                if (sk.isReadable()) {
                    //��ȡ��SelectionKey��Ӧ��Channel����Channel���пɶ�������
                    SocketChannel sc = (SocketChannel) sk.channel();
                    //����׼��ִ�ж�ȡ���ݵ�ByteBuffer
                    ByteBuffer buff = ByteBuffer.allocate(1024);
                    String content = "";
                    //��ʼ��ȡ����
                    try {
                        while (sc.read(buff) > 0) {
                            buff.flip();
                            content += charset.decode(buff);
                        }
                        //��ӡ�Ӹ�sk��Ӧ��Channel���ȡ��������
                        System.out.println("��ȡ������:" + content);
                        //��sk��Ӧ��Channel���ó�׼���´ζ�ȡ
                        sk.interestOps(SelectionKey.OP_READ);
                    }
                    //������񵽸�sk��Ӧ��Channel�������쳣��������Channel
                    //��Ӧ��Client���������⣬���Դ�Selector��ȡ��sk��ע��
                    catch (Exception e) {
                        //��Selector��ɾ��ָ����SelectionKey
                        sk.cancel();
                        if (sk.channel() != null) {
                            sk.channel().close();
                        }
                        System.out.println("��С���Ͽ���");
                    }
                    //���contact�ĳ��ȴ���0����������Ϣ��Ϊ��
                    if (content.length() > 0) {
                        //������selector��ע�������SelectionKey
                        for (SelectionKey key : selector.keys()) {
                            //��ȡ��key��Ӧ��Channel
                            Channel targetChannel = key.channel();
                            //�����Channel��SocketChannel����
                            if (targetChannel instanceof SocketChannel) {
                                //������������д���Channel��
                                SocketChannel dest = (SocketChannel) targetChannel;
                                dest.write(charset.encode(content));
                            }
                        }
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        new NServer().init();
    }
}
