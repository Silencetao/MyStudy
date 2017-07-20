package com.silencetao.net;

import java.net.InetAddress;

/**
 * InetAddress�����
 * @author Silence
 *
 */
public class InetAddressTest {

    public static void main(String[] args) throws Exception {
        //��������������ȡ��Ӧ��InetAddressʵ��
        InetAddress ip = InetAddress.getByName("www.silencetao.com");
        //�ж��Ƿ�ɴ�
        System.out.println("�Ƿ�ɴ�:" + ip.isReachable(2000));
        //��ȡ��InetAddressʵ����IP�ַ���
        System.out.println(ip.getHostAddress());
        //����ԭʼIP��ַ����ȡ��Ӧ��InetAddressʵ��
        InetAddress local = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
        //��ȡ��InetAddressʵ����Ӧ��Ȩ�޶�����
        System.out.println(local.getCanonicalHostName());
    }
}
