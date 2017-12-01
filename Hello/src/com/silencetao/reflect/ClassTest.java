package com.silencetao.reflect;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 获取对应类的详细信息
 * @author Silence
 * create time 2017年11月23日 下午4:36:18
 * @version 1.0.1
 */
//定义可重复注解
@Repeatable(Annos.class)
@interface Anno{}
@Retention(value = RetentionPolicy.RUNTIME)
@interface Annos {
    Anno[] value();
}

//使用4个注解修饰该类
@SuppressWarnings(value = "unchecked")
@Deprecated
//使用重复注解修饰该类
@Anno
@Anno
public class ClassTest {

    /**
     * 私有构造器
     */
    private ClassTest() {}
    
    /**
     * 有参构造器
     * @param name
     */
    public ClassTest(String name) {
        System.out.println("执行有参数的构造器");
    }
    
    /**
     * 无参方法
     * @version 1.0.1
     */
    public void info() {
        System.out.println("执行无参的info方法");
    }
    
    /**
     * 带一个参数的方法
     * @version 1.0.1 
     * @param str
     */
    public void info(String str) {
        System.out.println("执行有一个参数的info方法，其参数是" + str);
    }
    
    /**
     * 定义一个测试用的内部类
     * @author Silence
     * create time 2017年11月23日 下午4:44:08
     * @version 1.0.1
     */
    class Inner {
        
    }
    
    public static void main(String[] args) throws Exception {
        //获取ClassTest对应的Class对象
        Class<ClassTest> clazz = ClassTest.class;
        
        //获取全部构造器
        Constructor[] ctors = clazz.getDeclaredConstructors();
        System.out.println("ClassTest的构造器如下：");
        for (Constructor ctor : ctors) {
            System.out.println(ctor);
        }
        
        //获取全部public构造器
        Constructor[] publicCtors = clazz.getConstructors();
        System.out.println("ClassTest的public构造器如下：");
        for (Constructor ctor : publicCtors) {
            System.out.println(ctor);
        }
        
        //获取全部public方法
        Method[] methods = clazz.getMethods();
        System.out.println("ClassTest的public方法如下：");
        for (Method method : methods) {
            System.out.println(method);
        }
        
        //获取指定的方法
        System.out.println("获取ClassTest里一个名字为info带参数的方法："
                + clazz.getMethod("info", String.class));
        
        //获取全部注解
        Annotation[] anns = clazz.getAnnotations();
        System.out.println("ClassTest的Annotation如下：");
        for (Annotation ann : anns) {
            System.out.println(ann);
        }
        
        System.out.println("@SuppressWarnings注解为："
                + clazz.getAnnotation(SuppressWarnings.class));
        
        System.out.println("@Anno注解为：" + clazz.getAnnotation(Anno.class));
        
        //获取全部内部类
        Class<?> [] inners = clazz.getDeclaredClasses();
        System.out.println("ClassTest的全部内部类如下：");
        for (Class cla : inners) {
            System.out.println(cla);
        }
        
        //使用Class.forName()方法加载ClassTest的Inner内部类
        Class inClazz = Class.forName("com.silencetao.reflect.ClassTest$Inner");
        //访问inClazz的外部类
        System.out.println("innerClass对应类的外部类为：" + inClazz.getDeclaringClass());
        System.out.println("ClassTest的包为：" + clazz.getPackage());
        System.out.println("ClassTest的父类为：" + clazz.getSuperclass());
        
        ClassTest classTest = new ClassTest();
        Class c = classTest.getClass();
        System.out.println("@SuppressWarnings注解为："
                + c.getAnnotation(SuppressWarnings.class));
    }
}
