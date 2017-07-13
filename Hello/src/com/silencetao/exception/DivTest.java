package com.silencetao.exception;

/**
 * �쳣���������
 * @author Silence
 *
 */
public class DivTest {

	public static void main(String[] args) {
		try {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int c = a / b;
			System.out.println(c);
		} catch (IndexOutOfBoundsException e) {//����Խ��
			System.out.println("------" + e.getMessage());
			System.out.println("����Խ��");
		} catch (NumberFormatException e) {//�����ʽ�쳣
			System.out.println("------" + e.getMessage());
			System.out.println("�����ʽ�쳣");
		} catch (ArithmeticException e) {//�����쳣
			System.out.println("------" + e.getMessage());
			System.out.println("�����쳣");
		} catch (Exception e) {
			System.out.println("δ֪�쳣");
		}
	}
}
