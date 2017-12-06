package com.silencetao.reflect;

import java.lang.reflect.Field;

/**
 * 
 * @author Silence
 * create time 2017年12月4日 下午2:48:33
 * @version 1.0.1
 */
class Person {
    private String name;
    private int age;
    
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}

public class FieldTest {

    public static void main(String[] args) throws Exception {
        Person p = new Person();
        Class<Person> personClazz = Person.class;
        
        Field nameField = personClazz.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(p, "Silence");
        
        Field ageField = personClazz.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(p, 22);
        
        System.out.println(p);
    }
}
