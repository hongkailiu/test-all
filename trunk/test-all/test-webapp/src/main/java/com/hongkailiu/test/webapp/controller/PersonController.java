package com.hongkailiu.test.webapp.controller;

import com.hongkailiu.test.webapp.response.json.BaseJsonResult;
import com.hongkailiu.test.webapp.response.json.PersonJsonResult;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * ref: http://www.mkyong.com/spring-mvc/spring-3-mvc-and-json-example/
 *
 * @author Hongkai Liu
 */
@Controller @RequestMapping("/person") public class PersonController {

    private static final Logger logger = Logger.getLogger(PersonController.class);

    @RequestMapping(value = "{id}", method = RequestMethod.GET) public @ResponseBody
    BaseJsonResult getPersonById(@PathVariable long id) {
        logger.debug("==============person: getPersonById==================");
        PersonJsonResult json = new PersonJsonResult();
        json.setId(id);
        json.setUsername("aaa");
        return json;
    }

}
