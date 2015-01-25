package com.hongkailiu.test.app.enumeration;

/**
 * http://www.tutorialspoint.com/java/lang/enum_valueof.htm
 * 
 * http://stackoverflow.com/questions/2418729/whats-the-best-practice-to-look-up-java-enums
 * 
 * @author Liu
 *
 */
public enum Mobile {
	Samsung(400), Nokia(250), Motorola(325);

	int price;

	Mobile(int p) {
		price = p;
	}

	int showPrice() {
		return price;
	}
}
