package com.silencetao.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * �˻���
 * @author Silence
 *
 */
public class Account {
	//������Ҫ��֤�̰߳�ȫ�ķ���
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
	
	//�ṩһ���̰߳�ȫ��draw()���������ȡǮ����
	public /*synchronized*/ void draw(double drawAmount) {
		//����
		lock.lock();
		try {
			//�˻�������ȡǮ��Ŀ
			if (balance >= drawAmount) {
				System.out.println(Thread.currentThread().getName() + "ȡǮ�ɹ�!�³���Ʊ:" + drawAmount);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				balance -= drawAmount;
				System.out.println("\t���Ϊ:" + balance);
			} else {
				System.out.println(Thread.currentThread().getName() + "����!");
			}
		} finally {
			lock.unlock();
		}
	}
}
