package com.silencetao.thread;

public class InvokeRun extends Thread {
	private int i = 0;
	
	//��дrun()������run()�����ķ���������߳�ִ����
	@Override
	public void run() {
		for ( ; i < 100; i++) {
			//���߳���̳�Thread��ʱ��ֱ��ʹ��this���ɻ�õ�ǰ�߳�
			//Thread�����getName()���ص�ǰ�̵߳�����
			//��˿���ֱ�ӵ���getName()�������ص�ǰ�̵߳�����
			System.out.println(getName() + " " + i);
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			//����Thread��currentThread()������ȡ��ǰ�߳�
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 20) {
				//ֱ�ӵ����̶߳����run()����
				//ϵͳ����̶߳��󵱳���ͨ���󣬰�run()����������ͨ����
				//�����������д��벢�������������̣߳���������ִ������run()����
				new InvokeRun().run();
				new InvokeRun().run();
			}
		}
	}
}