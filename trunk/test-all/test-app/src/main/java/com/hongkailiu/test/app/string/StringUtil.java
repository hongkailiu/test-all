package com.hongkailiu.test.app.string;

public class StringUtil {

    public static String reverseRecursion(String str) {
        if (str == null || str.length() == 1) {
            return str;
        }
        return reverseRecursion(str.substring(1)) + str.charAt(0);
    }

    public static String reverseLoop(String str) {
        if (str == null || str.length() == 1) {
            return null;
        }
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length; i > 0; i--) {
            sb.append(chars[i - 1]);
        }
        return sb.toString();
    }

    public static String reverseApi(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }
}
