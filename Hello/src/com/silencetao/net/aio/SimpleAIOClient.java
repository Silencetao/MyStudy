package com.silencetao.net.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;

/**
 * 基于AsynchronousSocketChannel的客户端
 * @author Silence
 * create time 2017年7月21日 下午4:04:00
 * @version 1.0.1
 */
public class SimpleAIOClient {
    static final int PORT = 30000;
    
    public static void main(String[] args) {
        //用于读取数据的ByteBuffer
        ByteBuffer buff = ByteBuffer.allocate(1024);
        Charset utf = Charset.forName("UTF-8");
        try (
                //创建AsynchronousSocketChannel对象
                AsynchronousSocketChannel clientChannel = 
                AsynchronousSocketChannel.open();
            ) {
            //连接服务器
            clientChannel.connect(new InetSocketAddress("127.0.0.1", PORT)).get();
            buff.clear();
            //从clientChannel中读取数据
            clientChannel.read(buff).get();
            buff.flip();
            //将buff中的字符内容转换成字符串
            String content = utf.decode(buff).toString();
            System.out.println("服务器信息:" + content);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
