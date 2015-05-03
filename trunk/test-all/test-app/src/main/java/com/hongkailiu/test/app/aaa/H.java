package com.hongkailiu.test.app.aaa;

public class H {

    private int i;

    public H(int i) {
        super();
        this.setI(i);
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
        init();
    }

    private void init() {
        i = i + 0;
    }

}
