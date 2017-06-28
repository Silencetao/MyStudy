package com.silencetao.single;

/**
 * ����ģʽ
 * @author Silence
 *
 */
class Singleton {
	//ʹ��һ�����������������������ʵ��
	private static Singleton instance;
	
	//�Թ�����ʹ��private����,���ع�����
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		//���instanceΪnull,���������������Singleton����
		//���instance��Ϊnull,������Ѵ�����Singleton����
		if (instance == null) {
			//����һ��Singleton����,��������instance������
			instance = new Singleton();
		}
		return instance;
	}
}

public class SingletonTest {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1 == s2);
		//���Ϊtrue,������������ͬһ������
		
		String a = "java";
		String b = "ja" + "va";
		System.out.println(a == b);
		
		Integer integer = new Integer(100);
		
		String str1 = new String("Hello");
		String str2 = new String("Hellw");
		System.out.println(str1 == str2);
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
	}
}
