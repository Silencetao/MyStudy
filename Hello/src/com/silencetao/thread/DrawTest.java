package com.silencetao.thread;

/**
 * ȡǮ����
 * @author Silence
 *
 */
public class DrawTest {

	public static void main(String[] args) {
		Account acct = new Account("44239848324832", 1000);
		new DrawThread("��", acct, 800).start();
		new DrawThread("��", acct, 800).start();
//		new DrawMoney("��", acct, 800).start();
//		new DrawMoney("��", acct, 800).start();
	}
}
