package com.silencetao.thread;

import org.ietf.jgss.Oid;

/**
 * 设置线程的优先级
 * @author Silence
 *
 */
public class PriorityTest extends Thread {
	
	public PriorityTest(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(getName() + "----->优先级:" + getPriority() + "<-----" + i);
		}
	}
	
	public static void main(String[] args) {
		//改变主线程的优先级
		Thread.currentThread().setPriority(6);
		System.out.println(Thread.currentThread().getName() + "创建之初的优先级:" + Thread.currentThread().getPriority());
		for (int i = 0; i < 30; i++) {
			System.out.println(Thread.currentThread().getName() + "----->优先级:" + Thread.currentThread().getPriority() + "<-----" + i);
			if (i == 10) {
				PriorityTest low = new PriorityTest("低级");
				low.start();
				System.out.println(low.getName() + "创建之初的优先级:" + low.getPriority());
				low.setPriority(Thread.MIN_PRIORITY);
			}
			if (i == 20) {
				PriorityTest high = new PriorityTest("高级");
				high.start();
				System.out.println(high.getName() + "创建之初的优先级:" + high.getPriority());
				high.setPriority(Thread.MAX_PRIORITY);
			}
		}
	}
}
