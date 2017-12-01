package com.silencetao.collenction;

import java.util.HashSet;
import java.util.Iterator;

/**
 * HashSet Test
 * @author Silence
 * create time 2017��11��16�� ����11:00:05
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
        //��ӡHashSet���ϣ�����Ԫ��û���ظ�
        System.out.println(hs);
        //ȡ����һ��Ԫ��
        Iterator it = hs.iterator();
        Rc first = (Rc)it.next();
        //Ϊ��һ��Ԫ�ص�countʵ��������ֵ
        first.count = -3;
        //�ٴ����HashSet���ϣ�����Ԫ�����ظ�Ԫ��
        System.out.println(hs);
        //ɾ��countΪ-3��R����
        hs.remove(new Rc(-3));
        System.out.println(hs);
        System.out.println("�Ƿ����-3��R����:" + hs.contains(new Rc(-3)));
        System.out.println("�Ƿ����-2��R����:" + hs.contains(new Rc(-2)));
    }
}
