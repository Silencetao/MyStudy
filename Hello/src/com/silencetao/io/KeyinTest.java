package com.silencetao.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * ת��������
 * @author Silence
 *
 */
public class KeyinTest {

	public static void main(String[] args) {
		try (
				//��System.in����ת��ΪReader����
				InputStreamReader reader = new InputStreamReader(System.in);
				//����ͨ��Reader��װ��BufferedReader(������)
				BufferedReader br = new BufferedReader(reader);
			) {
			String line = null;
			//����ѭ���ķ�ʽ�����еĶ�ȡ
			while ((line = br.readLine()) != null) {
				if (line.equals("exit")) {
//					System.exit(1);
					break ;
				}
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			System.out.println(sc.next());
		}*/
	}
}
