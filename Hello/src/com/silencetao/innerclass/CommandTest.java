package com.silencetao.innerclass;

/**
 * ����ģʽ,���������ڲ���ʵ������ӿ�
 * @author Silence
 *
 */
public class CommandTest {

	public static void main(String[] args) {
		ProcessArray pa = new ProcessArray();
		int[] target = {1, 2, 3, 4, 5, 6};
		pa.process(target, new Command() {
			
			@Override
			public void process(int[] target) {
				int sum = 0;
				for (int temp : target) {
					sum += temp;
					System.out.println(temp);
				}
				System.out.println(sum);
			}
		});
		
		Command cmd = new Command() {
			
			@Override
			public void process(int[] target) {
				int sum = 1;
				for (int temp : target) {
					sum *= temp;
				}
				System.out.println(sum);
			}
		};
		pa.process(target, cmd);
	}
}
