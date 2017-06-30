package com.silencetao.interfacetest;

/**
 * ���鸴��System.arraycopy()��������
 * @author Silence
 *
 */
public class TestArrayCopy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO �Զ����ɷ������

		String[] s1 = { "�й�", "ɽ��", "̫ԭ", "TYUT", "zyy", "���ô�", "��֪���ĸ���",
				"��֪���ĸ���", "��֪���ĸ�ѧУ", "yxf" };
		String[] s2 = new String[10];
		System.arraycopy(s1, 3, s2, 0, 6);
		s2[6] = "�����ɴ�����";
		s2[7] = "��������������";
		s2[8] = "����Montreal��ѧԺ";

		System.out.println("This is s1");
		for (int i = 0; i < s1.length; i++) {
			System.out.print(s1[i] + ",");
		}

		System.out.println("\nThis is s2");
		for (int i = 0; i < s2.length; i++) {
			System.out.print(s2[i] + ",");
		}

		String[][] s3 = { { "�й�", "ɽ��", "̫ԭ", "TYUT", "zyy" },
				{ "���ô�", "��֪���ĸ���", "��֪���ĸ���", "��֪���ĸ�ѧУ", "yxf" } };
		String[][] s4 = new String[s3.length][s3[0].length];
		System.arraycopy(s3, 0, s4, 0, s3.length);

		System.out.println("\nThis is original s3");
		for (int i = 0; i < s3.length; i++) {
			for (int j = 0; j < s3[0].length; j++) {
				System.out.print(s3[i][j] + ",");
			}
			System.out.println();
		}

		s4[1][1] = "�����ɴ�����";
		s4[1][2] = "��������������";
		s4[1][3] = "����Montreal��ѧԺ";

		System.out.println("\nThis is s3 after s4 has changed.");
		for (int i = 0; i < s3.length; i++) {
			for (int j = 0; j < s3[0].length; j++) {
				System.out.print(s3[i][j] + ",");
			}
			System.out.println();
		}

		System.out.println("\nThis is s4");
		for (int i = 0; i < s4.length; i++) {
			for (int j = 0; j < s4[0].length; j++) {
				System.out.print(s4[i][j] + ",");
			}
			System.out.println();
		}
	}

}
