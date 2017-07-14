package com.silencetao.thread;

/**
 * ���ԶԴ�������״̬���߳��ٴε���start()����
 * ������״̬���̵߳���start()����ʱ
 * ������IllegalThreadStateException�쳣
 * 
 * ���½�״̬�Ľ������ε���start()����Ҳ�Ǵ����
 * Ҳ������IllegalThreadStateException�쳣
 * @author Silence
 *
 */
public class StartDead extends Thread {
	private int i;
	
	@Override
	public void run() {
		for ( ; i < 100; i++) {
			System.out.println(getName() + " " + i);
		}
	}
	
	public static void main(String[] args) {
		StartDead sd = new StartDead();
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 20) {
				sd.start();
				System.out.println(sd.isAlive());
			}
			if (i > 20 && !sd.isAlive()) {
				sd.start();//������IllegalThreadStateException�쳣
			}
		}
	}
}
