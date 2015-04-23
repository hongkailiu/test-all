package com.hongkailiu.test.app.aaa;

public class J extends H {

    private int i;

    public J(int i) {
        super(i);
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
        init();
    }

    private void init() {
        i = i + 1;
    }

}
