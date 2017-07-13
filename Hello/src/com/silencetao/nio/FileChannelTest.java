package com.silencetao.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * FileChannel�����
 * @author Silence
 *
 */
public class FileChannelTest {

	public static void main(String[] args) {
		File file = new File("src\\com\\silencetao\\nio\\FileChannelTest.java");
		try (
				//����FileInputStream���Ը��ļ�����������FileChannel
				FileChannel inChannel = new FileInputStream(file).getChannel();
				//���ļ����������FileChannel�����Կ������
				FileChannel outChannel = new FileOutputStream("nio/FileChannel.txt").getChannel();
			) {
			//��FileChannel���ȫ������ӳ���ByteBuffer
			MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			//ʹ��GBK���ַ�������������
			Charset charset = Charset.forName("GBK");
			//ֱ�ӽ�buffer�������ȫ�����
			outChannel.write(buffer);
			//����buffer��clear()��������ԭlimit��position��λ��
			buffer.clear();
			//����������(CharsetDecoder)����
			CharsetDecoder decoder = charset.newDecoder();
			//ʹ�ý�������ByteBufferת����CharBuffer
			CharBuffer charBuffer = decoder.decode(buffer);
			//CharBuffer��toString�������Ի�ȡ��Ӧ���ַ���
			System.out.println(charBuffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
