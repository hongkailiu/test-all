package com.hongkailiu.test.app.util;

public class Env {

    private int production;

    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().indexOf("windows") != -1;
    }

    public static boolean isLinux() {
        return System.getProperty("os.name").toLowerCase().indexOf("linux") != -1;
    }

    public int getProduction() {
        return production;
    }

    public void setProduction(int production) {
        this.production = production;
    }
}
