package com.silencetao.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * �߳�˯��:sleep()����
 * @author Silence
 *
 */
public class SleepThread {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < 10; i++) {
			System.out.println(sdf.format(new Date()));
			Thread.sleep(1000);
		}
	}
}
