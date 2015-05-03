package com.hongkailiu.test.app.string;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Log4j public class StringTest {
    @Test public void test13() {
        String a = "a";
        System.out.println("a: " + a);
        changeA(a);
        System.out.println("a: " + a);
    }

   private void changeA(String a) {
        a = "b";
    }

    @Test public void test12() {
        String str = null;
        System.out.println("recursion: " + StringUtil.reverseRecursion(str));
        System.out.println("loop: " + StringUtil.reverseLoop(str));
        System.out.println("api: " + StringUtil.reverseApi(str));
    }

    @Test public void test11() {
        double d = -27.2345;
        System.out.println(Math.ceil(d));
        System.out.println(Math.round(d));
        System.out.println(Math.abs(d));
        System.out.println(Math.floor(d));

        System.out.println(Integer.parseInt(2 + 3 + ""));
    }

    @Test public void test10() {
        System.out.println("10: " + new Date(Long.parseLong("1404835861000")));

    }

    @Test public void test9() {
        double fraction = Double.parseDouble("0.06407092807782051");
        //String actualResult = MessageFormat.format("{0,number,#.####}", fraction);
        //logger.debug("actualResult=" + actualResult );
        NumberFormat defaultFormat = NumberFormat.getPercentInstance();
        defaultFormat.setMinimumFractionDigits(2);
        log.debug("Percent format: " + defaultFormat.format(fraction));

    }

    @Test public void test8() {
        //		String aaa = Integer.toString((1 * 5) % 60);
        //		logger.debug("aaa=" + (1*5)%60);
        for (int i = 0; i < 288; i++) {
            String hour = Integer.toString((i * 5) / 60);
            //logger.debug("hour1=" + hour);
            if (hour.length() == 1) {
                hour = "0" + hour;
            }
            //logger.debug("hour2=" + hour);
            String min5 = Integer.toString((i * 5) % 60);
            if (min5.length() == 1) {
                min5 = "0" + min5;
            }
            log.debug("hour=" + hour + "; min5=" + min5);
        }

    }

    @Test public void test7() {
        String hm = "1398701100000";
        log.info("hm:" + new Date(Long.parseLong(hm)));
    }

    @Test public void test6() {
        String line = "line";
        log.info("Invalid log `" + line + "'\n");

    }

    @Test public void test5() {
        List<String> list = new ArrayList<String>();
        // list = null;
        for (String s : list) {
            log.info("s: " + s);
        }

        String aaa = "rsys101_1396433463494wc688m";
        log.info("index=" + aaa.indexOf("_"));

    }

    @Test public void test4() {
        log.info("date: " + new Date());
        Date at = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String atStr = sdf.format(at);
        log.info("atStr: " + atStr);

    }

    @Test public void test2() {
        String testStr =
            "<StaData><Device><DevMod>Lenovo_S898t+</DevMod><DevVer><OSVer>4.2.2</OSVer><CustVer>S898t+_S106_131213</CustVer></DevVer><MAC>98:ff:d0:fc:00:a6</MAC><OSName>android</OSName><AppInfo><VerName>V4.1.2.0000si</VerName><VerCode>401020000</VerCode><PkgName>com.lenovo.lsf.device</PkgName></AppInfo><ChannelInfo><VerName>V4.1.2.0000s</VerName><VerCode>401020000</VerCode><PkgName>com.lenovo.leos.pushdemo1</PkgName></ChannelInfo><SN>SCONGYV8DIIRCI5H</SN><DevIDs><DevID><DevStand>GSM</DevStand><IMEI>863563020001668</IMEI></DevID></DevIDs></Device><FBData><DisMessages>0123456789,0123456789,0123456789_d,0123456789</DisMessages><ClicMessages>0123456789,0123456789_c,</ClicMessages><AppInstalls /><AppDownloads /><EngUpgrades /></FBData></StaData>";
        log.info("111: " + testStr.contains("<Device>"));
    }

    @Test public void test1() {
        try {
            int i = Integer.parseInt("6764767676767");
            log.info("i: " + i);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

    @Test public void test3() {
        String testStr = "asdf\rabc\nddd\rbsadfa";
        log.info("333: " + testStr);
        log.info("333: " + testStr.replaceAll("\r|\n|d", ""));
    }

}
