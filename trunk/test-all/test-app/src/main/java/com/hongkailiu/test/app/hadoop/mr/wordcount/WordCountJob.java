package com.hongkailiu.test.app.hadoop.mr.wordcount;

import java.io.File;
import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.log4j.Logger;

import com.hongkailiu.test.app.param.Param;
import com.hongkailiu.test.app.util.ConfigUtil;
import com.hongkailiu.test.app.util.Env;

public class WordCountJob {
	
	private static Logger logger = Logger.getLogger(WordCountJob.class);
	
	public final static String MODULE_NAME = "wordcount";

	public static void run() throws IOException{
		String input = "hdfs://192.168.0.160:9000/user/huser/in";
        String output = "hdfs://192.168.0.160:9000/user/huser/output/result";

        JobConf conf = new JobConf(WordCountJob.class);
        conf.setJobName("MyWordCount");
        conf.addResource("classpath:/hadoop/core-site.xml");
        conf.addResource("classpath:/hadoop/hdfs-site.xml");
        conf.addResource("classpath:/hadoop/mapred-site.xml");

        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);

        conf.setMapperClass(WordCountMapper.class);
        conf.setCombinerClass(WordCountReducer.class);
        conf.setReducerClass(WordCountReducer.class);

        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);

        FileInputFormat.setInputPaths(conf, new Path(input));
        FileOutputFormat.setOutputPath(conf, new Path(output));

        JobClient.runJob(conf);
	}

	public static void main(String[] args) {
		
		if (args.length != 1) {
			System.out
					.println("Usage : java com.hongkailiu.test.app.hadoop.mr.wordcount.WordCountJob -Dapp.home=<app.home> -Dlogfile.name=<logfile.name> " + MODULE_NAME);
			return;
		}
		
		
		

		String confDir = Param.getAppConfDir();
		File log4jConfigFile = new File(confDir, "log4j.xml");
		System.out.println("log4jConfigFile : " + log4jConfigFile.getAbsolutePath());


		if (!log4jConfigFile.exists()) {
			System.out
					.println("Starter.main : log4j config file does not exist !");
			return;
		}
		if (!log4jConfigFile.canRead()) {
			System.out
					.println("Starter.main : fail to load log4j config file !");
			return;
		}

		// 初始化log4j
		ConfigUtil.configLog4j(log4jConfigFile.getPath());
		logger.info("config log4j: done");
		

		// 初始化Spring的ApplicationContext.xml配置文件
		// logger.info("appContextPath = " + spring_path);
		File applicationContextFile = new File(confDir, MODULE_NAME
				+ Param.SPRING_SURFIX);
		logger.info("applicationContextFile : " + applicationContextFile.getAbsolutePath());
		if (!applicationContextFile.exists()) {
			logger.info("Kafka App.main : spring config file does not exist !");
			return;
		}
		if (!applicationContextFile.canRead()) {
			logger.info("Kafka App.main : fail to load spring config file !");
			return;
		}
		// applicationContextFile = null;

		// 初始化spring
		if (Env.isLinux()) {
			ConfigUtil.configSpring(Param.PATH_SEPARATOR + applicationContextFile.getPath());
		} else {
			ConfigUtil.configSpring(applicationContextFile.getPath());
		}
		logger.info("initialize spring ok!");
		
//		HitDataTransporter transporter = new HitDataTransporter();
//		try {
//			transporter.run();
//		} catch (IOException e) {
//			logger.error(e.getMessage());
//		}

		// 主程序循环
//		while (true) {
//			try {
//				Thread.sleep(60 * 1000);
//			} catch (InterruptedException e) {
//				logger.error("while ture: " + e.getMessage());
//			}
//		}
		
		try {
			run();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
	}
}