package com.silencetao.collenction;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;

/**
 * EnumSet测试
 * @author Silence
 *
 */

enum Season {
	SPRING("春天"), SUMMER("夏天"), FALL("秋天"), WINTER("冬天");
	
    private String name;
    
    private Season(String name) {
        this.name = name;
    }
}

public class EnumSetTest {

	public static void main(String[] args) {
		EnumSet es1 = EnumSet.allOf(Season.class);//集合元素就是全部枚举值
		System.out.println(es1);
		EnumSet es2 = EnumSet.noneOf(Season.class);//创建一个空的集合
		System.out.println(es2);
		es2.add(Season.FALL);
		es2.add(Season.SUMMER);
		System.out.println(es2);
		EnumSet es3 = EnumSet.of(Season.SUMMER, Season.WINTER);//以指定的枚举值创建EnumSet集合
		System.out.println(es3);
		EnumSet es4 = EnumSet.range(Season.SPRING, Season.SUMMER);//创建一个包含从SPRING到SUMMER的集合
		System.out.println(es4);
		EnumSet es5 = EnumSet.complementOf(es4);//创建集合es4补集的集合
		System.out.println(es5);
		
		Collection c = new HashSet();
		c.clear();
		c.add(Season.FALL);
		c.add(Season.SPRING);
		EnumSet seasonSet = EnumSet.copyOf(c);
		System.out.println(seasonSet);
	}
}
