package com.silencetao.nio;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * �ļ���
 * @author Silence
 *
 */
public class FileLockTest {

	public static void main(String[] args) {
		try (
				FileChannel channel = new FileOutputStream("a.txt").getChannel();
			) {
			//ʹ�÷�����ʽ��ʽ��ָ���ļ�����
			System.out.println("----->");
			FileLock lock = channel.tryLock();
			//��ͣ����10s
			Thread.sleep(10000);
			//�ͷ���
			lock.release();
			System.out.println("----->");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
