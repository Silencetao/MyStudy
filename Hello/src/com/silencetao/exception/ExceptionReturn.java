package com.silencetao.exception;

/**
 * �쳣������,��finally��Ҳ��returnʱ,���return����finally���ֵ
 * ����finally����return��ִ�е�,try��catch��ִ����returnʱ,
 * �������ϰ�return��ֵ���ظ������ĵ�����,
 * ���ǵ�ִ����finally֮��Ż��return��ֵ���ظ������ĵ�����,
 * ����finally��return�Ļ�,���try��catch��return��ֵ���ǵ�
 * ����return����finally��ֵ
 * @author Silence
 *
 */
public class ExceptionReturn {

	@SuppressWarnings("finally")
	public static int test() {
		try {
			return 1;
		} catch (Exception e) {
			return 2;
		} finally {
			return 3;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(test());
	}
}
