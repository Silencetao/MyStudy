package com.silencetao.enumtest;

/**
 * ö����(�Ա�)����
 * @author Silence
 *
 */
public class GenderTest {

	public static void main(String[] args) {
		Gender gender = Gender.valueOf("FEMALE");
		gender.setName("Ů");
		System.out.println(gender + "," + gender.getName());
		gender.setName("��");
		System.out.println(gender + "," + gender.getName());
		
		GenderDesc g = GenderImpl.FEMALE;
		g.info();
	}
}
