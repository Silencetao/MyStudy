package com.silencetao.enumtest;

/**
 * 枚举类(性别)测试
 * @author Silence
 *
 */
public class GenderTest {

	public static void main(String[] args) {
		Gender gender = Gender.valueOf("FEMALE");
		gender.setName("女");
		System.out.println(gender + "," + gender.getName());
		gender.setName("男");
		System.out.println(gender + "," + gender.getName());
		
		GenderDesc g = GenderImpl.FEMALE;
		g.info();
	}
}
