package com.silencetao.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * ��webվ�㷢��GET����POST����
 * @author Silence
 *
 */
public class GetPostTest {

    /**
     * ��ָ��URL����GET��ʽ����
     * @param url ���������URL
     * @param param �����������ʽ����name1=value1&name2=value2����ʽ
     * @return URL ����Զ����Դ����Ӧ
     */
    public static String sendGet(String url, String param) {
        String result = "";
        String urlName = url + "?" + param;
        try {
            URL realUrl = new URL(urlName);
            //�򿪺�URL֮�������
            URLConnection conn = realUrl.openConnection();
            //����ͨ�õ���������
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            //����ʵ�ʵ�����
            conn.connect();
            //��ȡ���е���Ӧͷ�ֶ�
            Map<String, List<String>> map = conn.getHeaderFields();
            //�������е���Ӧͷ�ֶ�
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            try (
                    //����BufferedReader����������ȡURL����Ӧ
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                ) {
                String line;
                while ((line = in.readLine()) != null) {
                    result += "\n" + line;
                }
            }
        } catch (Exception e) {
            System.out.println("����GET�����쳣");
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * ��ָ��URL����POST��ʽ����
     * @param url ���������URL
     * @param param �����������ʽ����name1=value1&name2=value2����ʽ
     * @return URL ����Զ����Դ����Ӧ
     */
    public static String sendPost(String url, String param) {
        String result = "";
        try {
            URL realUrl = new URL(url);
            //�򿪺�URL֮�������
            URLConnection conn = realUrl.openConnection();
            //����ͨ�õ���������
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            //����POST�������������������
            conn.setDoOutput(true);
            conn.setDoInput(true);
            try (
                    //��ȡURLConnection�����Ӧ�������
                    PrintWriter out = new PrintWriter(conn.getOutputStream());
                ) {
                //��������
                out.print(param);
                //flush������Ļ���
                out.flush();
            }
            try (
                    //����BufferedReader����������ȡURL����Ӧ
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                ) {
                String line;
                while ((line = in.readLine()) != null) {
                    result += "\n" + line;
                }
            }
        } catch (Exception e) {
            System.out.println("����POST�����쳣");
            e.printStackTrace();
        }
        return result;
    }
    
    public static void main(String[] args) {
        //����GET����
        String getResult = GetPostTest.sendGet("https://www.silencetao.com/history/getHistoryHome", "");
        System.out.println(getResult);
        //����POST����
        String postResult = GetPostTest.sendPost("https://www.silencetao.com/user/userLogin", "username=1228714091@qq.com&password=3213213");
        System.out.println(postResult);
    }
}
