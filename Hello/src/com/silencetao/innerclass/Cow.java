package com.silencetao.innerclass;

/**
 * 内部类
 * @author Silence
 *
 */
public class Cow {

	private double weight;
	
	public Cow() {
		
	}
	
	private Cow(double weight) {
		this.weight = weight;
	}
	
	public class Cowleg {
		private double length;
		private String color;
		
		public Cowleg() {
			
		}
		
		public Cowleg(double length, String color) {
			this.length = length;
			this.color = color;
		}
		
		
	}
	
	public void test() {
		Cowleg cowleg = new Cowleg(1.23, "黑白相间");
		System.out.println(cowleg.color + "," + cowleg.length + "," + weight);
	}
	
	public static void main(String[] args) {
		Cow cow = new Cow(12);
		cow.test();
	}
}

class Abc {
	Cow.Cowleg cow = new Cow().new Cowleg();
}
