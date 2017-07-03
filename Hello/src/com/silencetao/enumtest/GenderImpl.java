package com.silencetao.enumtest;

/**
 * 枚举类接口实现
 * @author Silence
 *
 */
public enum GenderImpl implements GenderDesc {
	
	MALE("男") {
		@Override
		public void info() {
			System.out.println("MALE代表男性");
		}
	}, FEMALE("女") {
		@Override
		public void info() {
			System.out.println("FEMALE代表女性");
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
