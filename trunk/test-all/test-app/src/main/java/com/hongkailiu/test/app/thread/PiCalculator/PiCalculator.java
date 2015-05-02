package com.hongkailiu.test.app.thread.PiCalculator;

import lombok.extern.log4j.Log4j;

import java.util.concurrent.Callable;

/**
 * Created by hongkailiu on 2015-04-30.
 */
@Log4j public class PiCalculator implements Callable<Double> {
    @Override public Double call() throws Exception {

        log.info("PiCalculator thread id: " + Thread.currentThread().getId());
        double currVal = 1.0;
        double nextVal = 0.0;
        double denominator = 1.0;

        int i=0;
        while (Math.abs(nextVal - currVal) > 0.000000001d) {
            currVal = nextVal;
            if(i % 2 == 1) {
                nextVal = currVal - (1 / denominator);
            } else {
                nextVal = currVal + (1 / denominator);
            }
            denominator += 2.0;
            i++;
        }

/*        for(int i = 0;
            Math.abs(nextVal - currVal) > 0.000000001d;
            denominator += 2.0, i++) {
            currVal = nextVal;
            if(i % 2 == 1) {
                nextVal = currVal - (1 / denominator);
            } else {
                nextVal = currVal + (1 / denominator);
            }
        }*/
        return Double.valueOf(currVal * 4);
    }
}
