package com.silencetao.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * ʹ��Channel��Bufferͨ�����ִ��ȡ������
 * @author Silence
 *
 */
public class ReadFile {

	public static void main(String[] args) {
		try (
				FileInputStream fis = new FileInputStream("src\\com\\silencetao\\nio\\ReadFile.java");
				FileChannel fcin = fis.getChannel();
			) {
			//����һ��ByteBuffer���������ظ�ȡˮ
			ByteBuffer bbuff = ByteBuffer.allocate(256);
			//��FileChannel�е����ݷ���ByteBuffer��
			while (fcin.read(bbuff) != -1) {
				//����Buffer�Ŀհ�����
				bbuff.flip();
				//����Charset����
				Charset charset = Charset.forName("GBK");
				//��������������
				CharsetDecoder decoder = charset.newDecoder();
				//��ByteBuffer������ת��
				CharBuffer cBuffer = decoder.decode(bbuff);
				System.out.println(cBuffer);
				//��Buffer��ʼ����Ϊ��һ�ζ�ȡ������׼��
				bbuff.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
