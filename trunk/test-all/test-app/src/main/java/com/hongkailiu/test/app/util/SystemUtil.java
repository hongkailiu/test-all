package com.hongkailiu.test.app.util;

public class SystemUtil {

    private SystemUtil(){super();}

    public static String getUserDir() {
        // return new java.io.File(".").getCanonicalPath();
        return System.getProperty("user.dir");
    }

    public static String getSystemProperty(String key){
        return System.getProperty(key);
    }
}
