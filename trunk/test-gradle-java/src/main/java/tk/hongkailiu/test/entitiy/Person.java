package tk.hongkailiu.test.entitiy;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * Created by ehongka on 4/6/16.
 */
@Log4j2 @Data public class Person {
    private String firstname;

    public void print(){
        log.debug("firstname: " + firstname);
    }
}
