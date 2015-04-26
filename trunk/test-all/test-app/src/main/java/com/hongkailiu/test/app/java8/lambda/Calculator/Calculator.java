package com.hongkailiu.test.app.java8.lambda.Calculator;

/**
 * Created by hongkailiu on 2015-04-25.
 */
public class Calculator {

    interface IntegerMath {
        int operation(int a, int b);
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }
}
