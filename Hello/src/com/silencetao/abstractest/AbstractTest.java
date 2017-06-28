package com.silencetao.abstractest;

/**
 * ������
 * @author Silence
 *
 */

abstract class Shape {
	static {
		System.out.println("ִ��Shape�ľ�̬��ʼ���顭��");
	}
	
	{
		System.out.println("ִ��Shape�ĳ�ʼ���顭��");
	}
	
	private String color;
	
	//����һ�������ܳ��ĳ��󷽷�
	public abstract double calPerimeter();
	
	//����һ��������״�ĳ��󷽷�
	public abstract String getType();
	
	public Shape() {
		
	}
	
	public Shape(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
}

class Triangle extends Shape {
	
	private double a;
	private double b;
	private double c;
	
	public Triangle(String color, double a, double b, double c) {
		super(color);
		if (a >= b + c || b >= a + c || c >= a + b) {
			System.out.println("����������֮�ͱ�����ڵ�����");
		} else {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	@Override
	public double calPerimeter() {
		return a + b + c;
	}

	@Override
	public String getType() {
		return getColor() + "������";
	}
}

class Circle extends Shape {
	
	private double radius;
	
	public Circle(String color, double radius) {
		super(color);
		this.radius = radius;
	}

	@Override
	public double calPerimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
	public String getType() {
		return getColor() + "Բ��";
	}
}

public class AbstractTest {
	public static void main(String[] args) {
		Shape s1 = new Triangle("red", 3, 4, 5);
		Shape s2 = new Circle("blue", 5);
		System.out.println(s1.getType());
		System.out.println(s1.calPerimeter());
		System.out.println(s2.getType());
		System.out.println(s2.calPerimeter());
	}
}
