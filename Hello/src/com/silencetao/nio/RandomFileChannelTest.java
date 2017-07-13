package com.silencetao.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ʹ��RandomAccessFile����Channel����
 * @author Silence
 *
 */
public class RandomFileChannelTest {

	public static void main(String[] args) {
		File file = new File("a.txt");
		try (
				//����һ��RandomAccessFile����
				RandomAccessFile raf = new RandomAccessFile(file, "rw");
				//��ȡRandomAccessFile��Ӧ��Channel
				FileChannel randomChannel = raf.getChannel();
			) {
			//��Channel�е���������ӳ���ByteBuffer
			ByteBuffer buffer = randomChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			//��Channel�ļ�¼ָ���ƶ������
			randomChannel.position(file.length());
			//��buffer�е������������
			randomChannel.write(buffer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
