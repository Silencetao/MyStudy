package com.silencetao.enumtest;

/**
 * ö����,ָ����ʼֵ
 * @author Silence
 *
 */
public enum GenderOther {

	MALE("��"), FEMALE("Ů");
	private final String name;
	
	private GenderOther(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
