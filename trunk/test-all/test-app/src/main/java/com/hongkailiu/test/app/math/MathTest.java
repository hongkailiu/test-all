package com.hongkailiu.test.app.math;

public class MathTest {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        swap1(a, b);
        swap2(a, b);
        swap3(a, b);
    }

    private static void swap1(int a, int b) {
        System.out.println("a=" + a + ", b=" + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a=" + a + ", b=" + b);
    }

    private static void swap2(int a, int b) {
        System.out.println("a=" + a + ", b=" + b);
        int c = a;
        a = b;
        b = c;
        System.out.println("a=" + a + ", b=" + b);
    }

    private static void swap3(int a, int b) {
        System.out.println("a=" + a + ", b=" + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a=" + a + ", b=" + b);
    }
}
