package com.hongkailiu.test.app.aaa;

import java.io.File;

public class E {

    public int a(String x, Integer y) {
        return 0;
    }

    public int a(Integer y, String x) {
        return 0;
    }

    protected int a(String x) {

        File file = new File("");
        file.delete();
        file.renameTo(file);
        return 0;
    }
}
