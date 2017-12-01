package com.silencetao.reflect;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * ��ȡ��Ӧ�����ϸ��Ϣ
 * @author Silence
 * create time 2017��11��23�� ����4:36:18
 * @version 1.0.1
 */
//������ظ�ע��
@Repeatable(Annos.class)
@interface Anno{}
@Retention(value = RetentionPolicy.RUNTIME)
@interface Annos {
    Anno[] value();
}

//ʹ��4��ע�����θ���
@SuppressWarnings(value = "unchecked")
@Deprecated
//ʹ���ظ�ע�����θ���
@Anno
@Anno
public class ClassTest {

    /**
     * ˽�й�����
     */
    private ClassTest() {}
    
    /**
     * �вι�����
     * @param name
     */
    public ClassTest(String name) {
        System.out.println("ִ���в����Ĺ�����");
    }
    
    /**
     * �޲η���
     * @version 1.0.1
     */
    public void info() {
        System.out.println("ִ���޲ε�info����");
    }
    
    /**
     * ��һ�������ķ���
     * @version 1.0.1 
     * @param str
     */
    public void info(String str) {
        System.out.println("ִ����һ��������info�������������" + str);
    }
    
    /**
     * ����һ�������õ��ڲ���
     * @author Silence
     * create time 2017��11��23�� ����4:44:08
     * @version 1.0.1
     */
    class Inner {
        
    }
    
    public static void main(String[] args) throws Exception {
        //��ȡClassTest��Ӧ��Class����
        Class<ClassTest> clazz = ClassTest.class;
        
        //��ȡȫ��������
        Constructor[] ctors = clazz.getDeclaredConstructors();
        System.out.println("ClassTest�Ĺ��������£�");
        for (Constructor ctor : ctors) {
            System.out.println(ctor);
        }
        
        //��ȡȫ��public������
        Constructor[] publicCtors = clazz.getConstructors();
        System.out.println("ClassTest��public���������£�");
        for (Constructor ctor : publicCtors) {
            System.out.println(ctor);
        }
        
        //��ȡȫ��public����
        Method[] methods = clazz.getMethods();
        System.out.println("ClassTest��public�������£�");
        for (Method method : methods) {
            System.out.println(method);
        }
        
        //��ȡָ���ķ���
        System.out.println("��ȡClassTest��һ������Ϊinfo�������ķ�����"
                + clazz.getMethod("info", String.class));
        
        //��ȡȫ��ע��
        Annotation[] anns = clazz.getAnnotations();
        System.out.println("ClassTest��Annotation���£�");
        for (Annotation ann : anns) {
            System.out.println(ann);
        }
        
        System.out.println("@SuppressWarningsע��Ϊ��"
                + clazz.getAnnotation(SuppressWarnings.class));
        
        System.out.println("@Annoע��Ϊ��" + clazz.getAnnotation(Anno.class));
        
        //��ȡȫ���ڲ���
        Class<?> [] inners = clazz.getDeclaredClasses();
        System.out.println("ClassTest��ȫ���ڲ������£�");
        for (Class cla : inners) {
            System.out.println(cla);
        }
        
        //ʹ��Class.forName()��������ClassTest��Inner�ڲ���
        Class inClazz = Class.forName("com.silencetao.reflect.ClassTest$Inner");
        //����inClazz���ⲿ��
        System.out.println("innerClass��Ӧ����ⲿ��Ϊ��" + inClazz.getDeclaringClass());
        System.out.println("ClassTest�İ�Ϊ��" + clazz.getPackage());
        System.out.println("ClassTest�ĸ���Ϊ��" + clazz.getSuperclass());
        
        ClassTest classTest = new ClassTest();
        Class c = classTest.getClass();
        System.out.println("@SuppressWarningsע��Ϊ��"
                + c.getAnnotation(SuppressWarnings.class));
    }
}
