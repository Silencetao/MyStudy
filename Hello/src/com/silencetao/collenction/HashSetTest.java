package com.silencetao.collenction;

import java.util.HashSet;
import java.util.Iterator;

/**
 * HashSet Test
 * @author Silence
 * create time 2017年11月16日 上午11:00:05
 * @version 1.0.1
 */
class Rc {
    int count;
    
    public Rc(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "R [count=" + count + "]";
    }

    @Override
    public int hashCode() {
        return this.count;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Rc other = (Rc) obj;
        if (count != other.count)
            return false;
        return true;
    }
    
    
}

public class HashSetTest {

    public static void main(String[] args) {
        HashSet hs = new HashSet();
        hs.add(new Rc(5));
        hs.add(new Rc(-3));
        hs.add(new Rc(9));
        hs.add(new Rc(-2));
        //打印HashSet集合，集合元素没有重复
        System.out.println(hs);
        //取出第一个元素
        Iterator it = hs.iterator();
        Rc first = (Rc)it.next();
        //为第一个元素的count实例变量赋值
        first.count = -3;
        //再次输出HashSet集合，集合元素有重复元素
        System.out.println(hs);
        //删除count为-3的R对象
        hs.remove(new Rc(-3));
        System.out.println(hs);
        System.out.println("是否包含-3的R对象:" + hs.contains(new Rc(-3)));
        System.out.println("是否包含-2的R对象:" + hs.contains(new Rc(-2)));
    }
}
