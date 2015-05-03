package com.hongkailiu.test.app.cli;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hongkailiu on 2015-05-02.
 */
public class AppEnv {

    private AppEnv(){}

    /* public static String logFilename; */
    @Getter @Setter private static String module;
    @Getter @Setter private static String appHome;

}
