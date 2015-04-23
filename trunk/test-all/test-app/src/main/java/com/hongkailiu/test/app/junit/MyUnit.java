package com.hongkailiu.test.app.junit;

/**
 * to learn
 * http://tutorials.jenkov.com/java-unit-testing/index.html
 * <p>
 * Created by hongkailiu on 2015-04-12.
 */
public class MyUnit {
    protected MyDependency dependency = null;
    private int getTheBooleanCount = 0;
    private int getTheObjectCount;
    private MyUnit theObject;
    private int getTheSameObjectCount;


    public MyUnit(MyDependency dep) {
        this.dependency = dep;
    }


    public MyUnit() {
    }

    public String concatenate(String one, String two) {
        return one + two;
    }

    public String[] getTheStringArray() {
        return new String[] {"one", "two", "three"};
    }

    public boolean getTheBoolean() {
        if (getTheBooleanCount++ == 0) {
            return true;
        } else {
            return false;
        }
    }

    public MyUnit getTheObject() {
        if (getTheObjectCount++ == 0) {
            theObject = new MyUnit();
            return null;
        } else {
            return theObject;
        }
    }

    public Object getTheSameObject() {

        if (getTheObjectCount++ < 3) {
            if (theObject == null)
                theObject = new MyUnit();
            return null;
        } else {
            return theObject;
        }


    }

    public Object getTheSameObject2() {
        return "constant string";
    }

    public void throwIllegalArgumentException() {
        throw new IllegalArgumentException("throw my IllegalArgumentException");
    }

    public void doTheThing(String param) {

        if ("one".equals(param)) {
            callOne();
        } else {
            callTwo();
        }
    }

    protected void callOne() {
        dependency.callOne();
    }

    protected void callTwo() {
        dependency.callTwo();
    }
}
