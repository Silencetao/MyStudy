package com.silencetao.enumtest;

/**
 * ö����,�Ա�
 * @author Silence
 *
 */
public enum Gender {
	
	MALE, FEMALE;
	private String name;
	
	public void setName(String name) {
		switch (this) {
			case MALE :
				if (name.equals("��")) {
					this.name = name;
				} else {
					System.out.println("error");
					return ;
				}
				break;
			case FEMALE :
				if (name.equals("Ů")) {
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
