package com.hongkailiu.test.app;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 * 
 */
public class App {
	
	public final static String MODULE_WORD_COUNT = com.hongkailiu.test.app.hadoop.mr.wordcount.WordCountJob.MODULE_NAME;
	
	@SuppressWarnings("serial")
	public final static List<String> MODULE_LIST = new ArrayList<String>() {
		{
			add(MODULE_WORD_COUNT);
		}
	};
	
	public static void main(String[] args) {
		//System.out.println("Hello World!");
		if (args.length < 1) {
			System.out
					.println("Usage : java com.hongkailiu.test.app.App -Dapp.home=<app.home> -Dlogfile.name=<logfile.name> <module> ...");
			return;
		}

		String module = args[0];
		System.out.println("module : " + module);
		if (!MODULE_LIST.contains(args[0])) {
			System.out.println("unknown module");
			return;
		}

		String appHome = System.getProperty("app.home");
		System.out.println("appHome : " + appHome);

		if (MODULE_WORD_COUNT.equals(module.toLowerCase())) {
			com.hongkailiu.test.app.hadoop.mr.wordcount.WordCountJob.main(args);
		}
	}
}
