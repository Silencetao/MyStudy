package com.silencetao.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * 使用Channel和Buffer通过多次执行取出操作
 * @author Silence
 *
 */
public class ReadFile {

	public static void main(String[] args) {
		try (
				FileInputStream fis = new FileInputStream("src\\com\\silencetao\\nio\\ReadFile.java");
				FileChannel fcin = fis.getChannel();
			) {
			//定义一个ByteBuffer对象，用于重复取水
			ByteBuffer bbuff = ByteBuffer.allocate(256);
			//将FileChannel中的数据放入ByteBuffer中
			while (fcin.read(bbuff) != -1) {
				//锁定Buffer的空白区域
				bbuff.flip();
				//创建Charset对象
				Charset charset = Charset.forName("GBK");
				//创建解码器对象
				CharsetDecoder decoder = charset.newDecoder();
				//将ByteBuffer的内容转码
				CharBuffer cBuffer = decoder.decode(bbuff);
				System.out.println(cBuffer);
				//将Buffer初始化，为下一次读取数据做准备
				bbuff.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
