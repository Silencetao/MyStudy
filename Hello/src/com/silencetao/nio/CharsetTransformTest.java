package com.silencetao.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * ����ͽ���
 * @author Silence
 *
 */
public class CharsetTransformTest {

	public static void main(String[] args) throws Exception {
		//�����������Ķ�Ӧ��Charset
		Charset cn = Charset.forName("GBK");
		//��ȡcn�����Ӧ�ı������ͽ�����
		CharsetEncoder encoder = cn.newEncoder();
		CharsetDecoder decoder = cn.newDecoder();
		//����һ��CharBuffer����
		CharBuffer cbuffer = CharBuffer.allocate(8);
		cbuffer.put('a');
		cbuffer.put('b');
		cbuffer.put('c');
		cbuffer.put('d');
		cbuffer.flip();
		//��CharBuffer�е��ַ�����ת�����ֽ�����
		ByteBuffer bbuffer = encoder.encode(cbuffer);
		for (int i = 0; i < bbuffer.limit(); i++) {
			System.out.println(bbuffer.get(i) + " ");
		}
		System.out.println("\n" + decoder.decode(bbuffer));
	}
}
