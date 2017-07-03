package com.silencetao.basic;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Random¿‡≤‚ ‘
 * @author Silence
 *
 */
public class RandomTest {

	public static void main(String[] args) {
		Random random = new Random();
		System.out.println(random.nextBoolean());
		byte[] buffer = new byte[16];
		random.nextBytes(buffer);
		System.out.println(Arrays.toString(buffer));
		System.out.println(random.nextFloat());
		System.out.println(random.nextDouble());
		System.out.println(random.nextGaussian());
		System.out.println(random.nextInt());
		System.out.println(random.nextInt(30));
		System.out.println(random.nextLong());
		
		/*
		 * Threadlocalraandom¿‡≤‚ ‘
		 */
		ThreadLocalRandom rand = ThreadLocalRandom.current();
		System.out.println(rand.nextInt(10, 20));
		System.out.println(rand.nextDouble(5, 6));
	}
}
