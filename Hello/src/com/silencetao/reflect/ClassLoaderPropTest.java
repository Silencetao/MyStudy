package com.silencetao.reflect;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * JVM�������
 * @author Silence
 * create time 2017��8��14�� ����9:16:46
 * @version 1.0.1
 */
public class ClassLoaderPropTest {

    public static void main(String[] args) throws IOException {
        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
        System.out.println("ϵͳ���������" + systemLoader);
        
        /*
         * ��ȡϵͳ��������ļ���·����ͨ����CLASSPATH��������ָ��
         * �������ϵͳû��ָ��CLASSPATH������������Ĭ���Ե�ǰ·��
         * ��Ϊϵͳ����صļ���·��
         */
        Enumeration<URL> em = systemLoader.getResources("");
        while (em.hasMoreElements()) {
            System.out.println(em.nextElement());
        }
        
        ClassLoader extensionLoader = systemLoader.getParent();
        
        System.out.println("��չ���������" + extensionLoader);
        System.out.println("��չ��������ļ���·����" + System.getProperty("java.ext.dirs"));
        System.out.println("��չ����ص�parent��" + extensionLoader.getParent());
    }
}
