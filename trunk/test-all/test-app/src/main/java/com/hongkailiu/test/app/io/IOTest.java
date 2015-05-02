package com.hongkailiu.test.app.io;

import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.*;

/**
 * check IOUtil class in the util package
 *
 * @author Liu
 */
@Deprecated @Log4j public class IOTest {
    private IOTest(){

    }
    public static void main(String[] args) {
        log.info("IOTest.main");
        //String filename = "file\\test.dat";
        String filename = new File("file", "test.dat").getAbsolutePath();
        log.info("" + System.getProperty("user.dir"));
        try {
            log.info("read");
            read(filename);
            log.info("readCommonIO");
            readCommonIO(filename, "UTF-8");
        } catch (IOException e) {
            log.error(e);
        }

    }

    public static void read(InputStream is) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = br.readLine()) != null) {
                log.info(line);
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    public static void read(String filename) throws IOException {
        FileInputStream fis = new FileInputStream(filename);
        read(fis);
    }

    /**
     * ref: http://commons.apache.org/proper/commons-io/description.html
     *
     * @throws IOException
     */
    public static void readCommonIO(File file, String encoding) throws IOException {
        LineIterator it = FileUtils.lineIterator(file, encoding);
        try {
            while (it.hasNext()) {
                String line = it.nextLine();
                log.info("line: " + line);
            }
        } finally {
            LineIterator.closeQuietly(it);
        }
    }

    public static void readCommonIO(String filename, String encoding) throws IOException {
        File file = new File(filename);
        readCommonIO(file, encoding);
    }

    public static void write(String filename, String encoding, String content) throws IOException {
        write(new FileOutputStream(filename), encoding, content);

    }

    public static void write(OutputStream os, String encoding, String content) throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os, encoding)));
        pw.write(content);
        pw.close();
    }
}
