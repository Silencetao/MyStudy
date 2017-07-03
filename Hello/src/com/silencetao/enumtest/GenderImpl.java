package com.silencetao.enumtest;

/**
 * ö����ӿ�ʵ��
 * @author Silence
 *
 */
public enum GenderImpl implements GenderDesc {
	
	MALE("��") {
		@Override
		public void info() {
			System.out.println("MALE��������");
		}
	}, FEMALE("Ů") {
		@Override
		public void info() {
			System.out.println("FEMALE����Ů��");
		}
	};

	private final String name;
	
	private GenderImpl(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
