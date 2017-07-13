package com.silencetao.generics;

/**
 * ���Ͳ���
 * @author Silence
 *
 * @param <T>
 */
public class Apple<T> {
	//ʹ��T�����βζ���ʵ������
	private T info;
	
	public Apple() {
		
	}
	
	public Apple(T info) {
		this.info = info;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
	
	public static void main(String[] args) {
		Apple<String> a1 = new Apple<>("ƻ��");
		System.out.println(a1.getInfo());
		Apple<Double> a2 = new Apple<>(68.33D);
		System.out.println(a2.getInfo());
	}
}
