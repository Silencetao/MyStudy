package com.silencetao.thread;

/**
 * ʵ��Runnable�ӿڴ����߳���
 * @author Silence
 *
 */
public class SecondThread implements Runnable {
	private int i;
	
	//run()����ͬ�����߳�ִ����
	@Override
	public void run() {
		for ( ; i < 100; i++) {
			//���߳���ʵ��Runnable�ӿ�ʱ
			//������õ�ǰ�̣߳�ֻ����Thread.currentThread()����
			System.out.println(Thread.currentThread().getName() + " " +i);
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 20) {
				SecondThread st = new SecondThread();
				//ͨ��new Thread(target, name)�����������߳�
				new Thread(st, "�߳�-1").start();
				new Thread(st, "�߳�-2").start();
			}
		}
	}
}
