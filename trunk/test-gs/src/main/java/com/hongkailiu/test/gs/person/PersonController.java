package com.hongkailiu.test.gs.person;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	static Logger logger = Logger.getLogger(PersonController.class);
	
	private static final String template = "Person, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/person")
    public Person greeting(@RequestParam(value="name", defaultValue="World") String name) {
        
    	logger.debug("aaa==============");
    	return new Person(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
