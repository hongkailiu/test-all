package com.hongkailiu.test.app.util;

public class SystemUtil {

    public static String getUserDir() {
        // return new java.io.File(".").getCanonicalPath();
        return System.getProperty("user.dir");
    }
}
