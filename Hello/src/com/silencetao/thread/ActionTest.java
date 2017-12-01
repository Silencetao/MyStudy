package com.silencetao.thread;

/**
 * 模拟用户存钱取钱
 * @author Silence
 *
 */
public class ActionTest {

	public static void main(String[] args) {
		AccountPlus account = new AccountPlus("74832498", 0);
		new DrawAccount("取钱者", account, 800).start();
		new DepositThread("存钱者A", account, 800).start();
//		new DepositThread("存钱者B", account, 800).start();
//		new DepositThread("存钱者C", account, 800).start();
	}
}
