package com.silencetao.reflect;

import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

/**
 * 
 * @author Silence
 * create time 2017��11��23�� ����3:08:09
 * @version 1.0.1
 */
public class URLClassLoaderTest {

    private static Connection conn;
    
    public static Connection getConn(String url, String user, String password) throws Exception {
        if (conn == null) {
            //����һ��URL����
            URL[] urls = {new URL("file:mysql-connector-java-5.1.35.jar")};
            
            //��Ĭ�ϵ�CLassLoader��Ϊ��ClassLoader������URLClassLoader
            URLClassLoader myClassLoader = new URLClassLoader(urls);
            
            //����MySQL��JDBC������������ʵ��
            Driver driver = (Driver) myClassLoader.loadClass("com.mysql.jdbc.Driver").newInstance();
            
            //����һ������JDBC�������Ե�Properties����
            Properties pro = new Properties();
            pro.setProperty("user", user);
            pro.setProperty("password", password);
            
            //����Driver�����connect��������ȡ���ݿ������
            conn = driver.connect(url, pro);
        }
        
        return conn;
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println(getConn("jdbc:mysql://localhost:3306/mysql", "root", "123456"));
    }
}
