package com.silencetao.thread;

/**
 * �̵߳��쳣������
 * @author Silence
 *
 */
class MyExHandler implements Thread.UncaughtExceptionHandler {

	//ʵ��uncaughtException()�������÷����������̵߳�δ�����쳣
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(t + "�̳߳������쳣:" + e);
	}
	
}

public class ExHandler {

	public static void main(String[] args) {
		//�������̵߳��쳣������
		Thread.currentThread().setUncaughtExceptionHandler(new MyExHandler());
		int a = 3 / 0;
		System.out.println("ending");
	}
}
