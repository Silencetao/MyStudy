package com.silencetao.collenction;

import java.util.TreeSet;

/**
 * TreeSet自然排序1
 * @author Silence
 * create time 2017年11月16日 下午2:27:52
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
 * 如果通过compareTo(Object o)方法比较返回0，TreeSet则会认为
 * 它们相等；否则就认为它们不相等，将插入到TreeSet集合中
 * @author Silence
 * create time 2017年11月16日 下午2:35:02
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
