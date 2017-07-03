package com.silencetao.enumtest;

/**
 * 枚举类,性别
 * @author Silence
 *
 */
public enum Gender {
	
	MALE, FEMALE;
	private String name;
	
	public void setName(String name) {
		switch (this) {
			case MALE :
				if (name.equals("男")) {
					this.name = name;
				} else {
					System.out.println("error");
					return ;
				}
				break;
			case FEMALE :
				if (name.equals("女")) {
					this.name = name;
				} else {
					System.out.println("error");
					return ;
				}
		}
	}
	
	public String getName() {
		return this.name;
	}
}
