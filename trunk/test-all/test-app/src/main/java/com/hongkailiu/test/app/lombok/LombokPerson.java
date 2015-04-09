package com.hongkailiu.test.app.lombok;

/**
 * Created by hongkailiu on 2015-04-08.
 */

import lombok.Data;
import lombok.extern.log4j.Log4j;

@Log4j
@Data public class LombokPerson {

    private String name;
    private long id;

    public void write2Log(String message){
        log.info(message);
    }
}
