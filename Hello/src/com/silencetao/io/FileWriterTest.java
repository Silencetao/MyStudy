package com.silencetao.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter类测试
 * @author Silence
 *
 */
public class FileWriterTest {

	public static void main(String[] args) {
		try (
			FileWriter fw = new FileWriter("io/FileWriter.txt")) {
			fw.write("锦瑟-李商隐\r\n");
			fw.write("锦瑟无端五十弦，一弦一柱思华年。\r\n");
			fw.write("庄生晓梦迷蝴蝶，望帝春心托杜鹃。\r\n");
			fw.write("沧海明月珠有泪，蓝田日暖玉生烟。\r\n");
			fw.write("此情可待成追忆，只是当时已惘然。\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
