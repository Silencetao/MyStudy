package com.silencetao.thread;

/**
 * 线程让步:yield
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
		YieldThread yt1 = new YieldThread("高级");
		//将yt1设置成最高优先级
		yt1.setPriority(Thread.MAX_PRIORITY);
		yt1.start();
		YieldThread yt2 = new YieldThread("低级");
		//将yt2设置成最低优先级
		yt2.setPriority(Thread.MIN_PRIORITY);
		yt2.start();
	}
}
