package com.hongkailiu.test.app.param;

import java.io.File;

public class Param {
	public final static String SPRING_SURFIX = "-applicationContext.xml";
//	public final static String LOG4J_SURFIX = "-log4j.xml";
//
//	public final static String HYPHEN = "-";
//	public final static String DATA_FILE_EXT = ".data";
	public final static String PATH_SEPARATOR = "/";
//	public final static String LINE_SEPARATOR = "\n";
	
	private static String APP_HOME;
	private final static String CONF_DIR_NAME = "conf";

	public static String getAppConfDir() {
		return getAppHomeDir() + File.separator + Param.CONF_DIR_NAME;
	}

	public static String getAppHomeDir() {
		if (APP_HOME == null) {
			APP_HOME = System.getProperty("app.home");
		}
		if (APP_HOME == null) {
			throw new RuntimeException("app.home is null");
		}
		return APP_HOME;
	}
}
