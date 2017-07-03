package com.silencetao.enumtest;

/**
 * 枚举类,指定初始值
 * @author Silence
 *
 */
public enum GenderOther {

	MALE("男"), FEMALE("女");
	private final String name;
	
	private GenderOther(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
