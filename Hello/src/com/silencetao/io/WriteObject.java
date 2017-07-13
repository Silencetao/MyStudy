package com.silencetao.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 将对象写入文件中
 * @author Silence
 *
 */
public class WriteObject {

	public static void main(String[] args) {
		try (
				//创建一个ObjectOutputSteam输出流
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("io/object.txt"));
			) {
			Person per = new Person("Silence", 22);
			//将per对象写入输出流
			oos.writeObject(per);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
