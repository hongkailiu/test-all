package com.hongkailiu.test.app.java8.lambda.Calculator;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by hongkailiu on 2015-04-25.
 */
public class CalculatorTest {

    @Test public void test() {
        Calculator myApp = new Calculator();
        Calculator.IntegerMath addition = (a, b) -> a + b;
        Calculator.IntegerMath subtraction = (a, b) -> a - b;
        int r1 = myApp.operateBinary(40, 2, addition);
        Assert.assertEquals(42, r1);
        System.out.println("40 + 2 = " + r1);

        int r2 = myApp.operateBinary(20, 10, subtraction);
        Assert.assertEquals(10, r2);
        System.out.println("20 - 10 = " + r2);
    }

}
