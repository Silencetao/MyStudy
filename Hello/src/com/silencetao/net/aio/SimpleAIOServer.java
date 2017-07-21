package com.silencetao.net.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

/**
 * 基于AsynchronousServerSocketChannel的服务器端
 * @author Silence
 * create time 2017年7月21日 下午3:56:28
 * @version 1.0.1
 */
public class SimpleAIOServer {
    static final int PORT = 30000;
    
    public static void main(String[] args) {
        try (
                //创建AsynchronousServerSocketChannel对象
                AsynchronousServerSocketChannel serverChannel = 
                AsynchronousServerSocketChannel.open();
            ) {
            //指定在指定地址、端口监听
            serverChannel.bind(new InetSocketAddress(PORT));
            while (true) {
                //采用循环接受来自客户端的连接
                Future<AsynchronousSocketChannel> future = serverChannel.accept();
                //获取连接完成后返回的AsynchronousSocketChannel
                AsynchronousSocketChannel socketChannel = future.get();
                //执行输出
                socketChannel.write(ByteBuffer.wrap("你好啊，哈哈".getBytes("UTF-8"))).get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
