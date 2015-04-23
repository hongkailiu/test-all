package com.hongkailiu.test.app.bit;

public class BitUtil {

    public static byte getLow4bits(byte b) {
        return (byte) (b & 0x0f);
    }

    public static byte getHigh4bits(byte b) {
        return (byte) (b & 0xf0);
    }
}
