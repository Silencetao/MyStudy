package com.silencetao.net.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ʵ���Լ���CompletionHandler��
 * @author Silence
 * create time 2017��7��21�� ����4:37:50
 * @version 1.0.1
 */
class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {
    private AsynchronousServerSocketChannel serverChannel;
    //����һ��ByteBuffer׼����ȡ����
    ByteBuffer buff = ByteBuffer.allocate(1024);
    
    public AcceptHandler(AsynchronousServerSocketChannel serverChannel) {
        this.serverChannel = serverChannel;
    }
    
    //��ʵ��IO�������ʱ�����÷���
    @Override
    public void completed(AsynchronousSocketChannel sc,
            Object attachment) {
        //��¼�����ӽ�����Channel
        AIOServer.channelList.add(sc);
        //׼�����տͻ��˵���һ������
        serverChannel.accept(null, this);
        sc.read(buff, null, new CompletionHandler<Integer, Object>() {

            @Override
            public void completed(Integer result, Object attachment) {
                buff.flip();
                //��buff�е�����ת��Ϊ�ַ���
                String content = StandardCharsets.UTF_8.decode(buff).toString();
                //����ÿ��Channel�����յ�����Ϣд���Channel��
                for (AsynchronousSocketChannel c : AIOServer.channelList) {
                    try {
                        c.write(ByteBuffer.wrap(content.getBytes(AIOServer.UTF_8))).get();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                buff.clear();
                //��ȡ��һ������
                sc.read(buff, null, this);
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("��ȡ����ʧ��:" + exc);
                //�Ӹ�Channel�ж�ȡ����ʧ�ܣ��ͽ���Channelɾ��
                AIOServer.channelList.remove(sc);
            }
        });
    }

    @Override
    public void failed(Throwable exc, Object attachment) {
        System.out.println("����ʧ��");
    }
    
}

/**
 * ����AIO�Ķ�������ϵͳ������˴���
 * @author Silence
 * create time 2017��7��21�� ����4:15:09
 * @version 1.0.1
 */
public class AIOServer {
    static final int PORT = 30000;
    static final String UTF_8 = "UTF-8";
    static List<AsynchronousSocketChannel> channelList = new ArrayList<AsynchronousSocketChannel>();
    
    public void startListen() throws Exception {
        //����һ���̳߳�
        ExecutorService executor = Executors.newFixedThreadPool(20);
        //��ָ���̳߳�������һ��AsynchronousChannelGroup
        AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withThreadPool(executor);
        //��ָ���̳߳�������һ��AsynchronousServerSocketChannel
        AsynchronousServerSocketChannel serverChannel = 
                AsynchronousServerSocketChannel.open(channelGroup).bind(new InetSocketAddress(PORT));
        //ʹ��CompletionHandler�������Կͻ��˵���������
        serverChannel.accept(null, new AcceptHandler(serverChannel));
    }
    
    /**
     * ��Ȼ�ܲ�����
     * ��������
     * ��~
     * ���ˣ��ȷ��Ű�
     * �r(�s���t)�q
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        AIOServer server = new AIOServer();
        server.startListen();
    }
}
