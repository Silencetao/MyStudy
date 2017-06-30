package com.silencetao.lambda;

import com.silencetao.innerclass.ProcessArray;

/**
 * 命令模式,利用Lambda表达式来实现命令接口
 * @author Silence
 *
 */
public class CommandTest {

	public static void main(String[] args) {
		ProcessArray pa = new ProcessArray();
		int[] array = {1, 2, 3, 4, 5, 6};
		pa.process(array, jujj -> {
			int sum = 0;
			for (int temp : array) {
				sum += temp;
			}
			System.out.println(sum);
		});
	}
}
