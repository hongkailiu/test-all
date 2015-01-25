package com.hongkailiu.test.app.string;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

public class TestString {

	static Logger logger = Logger.getLogger(TestString.class);

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
		test8();
		test9();
		test10();
		test11();
		test12();
	}

	private static void test12() {
		String str = null;
		System.out.println("recursion: " + StringUtil.reverseRecursion(str));
		System.out.println("loop: " + StringUtil.reverseLoop(str));
		System.out.println("api: " + StringUtil.reverseApi(str));
	}

	private static void test11() {
		double d = -27.2345;
		System.out.println(Math.ceil(d));
		System.out.println(Math.round(d));
		System.out.println(Math.abs(d));
		System.out.println(Math.floor(d));
		
		System.out.println(Integer.parseInt(2+3+""));
	}

	private static void test10() {
		System.out.println("10: " + new Date(Long.parseLong("1404835861000")));
		
	}

	private static void test9() {
		double fraction = Double.parseDouble("0.06407092807782051");
		//String actualResult = MessageFormat.format("{0,number,#.####}", fraction);
		//logger.debug("actualResult=" + actualResult ); 
		NumberFormat defaultFormat = NumberFormat.getPercentInstance();
		defaultFormat.setMinimumFractionDigits(2);
		logger.debug("Percent format: " + defaultFormat.format(fraction));
		
	}

	private static void test8() {
//		String aaa = Integer.toString((1 * 5) % 60);
//		logger.debug("aaa=" + (1*5)%60); 
		for (int i = 0; i < 288; i++) {
			String hour = Integer.toString((i * 5) / 60);
			//logger.debug("hour1=" + hour); 
			if (hour.length()==1) {
				hour = "0" + hour;
			}
			//logger.debug("hour2=" + hour); 
			String min5 = Integer.toString((i * 5) % 60);
			if (min5.length()==1) {
				min5 = "0" + min5;
			}
			logger.debug("hour=" + hour + "; min5=" + min5); 
		}
		
	}

	private static void test7() {
		String hm = "1398701100000";
		logger.info("hm:" + new Date(Long.parseLong(hm)));
	}

	private static void test6() {
		String line = "line";
		logger.info("Invalid log `" + line + "'\n");
		
	}

	private static void test5() {
		List<String> list = new ArrayList<String>();
		// list = null;
		for (String s : list) {
			logger.info("s: " + s);
		}

		String aaa = "rsys101_1396433463494wc688m";
		logger.info("index=" + aaa.indexOf("_"));

	}

	private static void test4() {
		logger.info("date: " + new Date());
		Date at = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String atStr = sdf.format(at);
		logger.info("atStr: " + atStr);

	}

	private static void test2() {
		String testStr = "<StaData><Device><DevMod>Lenovo_S898t+</DevMod><DevVer><OSVer>4.2.2</OSVer><CustVer>S898t+_S106_131213</CustVer></DevVer><MAC>98:ff:d0:fc:00:a6</MAC><OSName>android</OSName><AppInfo><VerName>V4.1.2.0000si</VerName><VerCode>401020000</VerCode><PkgName>com.lenovo.lsf.device</PkgName></AppInfo><ChannelInfo><VerName>V4.1.2.0000s</VerName><VerCode>401020000</VerCode><PkgName>com.lenovo.leos.pushdemo1</PkgName></ChannelInfo><SN>SCONGYV8DIIRCI5H</SN><DevIDs><DevID><DevStand>GSM</DevStand><IMEI>863563020001668</IMEI></DevID></DevIDs></Device><FBData><DisMessages>0123456789,0123456789,0123456789_d,0123456789</DisMessages><ClicMessages>0123456789,0123456789_c,</ClicMessages><AppInstalls /><AppDownloads /><EngUpgrades /></FBData></StaData>";
		logger.info("111: " + testStr.contains("<Device>"));
	}

	private static void test1() {
		try {
			int i = Integer.parseInt("6764767676767");
			logger.info("i: " + i);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	private static void test3() {
		String testStr = "asdf\rabc\nddd\rbsadfa";
		logger.info("333: " + testStr);
		logger.info("333: " + testStr.replaceAll("\r|\n|d", ""));
	}
}
