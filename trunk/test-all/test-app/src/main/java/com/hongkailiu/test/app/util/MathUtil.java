package com.hongkailiu.test.app.util;

import java.util.Random;

public class MathUtil {
	
	private final static Random RANDOM = new Random();

	public static int random(int n) {
		return RANDOM.nextInt(n);
	}
}
