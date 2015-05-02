package com.hongkailiu.test.app.util;

import java.io.PrintStream;

/**
 * Created by hongkailiu on 2015-05-01.
 */
public class LogUtil {

    private static final String TAG = "===test===: ";
    public static void systemOut(String message){
        PrintStream ps = System.out;
        ps.println(TAG + message);
    }
}
