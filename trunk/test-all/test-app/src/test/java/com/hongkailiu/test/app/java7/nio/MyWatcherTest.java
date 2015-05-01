package com.hongkailiu.test.app.java7.nio;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by hongkailiu on 2015-04-30.
 */
public class MyWatcherTest {

    @Rule public TemporaryFolder folder = new TemporaryFolder();

    @Test(timeout=60*1000) public void test() throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Path path = FileSystems.getDefault().getPath(folder.getRoot().getAbsolutePath());
        MyWatcher watcher = new MyWatcher(path);
        System.out.println("date1: " + new Date());
        Future<Object> future = executorService.submit(watcher);
        Thread.sleep(3 * 1000);
        System.out.println("date2: " + new Date());
        folder.newFile("myfile.txt");
        Thread.sleep(13 * 1000);
        System.out.println("date3: " + new Date());
        watcher.setStopFlag(true);
        System.out.println("date4: " + new Date());
        //Object r = future.get();
        Object r = future.get(20, TimeUnit.SECONDS);
        System.out.println("date5: " + new Date());
        Assert.assertTrue(r==null);
        Assert.assertTrue(future.isDone());
    }

}
