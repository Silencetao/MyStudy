package com.silencetao.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * ∑∫–Õ≤‚ ‘
 * @author Silence
 *
 */

abstract class Shape {
	public abstract void draw(Canvas c);
}

class Circle extends Shape {

	@Override
	public void draw(Canvas c) {
		System.out.println(c + "Circle");
	}
}

class Rectangle extends Shape {

	@Override
	public void draw(Canvas c) {
		System.out.println(c + "Rectangle");
	}
}

class Canvas {
	
	public void drawAll(List<? extends Shape> shapes) {
		for (Shape s : shapes) {
			s.draw(this);
		}
	}
}

public class DrawTest {

	public static void main(String[] args) {
		List<Circle> circles = new ArrayList<>();
		circles.add(new Circle());
		Canvas c = new Canvas();
		c.drawAll(circles);
		Integer i = new Integer(2);
	}
}
