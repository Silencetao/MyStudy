package com.silencetao.reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * �����������
 * @author Silence
 * create time 2017��12��4�� ����11:45:29
 * @version 1.0.1
 */
public class ExtendedObjectPoolFactory {

    //����أ���������Ϊkey��value��ʵ�ʶ���
    private Map<String, Object> objectPool = new HashMap<>();
    private Properties config = new Properties();
    
    public void init(String fileName) {
        try (
                FileInputStream fis = new FileInputStream(fileName);
            ) {
            config.load(fis);
        } catch (IOException e) {
            System.out.println("��ȡ" + fileName + "ʧ��");
        }
    }
    
    private Object createObject(String clazzName) throws Exception {
        Class<?> clazz = Class.forName(clazzName);
        
        return clazz.newInstance();
    }
    
    public void initPool() throws Exception {
        for (String name : config.stringPropertyNames()) {
            if (!name.contains("%")) {
                objectPool.put(name, createObject(config.getProperty(name)));
            }
        }
    }
    
    public void initProperty() throws Exception {
        for (String name : config.stringPropertyNames()) {
            if (name.contains("%")) {
                String[] objAndProp = name.split("%");
                Object target = getObeject(objAndProp[0]);
                String mtdName = "set" + objAndProp[1].substring(0, 1).toUpperCase() +
                        objAndProp[1].substring(1);
                
                Class<?> targetClass = target.getClass();
                
                Method mtd = targetClass.getMethod(mtdName, String.class);
                mtd.invoke(target, config.getProperty(name));
            }
        }
    }
    
    public Object getObeject(String name) {
        return objectPool.get(name);
    }
    
    public static void main(String[] args) throws Exception {
        ExtendedObjectPoolFactory epf = new ExtendedObjectPoolFactory();
        epf.init("reflect/extObj.txt");
        epf.initPool();
        epf.initProperty();
        
        System.out.println(epf.getObeject("a"));
    }
}
