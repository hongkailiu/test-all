package com.hongkailiu.test.app.junit;

import org.hamcrest.BaseMatcher;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;

/**
 * ref.
 * http://tutorials.jenkov.com/java-unit-testing/matchers.html
 *
 * Created by hongkailiu on 2015-04-12.
 */
public class MyMatcherTest {
    @Test
    public void testWithMatchers() {
        Assert.assertThat("this string", CoreMatchers.is("this string"));
        Assert.assertThat(123, CoreMatchers.is(123));
        Assert.assertThat(123, CoreMatchers.not(CoreMatchers.is(345)));
    }

    @Test
    public void testThat() {
        MyUnit myUnit = new MyUnit();
        Assert.assertThat(myUnit.getTheSameObject2(), matches("constant string"));

    }

    public static Matcher matches(final Object expected){

        return new BaseMatcher() {

            protected Object theExpected = expected;

            @Override
            public boolean matches(Object o) {
                return theExpected.equals(o);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText(theExpected.toString());
            }
        };
    }
}
