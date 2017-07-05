package com.silencetao.collenction;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 通过梭哈游戏演示List集合
 * @author Silence
 *
 */
public class ShowHand {
	//定义该游戏对多支持的玩家数
	private final int PLAY_NUM = 5;
	//定义扑克牌的花色
	private String[] types = {"方块", "草花", "红心", "黑桃"};
	private String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
	//cards是一局游戏中剩下的扑克牌
	private List<String> cards = new LinkedList<String>();
	//定义所有的玩家
	private String[] players = new String[PLAY_NUM];
	//所有玩家手上的扑克牌
	private List<String>[] playersCards = new List[PLAY_NUM];
	
	/**
	 * 初始化扑克牌,并使用shuffle随机打乱
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
	 * 初始化玩家
	 * @param names
	 */
	public void initPlayer(String... names) {
		if (names.length > PLAY_NUM || names.length < 2) {
			System.out.println("玩家数量不符合游戏规则");
			return ;
		} else {
			for (int i = 0; i < names.length; i++) {
				players[i] = names[i];
			}
		}
	}
	
	/**
	 * 初始化玩家手上的牌,开始游戏时每个玩家手上的牌为空
	 * 程序使用一个长度为0的LinkedList来表示
	 */
	public void initPlayerCards() {
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null && !players[i].equals("")) {
				playersCards[i] = new LinkedList<String>();
			}
		}
	}
	
	/**
	 * 输出全部扑克牌
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
	 * 派扑克牌
	 * @param first 最先派给谁
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
	 * 输出玩家手上的牌
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
		sh.initPlayer("电脑玩家", "Silence");
		sh.initCards();
		sh.initPlayerCards();
		//sh.showAllCards();
		sh.deliverCard("Silence");
		sh.showPlayerCards();
		sh.deliverCard("电脑玩家");
		sh.showPlayerCards();
	}
}
