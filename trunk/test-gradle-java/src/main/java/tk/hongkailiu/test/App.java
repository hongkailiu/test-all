package tk.hongkailiu.test;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import tk.hongkailiu.test.entitiy.Person;

/**
 * Created by ehongka on 4/6/16.
 */
@Log4j2 public class App {
    @Getter private String aaa = "333";

    public static void main(String[] args) {
        log.info("aaa");
        Person p = new Person();
        p.setFirstname("bbb");
        log.info(p.getFirstname());
        System.out.println("adfa");
    }
}
