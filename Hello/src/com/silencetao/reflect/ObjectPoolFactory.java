package com.silencetao.reflect;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 对象池
 * @author Silence
 * create time 2017年12月4日 上午11:45:29
 * @version 1.0.1
 */
public class ObjectPoolFactory {

    //对象池，对象名作为key，value是实际对象
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
            System.out.println("读取" + fileName + "失败");
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
