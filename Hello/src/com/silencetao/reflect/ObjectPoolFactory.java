package com.silencetao.reflect;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * �����
 * @author Silence
 * create time 2017��12��4�� ����11:45:29
 * @version 1.0.1
 */
public class ObjectPoolFactory {

    //����أ���������Ϊkey��value��ʵ�ʶ���
    private Map<String, Object> objectPool = new HashMap<>();
    
    private Object createObject(String clazzName) throws Exception {
        Class<?> clazz = Class.forName(clazzName);
        
        return clazz.newInstance();
    }
    
    public void initPool(String fileName) throws Exception {
        try (
                FileInputStream fis = new FileInputStream(fileName);
            ) {
            Properties properties = new Properties();
            properties.load(fis);
            
            for (String name : properties.stringPropertyNames()) {
                objectPool.put(name, createObject(properties.getProperty(name)));
            }
        } catch (IOException e) {
            System.out.println("��ȡ" + fileName + "ʧ��");
        }
    }
    
    public Object getObeject(String name) {
        return objectPool.get(name);
    }
    
    public static void main(String[] args) throws Exception {
        ObjectPoolFactory pf = new ObjectPoolFactory();
        pf.initPool("reflect/obj.txt");
        
        System.out.println(pf.getObeject("a"));
        System.out.println(pf.getObeject("b"));
    }
}
