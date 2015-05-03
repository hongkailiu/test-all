package com.hongkailiu.test.app.aaa;

import lombok.extern.log4j.Log4j;

import java.io.File;

@Log4j public class E {

    public int a(String x, Integer y) {
        log.info("x: " + x);
        log.info("y: " + y);
        return 0;
    }

    public int a(Integer y, String x) {
        log.info("x: " + x);
        log.info("y: " + y);
        return 0;
    }

    protected int a(String x) {
        log.info("x: " + x);
        File file = new File("");
        file.delete();
        file.renameTo(file);
        return 0;
    }
}
