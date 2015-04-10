package com.hongkailiu.test.app.mockito;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by hongkailiu on 2015-04-08.
 */
public class MockitoPerson {

    @Getter @Setter
    private A a;

    @Getter
    private String name;

    public void onReceive(Object o){
        System.out.print("Per on receive: " + o);
        a.tell();
    }
}
