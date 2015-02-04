package com.hongkailiu.test.app.cla;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassTest {

	public static void main(String[] args){
		System.out.println("ClassTest");
		System.out.println("getName: " + ClassTest.class.getName());
		try {
			Class<?> clazz = java.lang.Class.forName("java.lang.Integer");
			System.out.println("aaa: " + clazz);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Class<? extends Integer> iClazz = new Integer(3).getClass();
		System.out.println("bbb: " + iClazz);
		Class<?> superIClazz = iClazz.getSuperclass();
		System.out.println("ccc: " + superIClazz);
		ClassLoader classLoader = iClazz.getClassLoader();
		System.out.println("classLoader: " + classLoader);
		try {
			// ref: http://stackoverflow.com/questions/1438420/how-to-get-a-class-object-from-the-class-name-in-java
			Class<?> clazzA = java.lang.Class.forName("com.hongkailiu.test.app.cla.A");
			A a1 = (A) clazzA.newInstance();
			System.out.println("a1: " + a1);
			Constructor<?> contructor1 = clazzA.getConstructor(int.class);
			A a2 = (A) contructor1.newInstance(6);
			System.out.println("a2: " + a2);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
