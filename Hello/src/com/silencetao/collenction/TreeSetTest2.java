package com.silencetao.collenction;

import java.util.TreeSet;

/**
 * TreeSet��Ȼ����1
 * @author Silence
 * create time 2017��11��16�� ����2:27:52
 * @version 1.0.1
 */
class Z implements Comparable {
    int age;
    
    public Z(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
    
    @Override
    public int compareTo(Object o) {
        return 1;
    }
    
}

/**
 * ���ͨ��compareTo(Object o)�����ȽϷ���0��TreeSet�����Ϊ
 * ������ȣ��������Ϊ���ǲ���ȣ������뵽TreeSet������
 * @author Silence
 * create time 2017��11��16�� ����2:35:02
 * @version 1.0.1
 */
public class TreeSetTest2 {

    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        Z z = new Z(23);
        set.add(z);
        System.out.println(set.add(z));
        System.out.println(set);
        ((Z)(set.first())).age = 24;
        System.out.println(((Z)(set.last())).age);
    }
}
