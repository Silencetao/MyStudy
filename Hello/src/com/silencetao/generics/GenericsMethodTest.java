package com.silencetao.generics;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ·ºÐÍ·½·¨
 * @author Silence
 *
 */
public class GenericsMethodTest {

	static <T> void fromAToC(T[] a, Collection<T> c) {
		for (T o : a) {
			c.add(o);
		}
	}
	
	public static void main(String[] args) {
		Object[] oa = new Object[100];
		Collection<Object> co = new ArrayList<>();
		//T--->Object
		fromAToC(oa, co);
		String[] sa = new String[100];
		Collection<String> cs = new ArrayList<String>();
		//T--->String
		fromAToC(sa, cs);
		//T--->Object
		fromAToC(sa, co);
		Integer[] ia = new Integer[100];
		Float[] fa = new Float[100];
		Double[] da = new Double[100];
		Number[] na = new Number[100];
		Collection<Number> cn = new ArrayList<Number>();
		//T---->Number
		fromAToC(ia, cn);
		//T---->Number
		fromAToC(fa, cn);
		//T---->Number
		fromAToC(da, cn);
		//T---->Number
		fromAToC(na, cn);
		//T---->Object
		fromAToC(na, co);
	}
}
