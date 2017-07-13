package com.silencetao.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

/**
 * �ƻ�������
 * @author Silence
 *
 */
public class PushbackTest {

	public static void main(String[] args) {
		try (
				//����һ��PushbackReader����ָ���ƻػ������ĳ���Ϊ64
				PushbackReader pr = new PushbackReader(new FileReader("src\\com\\silencetao\\io\\PushbackTest.java"), 64)
			) {
			char[] buf = new char[32];
			//���Ա����ϴζ�ȡ���ַ�������
			String lastContent = "";
			int hasRead = 0;
			//ѭ����ȡ�ļ�����
			while ((hasRead = pr.read(buf)) > 0) {
				//����ȡ������ת��Ϊ�ַ���
				String content = new String(buf, 0, hasRead);
				int targetIndex = 0;
				//���ϴζ�ȡ���ַ����ͱ��ζ�ȡ���ַ���ƴ����
				//�鿴�Ƿ����Ŀ���ַ������������Ŀ���ַ���
				if ((targetIndex = (lastContent + content).indexOf("new PushbackReader")) > 0) {
					//���������ݺ��ϴ�����һ���ƻػ�����
					pr.unread((lastContent + content).toCharArray());
					//���¶���һ������ΪtargetIndex��char����
					if (targetIndex > 32) {
						buf = new char[targetIndex];
					}
					//�ٴζ�ȡָ�����ȵ����ݣ�����Ŀ���ַ���֮ǰ�����ݣ�
					pr.read(buf, 0, targetIndex);
					System.out.println("----->" + new String(buf, 0, targetIndex));
					System.exit(0);
				} else {
					System.out.println(lastContent);
					lastContent = content;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
