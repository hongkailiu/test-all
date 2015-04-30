package com.hongkailiu.test.app.thread.PiCalculator;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by hongkailiu on 2015-04-30.
 */
public class PiCalculatorTest {

    @Before public void setUp() throws Exception {

    }

    @After public void tearDown() throws Exception {

    }

    @Test public void test() throws Exception {
        final ExecutorService executorService =
            Executors.newCachedThreadPool();
        final long startTime = System.currentTimeMillis();
        final Future<Double> future =
            executorService.submit(new PiCalculator());

        final double pi = future.get(10, TimeUnit.SECONDS);

        final long stopTime = System.currentTimeMillis();
        System.out.printf("Calculated Pi in %d milliseconds: %10.9f%n",
            stopTime - startTime,
            pi);

        executorService.shutdown();
    }

    @Test
    public void sameThread() {
        System.out.println("Main thread id: " + Thread.currentThread().getId());
        ListeningExecutorService listeningExecutorService = MoreExecutors.newDirectExecutorService();
        listeningExecutorService.submit(new PiCalculator());

    }
}
