package com.hongkailiu.test.app.aaa;

import lombok.extern.log4j.Log4j;

@Log4j public class D {

    //@SuppressWarnings("unused")
    private int b;

    public void y() {
        InnerD iD = new InnerD();
        iD.a = 3;
        log.info("iD.a" + iD.a);
    }

    public class InnerD {
        //@SuppressWarnings("unused")
        private int a;

        public int x() {
            D d = new D();
            d.b = 3;
            log.info("d.b" + d.b);
            return 0;
        }
    }
}
