package com.silencetao.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 设定通配符下限
 * @author Silence
 *
 */
public class IntergeCopy {

	public static <T> T copy(Collection<? super T> dest, Collection<T> src) {
		T last = null;
		for (T ele : src) {
			dest.add(ele);
			last = ele;
		}
		return last;
	}
	
	public static void main(String[] args) {
		List<Number> ln = new ArrayList<Number>();
		List<Integer> li = new ArrayList<Integer>();
		Integer last = copy(ln, li);
		System.out.println(last);
	}
}
