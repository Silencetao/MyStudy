package com.silencetao.basic;

import java.time.Year;
import java.util.Calendar;
import java.util.Date;

/**
 * Calendar类测试
 * @author Silence
 *
 */
public class CalendarTest {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();//创建一个Calendar对象
		Date date = calendar.getTime();//Calendar对象转换为Date对象
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date);//Date对象转换为Calendar对象
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH) + 1);
		System.out.println(calendar.get(Calendar.DATE));
		calendar.add(Calendar.YEAR, -1);
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.getTime());
		
		Calendar cal = Calendar.getInstance();
		cal.set(2003, 7, 31);
		cal.set(Calendar.MONTH, 8);
		cal.set(Calendar.DATE, 5);
		System.out.println(cal.getTime());
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1);
		System.out.println(cal.get(Calendar.DATE));
	}
}
