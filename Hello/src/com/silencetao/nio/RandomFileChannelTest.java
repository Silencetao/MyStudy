package com.silencetao.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用RandomAccessFile创建Channel对象
 * @author Silence
 *
 */
public class RandomFileChannelTest {

	public static void main(String[] args) {
		File file = new File("a.txt");
		try (
				//创建一个RandomAccessFile对象
				RandomAccessFile raf = new RandomAccessFile(file, "rw");
				//获取RandomAccessFile对应的Channel
				FileChannel randomChannel = raf.getChannel();
			) {
			//将Channel中的所有数据映射成ByteBuffer
			ByteBuffer buffer = randomChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			//把Channel的记录指针移动到最后
			randomChannel.position(file.length());
			//将buffer中的所有数据输出
			randomChannel.write(buffer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
