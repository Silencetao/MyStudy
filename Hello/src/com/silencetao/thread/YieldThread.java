package com.silencetao.thread;

/**
 * �߳��ò�:yield
 * @author Silence
 *
 */
public class YieldThread extends Thread {
	
	public YieldThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			if (i == 20) {
				Thread.yield();
				System.out.println(getName() + "----->" + i);
			} else {
				System.out.println(getName() + " " + i);
			}
		}
	}
	
	public static void main(String[] args) {
		YieldThread yt1 = new YieldThread("�߼�");
		//��yt1���ó�������ȼ�
		yt1.setPriority(Thread.MAX_PRIORITY);
		yt1.start();
		YieldThread yt2 = new YieldThread("�ͼ�");
		//��yt2���ó�������ȼ�
		yt2.setPriority(Thread.MIN_PRIORITY);
		yt2.start();
	}
}
