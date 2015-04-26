package com.hongkailiu.test.app.java8.lambda.scope;

import org.junit.Test;

/**
 * Created by hongkailiu on 2015-04-25.
 */
public class LambdaScopeTest {

    @Test public void test() {
        LambdaScope st = new LambdaScope();
        LambdaScope.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}
