package com.silencetao.net;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * ʹ��URLDecoder��URLEncoder
 * @author Silence
 *
 */
public class URLDecoderTest {

    public static void main(String[] args) throws Exception {
        //��application/x-www-form-urlencoded�ַ���
        //ת������ͨ�ַ���
        String word = URLDecoder.decode("%E9%99%88%E6%B6%9B", "utf-8");
        System.out.println(word);
        //����ͨ�ַ���ת����application/x-www-form-urlencoded�ַ���
        String urlStr = URLEncoder.encode("����", "utf-8");
        System.out.println(urlStr);
    }
}
