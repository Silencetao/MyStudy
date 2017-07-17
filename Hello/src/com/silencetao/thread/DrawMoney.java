package com.silencetao.thread;

public class DrawMoney extends Thread {
	private Account account;
	private double drawAmount;
	
	public DrawMoney(String name, Account account, double drawAmount) {
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}
	
	@Override
	public void run() {
		//直接调用account对象的draw()方法来执行取钱操作
		//同步方法的同步监视器是this，this代表调用draw()方法的对象
		//也就是说，线程进入draw()方法之前，必须先对account对象加锁
		account.draw(drawAmount);
	}
}
