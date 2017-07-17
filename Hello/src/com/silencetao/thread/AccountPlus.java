package com.silencetao.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程通信账户类
 * @author Silence
 *
 */
public class AccountPlus {
	private final Lock lock = new ReentrantLock();
	private final Condition con = lock.newCondition();
	private String accountNo;
	private double balance;
	//标示账户中是否已有存款的标示
	private boolean flag = false;
	
	public AccountPlus() {
		
	}

	public AccountPlus(String accountNo, double balance) {
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

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountNo == null) ? 0 : accountNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountPlus other = (AccountPlus) obj;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AccountPlus [accountNo=" + accountNo + ", balance=" + balance
				+ ", flag=" + flag + "]";
	}
	
	public /*synchronized*/ void draw(double drawAmount) {
		lock.lock();
		try {
			if (!flag) {
//				wait();
				con.await();
			} else {
				System.out.println(Thread.currentThread().getName() + "取钱:" + drawAmount);
				balance -= drawAmount;
				System.out.println("账户余额为:" + balance);
				flag = false;
//				notifyAll();
				con.signalAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public /*synchronized*/ void deposit(double depositAmount) {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + "调用deposit()方法");
			if (flag) {
//				wait();
				con.await();
			} else {
				System.out.println(Thread.currentThread().getName() + "存钱:" + depositAmount);
				balance += depositAmount;
				System.out.println("账户余额为:" + balance);
				flag = true;
//				notifyAll();
				con.signalAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
