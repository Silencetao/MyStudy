package com.silencetao.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * ʵ��Callable�ӿڴ����߳���
 * @author Silence
 *
 */
public class ThirdThread {

	public static void main(String[] args) {
		//����Callable����
		//��ʹ��Lambda���ʽ����Callable<Integer>����
		//ʹ��FutureTask����װCallable����
		FutureTask<Integer> task = new FutureTask<Integer>((Callable<Integer>)() -> {
			int i = 0;
			for ( ; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + " " + i);
			}
			//call()���������з���ֵ
			return i;
		});
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 20) {
				//ʵ�ʻ�����Callable���󴴽��������̵߳�
				new Thread(task, "�з���ֵ���߳�").start();
			}
		}
		try {
			//��ȡ�̵߳ķ���ֵ
			System.out.println("���̷߳���ֵ:" + task.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
