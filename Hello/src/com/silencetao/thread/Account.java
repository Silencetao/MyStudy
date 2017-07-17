package com.silencetao.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 账户类
 * @author Silence
 *
 */
public class Account {
	//定义需要保证线程安全的方法
	private final ReentrantLock lock = new ReentrantLock();
	private String accountNo;
	private double balance;
	
	public Account() {
		
	}

	public Account(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public int hashCode() {
		return accountNo.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && obj.getClass() == Account.class) {
			Account target = (Account) obj;
			return target.getAccountNo().equals(accountNo);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", balance=" + balance + "]";
	}
	
	//提供一个线程安全的draw()方法来完成取钱操作
	public /*synchronized*/ void draw(double drawAmount) {
		//加锁
		lock.lock();
		try {
			//账户余额大于取钱数目
			if (balance >= drawAmount) {
				System.out.println(Thread.currentThread().getName() + "取钱成功!吐出钞票:" + drawAmount);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				balance -= drawAmount;
				System.out.println("\t余额为:" + balance);
			} else {
				System.out.println(Thread.currentThread().getName() + "余额不足!");
			}
		} finally {
			lock.unlock();
		}
	}
}
