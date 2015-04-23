package com.hongkailiu.test.app.collection;

public class MyListElem {

    public int val;
    public MyListElem next;

    public MyListElem(int val, MyListElem next) {
        super();
        this.val = val;
        this.next = next;
    }

    public MyListElem(int val) {
        super();
        this.val = val;
    }

    public static MyListElem removeAll(MyListElem elem, int val) {
        if (elem == null) {
            return null;
        } else {
            if (elem.val == val) {
                return removeAll(elem.next, val);
            } else {
                elem.next = removeAll(elem.next, val);
                return elem;
            }
        }
    }

    @Override public String toString() {
        return val + " " + (this.next == null ? "" : this.next.toString());
    }

}
