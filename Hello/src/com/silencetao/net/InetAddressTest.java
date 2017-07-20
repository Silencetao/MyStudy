package com.silencetao.net;

import java.net.InetAddress;

/**
 * InetAddress类测试
 * @author Silence
 *
 */
public class InetAddressTest {

    public static void main(String[] args) throws Exception {
        //根据主机名来获取对应的InetAddress实例
        InetAddress ip = InetAddress.getByName("www.silencetao.com");
        //判断是否可达
        System.out.println("是否可达:" + ip.isReachable(2000));
        //获取该InetAddress实例的IP字符串
        System.out.println(ip.getHostAddress());
        //根据原始IP地址来获取对应的InetAddress实例
        InetAddress local = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
        //获取该InetAddress实例对应的权限定域名
        System.out.println(local.getCanonicalHostName());
    }
}
