package com.silencetao.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * 编码和解码
 * @author Silence
 *
 */
public class CharsetTransformTest {

	public static void main(String[] args) throws Exception {
		//创建简体中文对应的Charset
		Charset cn = Charset.forName("GBK");
		//获取cn对象对应的编码器和解码器
		CharsetEncoder encoder = cn.newEncoder();
		CharsetDecoder decoder = cn.newDecoder();
		//创建一个CharBuffer对象
		CharBuffer cbuffer = CharBuffer.allocate(8);
		cbuffer.put('a');
		cbuffer.put('b');
		cbuffer.put('c');
		cbuffer.put('d');
		cbuffer.flip();
		//将CharBuffer中的字符序列转换成字节序列
		ByteBuffer bbuffer = encoder.encode(cbuffer);
		for (int i = 0; i < bbuffer.limit(); i++) {
			System.out.println(bbuffer.get(i) + " ");
		}
		System.out.println("\n" + decoder.decode(bbuffer));
	}
}
