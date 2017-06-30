package com.silencetao.lambda;

/**
 * Lambda±í´ïÊ½²âÊÔ
 * @author Silence
 *
 */

interface Eatable {
	void taste();
}

interface Flyable {
	void fly(String weather);
}

interface Addable {
	int add(int a, int b);
}

public class LambdaQs {

	public void eat(Eatable e) {
		System.out.println(e);
		e.taste();
	}
	
	public void drive(Flyable f) {
		System.out.println(f);
		f.fly("Silence");
	}
	
	public void test(int a, int b, Addable add) {
		System.out.println(add.add(a, b));
	}
	
	public static void main(String[] args) {
		LambdaQs lq = new LambdaQs();
		lq.eat(() -> System.out.println("Eatable is calling"));
		lq.drive(weather -> {
			System.out.println(weather);
		});
		int num1 = 3, num2 = 5;
		lq.test(num1, num2, (a, b) -> a + b);
		Flyable flyable = weather -> {
			System.out.println("-------" + weather);
		};
		lq.drive(flyable);
	}
}
