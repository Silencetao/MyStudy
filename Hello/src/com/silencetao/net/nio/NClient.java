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
 * 使用NIO实现非阻塞Socket通信，客户端
 * @author Silence
 * create time 2017年7月21日 下午2:43:33
 * @version 1.0.1
 */
public class NClient {
    //定义检测SocketChannel的Selector对象
    private Selector selector = null;
    static final int PORT = 30000;
    //定义处理编码和解码的字符集
    private Charset charset = Charset.forName("UTF-8");
    //客户端SocketChannel
    private SocketChannel sc = null;
    
    @SuppressWarnings("resource")
    public void init() throws IOException {
        selector = Selector.open();
        InetSocketAddress isa = new InetSocketAddress("127.0.0.1", PORT);
        //调用open静态方法创建连接到指定主机的SocketChannel
        sc = SocketChannel.open(isa);
        //设置该sc以非阻塞方法创建连接到指定主机的SocketChannel
        sc.configureBlocking(false);
        //将SocketChannel对象注册到指定的Selector
        sc.register(selector, SelectionKey.OP_READ);
        
        //启动读取服务器端数据的线程
        new ClientThread().start();
        
        //创建键盘输入流
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            //读取键盘输入
            String line = scan.nextLine();
            //将键盘输入的内容输出到SocketChannel中
            sc.write(charset.encode(line));
        }
    }
    
    /**
     * 定义读取服务器端数据的线程
     * @author Silence
     * create time 2017年7月21日 下午2:57:03
     * @version 1.0.1
     */
    private class ClientThread extends Thread {
        
        @Override
        public void run() {
            try {
                while (selector.select() > 0) {
                    //遍历每个有可用IO操作的Channel对应的SelectKey
                    for (SelectionKey sk : selector.selectedKeys()) {
                        //删除正在处理的SelectionKey
                        selector.selectedKeys().remove(sk);
                        //如果该SelectionKey对应的Channel中有可读数据
                        if (sk.isReadable()) {
                            //使用NIO读取Channel中的数据
                            SocketChannel sc = (SocketChannel) sk.channel();
                            ByteBuffer buff = ByteBuffer.allocate(1024);
                            String content = "";
                            while (sc.read(buff) > 0) {
                                buff.flip();
                                content += charset.decode(buff);
                            }
                            //打印输出读取的内容
                            System.out.println("聊天信息:" + content);
                            //为下一次读取做准备
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
