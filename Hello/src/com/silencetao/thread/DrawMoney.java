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
		//ֱ�ӵ���account�����draw()������ִ��ȡǮ����
		//ͬ��������ͬ����������this��this�������draw()�����Ķ���
		//Ҳ����˵���߳̽���draw()����֮ǰ�������ȶ�account�������
		account.draw(drawAmount);
	}
}
