package com.silencetao.thread;

import org.ietf.jgss.Oid;

/**
 * �����̵߳����ȼ�
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
			System.out.println(getName() + "----->���ȼ�:" + getPriority() + "<-----" + i);
		}
	}
	
	public static void main(String[] args) {
		//�ı����̵߳����ȼ�
		Thread.currentThread().setPriority(6);
		System.out.println(Thread.currentThread().getName() + "����֮�������ȼ�:" + Thread.currentThread().getPriority());
		for (int i = 0; i < 30; i++) {
			System.out.println(Thread.currentThread().getName() + "----->���ȼ�:" + Thread.currentThread().getPriority() + "<-----" + i);
			if (i == 10) {
				PriorityTest low = new PriorityTest("�ͼ�");
				low.start();
				System.out.println(low.getName() + "����֮�������ȼ�:" + low.getPriority());
				low.setPriority(Thread.MIN_PRIORITY);
			}
			if (i == 20) {
				PriorityTest high = new PriorityTest("�߼�");
				high.start();
				System.out.println(high.getName() + "����֮�������ȼ�:" + high.getPriority());
				high.setPriority(Thread.MAX_PRIORITY);
			}
		}
	}
}
