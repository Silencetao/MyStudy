package com.silencetao.thread;

/**
 * ģ���û���ǮȡǮ
 * @author Silence
 *
 */
public class ActionTest {

	public static void main(String[] args) {
		AccountPlus account = new AccountPlus("74832498", 0);
		new DrawAccount("ȡǮ��", account, 800).start();
		new DepositThread("��Ǯ��A", account, 800).start();
//		new DepositThread("��Ǯ��B", account, 800).start();
//		new DepositThread("��Ǯ��C", account, 800).start();
	}
}
