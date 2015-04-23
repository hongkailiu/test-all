package com.hongkailiu.test.app.junit;

/**
 * Created by hongkailiu on 2015-04-12.
 */
public class MyUnitMock extends MyUnit {
    protected boolean callOneCalled = false;
    protected boolean callTwoCalled = false;

    public MyUnitMock(MyDependency dep) {
        super(dep);
    }

    @Override protected void callOne() {
        this.callOneCalled = true;
        super.callOne();
    }

    @Override protected void callTwo() {
        this.callTwoCalled = true;
        super.callTwo();
    }
}
