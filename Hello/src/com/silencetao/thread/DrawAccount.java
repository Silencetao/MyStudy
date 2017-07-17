package com.silencetao.thread;

/**
 * È¡Ç®Ïß³Ì
 * @author Silence
 *
 */
public class DrawAccount extends Thread {
	private AccountPlus account;
	private double drawAmount;
	
	public DrawAccount(String name, AccountPlus account, double drawAmount) {
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			account.draw(drawAmount);
		}
	}
}
