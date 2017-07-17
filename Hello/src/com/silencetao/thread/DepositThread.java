package com.silencetao.thread;

/**
 * ´æÇ®Ïß³Ì
 * @author Silence
 *
 */
public class DepositThread extends Thread {
	private AccountPlus account;
	private double depositAmount;
	
	public DepositThread(String name, AccountPlus account, double depositAmount) {
		super(name);
		this.account = account;
		this.depositAmount = depositAmount;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			account.deposit(depositAmount);
		}
	}
}
