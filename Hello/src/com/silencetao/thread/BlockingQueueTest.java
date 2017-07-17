package com.silencetao.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * BlockingQueue�����
 * @author Silence
 *
 */

class Producer extends Thread {
	private BlockingQueue<String> bq;
	
	public Producer(BlockingQueue<String> bq) {
		this.bq = bq;
	}
	
	@Override
	public void run() {
		String[] strArr = new String[] {
			"Java", "Structs", "Spring"	
		};
		for (int i = 0; i < 999999999; i++) {
			System.out.println(getName() + "������׼����������Ԫ��");
			try {
				Thread.sleep(200);
				bq.put(strArr[i % 3]);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(getName() + "�������:" + bq);
		}
	}
}

class Consumer extends Thread {
	private BlockingQueue<String> bq;
	
	public Consumer(BlockingQueue<String> bq) {
		this.bq = bq;
	}
	
	@Override
	public void run() {
		while (true) {
			System.out.println(getName() + "������׼�����Ѽ���Ԫ��");
			try {
				Thread.sleep(200);
				bq.take();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(getName() + "�������:" + bq);
		}
	}
}

public class BlockingQueueTest {

	public static void main(String[] args) throws Exception {
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(1);
		//����3���������߳�
		new Producer(bq).start();
		new Producer(bq).start();
		new Producer(bq).start();
		//����һ���������߳�
		new Consumer(bq).start();
	}
}
