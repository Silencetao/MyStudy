package com.silencetao.nio;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * 文件锁
 * @author Silence
 *
 */
public class FileLockTest {

	public static void main(String[] args) {
		try (
				FileChannel channel = new FileOutputStream("a.txt").getChannel();
			) {
			//使用非阻塞式方式对指定文件加锁
			System.out.println("----->");
			FileLock lock = channel.tryLock();
			//暂停程序10s
			Thread.sleep(10000);
			//释放锁
			lock.release();
			System.out.println("----->");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
