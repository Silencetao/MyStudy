package com.silencetao.thread;

/**
 * ģ��ȡǮ���߳�
 * @author Silence
 *
 */
public class DrawThread extends Thread {
	//ģ���û��˻�
	private Account account;
	//��ǰȡǮ�߳���ϣ��Ҫȡ��Ǯ
	private double drawAmount;
	
	public DrawThread(String name, Account account, double drawAmount) {
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}
	
	//������߳��޸�ͬһ����������ʱ�����漰���ݰ�ȫ����
	@Override
	public void run() {
		System.out.println("��ǰ�û�:" + getName() + "-->�˻����Ϊ:" + account.getBalance());
		//ʹ��account��Ϊͬ�����������κ��߳̽�������ͬ�������֮ǰ
		//�����Ȼ�ö�account�˻��������������߳��޷��������Ҳ���޷��޸���
		//�����������ϣ�������->�޸�->�ͷ��������߼�
		synchronized (account) {
			//�˻�������ȡǮ��Ŀ
			if (account.getBalance() >= drawAmount) {
				System.out.println(getName() + "ȡǮ�ɹ�" + drawAmount);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				account.setBalance(account.getBalance() - drawAmount);
				System.out.println("��ǰ�û�:" + getName() + "-->�˻����Ϊ:" + account.getBalance());
			} else {
				System.out.println(getName() + "����");
			}
		}
		//ͬ���������������߳��ͷ�ͬ����
	}
}
