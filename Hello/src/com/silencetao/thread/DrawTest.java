package com.silencetao.thread;

/**
 * È¡Ç®³ÌÐò
 * @author Silence
 *
 */
public class DrawTest {

	public static void main(String[] args) {
		Account acct = new Account("44239848324832", 1000);
		new DrawThread("¼×", acct, 800).start();
		new DrawThread("ÒÒ", acct, 800).start();
//		new DrawMoney("±û", acct, 800).start();
//		new DrawMoney("¶¡", acct, 800).start();
	}
}
