package com.silencetao.reflect;

import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

/**
 * 
 * @author Silence
 * create time 2017年11月23日 下午3:08:09
 * @version 1.0.1
 */
public class URLClassLoaderTest {

    private static Connection conn;
    
    public static Connection getConn(String url, String user, String password) throws Exception {
        if (conn == null) {
            //创建一个URL数组
            URL[] urls = {new URL("file:mysql-connector-java-5.1.35.jar")};
            
            //以默认的CLassLoader作为父ClassLoader，创建URLClassLoader
            URLClassLoader myClassLoader = new URLClassLoader(urls);
            
            //加载MySQL的JDBC驱动，并创建实例
            Driver driver = (Driver) myClassLoader.loadClass("com.mysql.jdbc.Driver").newInstance();
            
            //创建一个设置JDBC连接属性的Properties对象
            Properties pro = new Properties();
            pro.setProperty("user", user);
            pro.setProperty("password", password);
            
            //调用Driver对象的connect方法来获取数据库的连接
            conn = driver.connect(url, pro);
        }
        
        return conn;
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println(getConn("jdbc:mysql://localhost:3306/mysql", "root", "123456"));
    }
}
