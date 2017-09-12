package com.silencetao.reflect;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * JVM类加载器
 * @author Silence
 * create time 2017年8月14日 上午9:16:46
 * @version 1.0.1
 */
public class ClassLoaderPropTest {

    public static void main(String[] args) throws IOException {
        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器：" + systemLoader);
        
        /*
         * 获取系统类加载器的加载路径，通常由CLASSPATH环境变量指定
         * 如果操作系统没有指定CLASSPATH环境变量，则默认以当前路径
         * 作为系统类加载的加载路径
         */
        Enumeration<URL> em = systemLoader.getResources("");
        while (em.hasMoreElements()) {
            System.out.println(em.nextElement());
        }
        
        ClassLoader extensionLoader = systemLoader.getParent();
        
        System.out.println("扩展类加载器：" + extensionLoader);
        System.out.println("扩展类加载器的加载路径：" + System.getProperty("java.ext.dirs"));
        System.out.println("扩展类加载的parent：" + extensionLoader.getParent());
    }
}
