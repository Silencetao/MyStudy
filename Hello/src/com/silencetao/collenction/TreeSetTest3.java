package com.silencetao.collenction;

import java.util.TreeSet;

/**
 * TreeSet自然排序2
 * @author Silence
 * create time 2017年11月16日 下午2:40:10
 * @version 1.0.1
 */
class Tc implements Comparable {
    int count;
    
    public Tc(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Tc [count=" + count + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + count;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tc other = (Tc) obj;
        if (count != other.count)
            return false;
        return true;
    }

    @Override
    public int compareTo(Object o) {
        Tc obj = (Tc) o;
        return count > obj.count ? 1 :
            count < obj.count ? -1 : 0;
    }
}

public class TreeSetTest3 {

    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        ts.add(new Tc(5));
        ts.add(new Tc(-3));
        ts.add(new Tc(9));
        ts.add(new Tc(-2));
        System.out.println(ts);
        Tc first = (Tc)ts.first();
        first.count = 20;
        Tc last = (Tc)ts.last();
        last.count = -2;
        System.out.println(ts);
        System.out.println(ts.remove(new Tc(-2)));
        System.out.println(ts);
        System.out.println(ts.remove(new Tc(5)));
        System.out.println(ts);
        System.out.println(ts.remove(new Tc(-2)));
        System.out.println(ts);
    }
}
