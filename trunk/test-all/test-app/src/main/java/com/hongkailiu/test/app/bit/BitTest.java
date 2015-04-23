package com.hongkailiu.test.app.bit;

public class BitTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        test01();
    }

    private static void test01() {
        byte b = -2;
        System.out.println("high: " + BitUtil.getHigh4bits(b));
        System.out.println("low: " + BitUtil.getLow4bits(b));
    }

}
