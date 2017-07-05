package com.silencetao.collenction;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * ͨ�������Ϸ��ʾList����
 * @author Silence
 *
 */
public class ShowHand {
	//�������Ϸ�Զ�֧�ֵ������
	private final int PLAY_NUM = 5;
	//�����˿��ƵĻ�ɫ
	private String[] types = {"����", "�ݻ�", "����", "����"};
	private String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
	//cards��һ����Ϸ��ʣ�µ��˿���
	private List<String> cards = new LinkedList<String>();
	//�������е����
	private String[] players = new String[PLAY_NUM];
	//����������ϵ��˿���
	private List<String>[] playersCards = new List[PLAY_NUM];
	
	/**
	 * ��ʼ���˿���,��ʹ��shuffle�������
	 */
	public void initCards() {
		for (int i = 0; i < types.length; i++) {
			for (int j = 0; j < values.length; j++) {
				cards.add(types[i] + values[j]);
			}
		}
		Collections.shuffle(cards);
	}
	
	/**
	 * ��ʼ�����
	 * @param names
	 */
	public void initPlayer(String... names) {
		if (names.length > PLAY_NUM || names.length < 2) {
			System.out.println("���������������Ϸ����");
			return ;
		} else {
			for (int i = 0; i < names.length; i++) {
				players[i] = names[i];
			}
		}
	}
	
	/**
	 * ��ʼ��������ϵ���,��ʼ��Ϸʱÿ��������ϵ���Ϊ��
	 * ����ʹ��һ������Ϊ0��LinkedList����ʾ
	 */
	public void initPlayerCards() {
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null && !players[i].equals("")) {
				playersCards[i] = new LinkedList<String>();
			}
		}
	}
	
	/**
	 * ���ȫ���˿���
	 */
	public void showAllCards() {
		for (String card : cards) {
			System.out.println(card);
		}
	}
	
	private int search(String first) {
		for (int i = 0; i < players.length; i++) {
			if (players[i].equals(first)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * ���˿���
	 * @param first �����ɸ�˭
	 */
	public void deliverCard(String first) {
		int firstPos = search(first);
		for (int i = firstPos; i < PLAY_NUM; i++) {
			if (players[i] != null) {
				playersCards[i].add(cards.get(0));
				cards.remove(0);
			}
		}
		for (int i = 0; i < firstPos; i++) {
			if (players[i] != null) {
				playersCards[i].add(cards.get(0));
				cards.remove(0);
			}
		}
	}
	
	/**
	 * ���������ϵ���
	 */
	public void showPlayerCards() {
		for (int i = 0; i < PLAY_NUM; i++) {
			if (players[i] != null) {
				System.out.printf(players[i] + ":");
				for (String card : playersCards[i]) {
					System.out.printf(card + "\t");
				}
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		ShowHand sh = new ShowHand();
		sh.initPlayer("�������", "Silence");
		sh.initCards();
		sh.initPlayerCards();
		//sh.showAllCards();
		sh.deliverCard("Silence");
		sh.showPlayerCards();
		sh.deliverCard("�������");
		sh.showPlayerCards();
	}
}
