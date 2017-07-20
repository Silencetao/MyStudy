package com.silencetao.net;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 使用URLDecoder和URLEncoder
 * @author Silence
 *
 */
public class URLDecoderTest {

    public static void main(String[] args) throws Exception {
        //将application/x-www-form-urlencoded字符串
        //转换成普通字符串
        String word = URLDecoder.decode("%E9%99%88%E6%B6%9B", "utf-8");
        System.out.println(word);
        //将普通字符串转换成application/x-www-form-urlencoded字符串
        String urlStr = URLEncoder.encode("陈涛", "utf-8");
        System.out.println(urlStr);
    }
}
