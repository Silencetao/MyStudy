package com.silencetao.string;

public class StringTest {
	public static void main(String[] args) {
		byte[] b = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
		char[] c = {'0', '1', '2', '3', '4', '5', '6', 'a'};
//		System.out.println(b[0]);
//		System.out.println(c[0] & 0xFF);
		String sb = new String(b);
		String sb_sub = new String(b, 0, 4);
		String sc = new String(c);
		String sc_sub = new String(c, 2, 4);
		String sb_copy = new String(sb);
//		System.out.println(sb);
//		System.out.println(sb_sub);
//		System.out.println(sb_copy);
//		System.out.println(sc);
//		System.out.println(sc_sub);
//		System.out.println(sb.compareTo(sc));
//		System.out.println(sb.compareTo(sb_sub));
//		System.out.println(sb.concat(sc));
//		System.out.println(sb.contentEquals(new StringBuffer("bcdefg")));
//		System.out.println(sc.charAt(1));
//		sb.getChars(1, 3, c, 0);//²»°üº¬½áÊøÎ»ÖÃ3
//		System.out.println(c);
//		System.out.println(sc.hashCode());
//		System.out.println(sb.hashCode());
//		Integer a = new Integer(100);
//		Integer d = new Integer(100);
//		System.out.println(a.hashCode());
//		System.out.println(d.hashCode());
//		String name1 = "³ÂÌÎ";
//		String name2 = "³ÂÌÎ";
//		System.out.println(name1.hashCode());
//		System.out.println(name2.hashCode());
//		System.out.println(name1.getClass());
//		System.out.println(name2.getClass().getName());
//		System.out.println(sb.replace('a', '2'));
//		System.out.println(sb.substring(2));
//		System.out.println(sb.substring(2, 4));
//		char[] sb_arr = sb.toCharArray();
//		System.out.println(sb_arr);
//		System.out.println(String.valueOf(c));
		String str = " a b c d e f g h i j k ";
//		System.out.println(str);
//		System.out.println(str.trim());
//		String[] strs = str.split(" ");
//		System.out.println(strs);
//		System.out.println(sb.toUpperCase());
//		String date = "2017-06-27";
//		String[] dates = date.split("-");
//		for(int i = 0; i < dates.length; i++) {
//			System.out.println(dates[i]);
//		}
		System.out.println(str);
		System.out.println(str.replace(" a ", ""));
		String time = "2jfdsla832rj93209ewfrjwlkef017\\06\\27";
		System.out.println(time.replaceAll("\\d", "*"));
	}
}
