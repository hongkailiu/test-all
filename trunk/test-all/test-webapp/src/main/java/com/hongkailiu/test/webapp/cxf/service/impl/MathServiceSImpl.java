package com.hongkailiu.test.webapp.cxf.service.impl;

import com.hongkailiu.test.webapp.cxf.service.MathService;
import org.apache.log4j.Logger;

import javax.jws.WebService;

@WebService(endpointInterface = "com.hongkailiu.test.webapp.cxf.service.MathServiceS",
    portName = "MathServiceSPort",
    serviceName = "MathServiceS",
    targetNamespace = "http://hongkailiu.com/test-webapp/services") public class MathServiceSImpl
    implements MathService {

    static Logger logger = Logger.getLogger(MathServiceSImpl.class);

    @Override public boolean isOdd(Integer number) {
        logger.debug("isOdd");

        if (number == null) {
            return false;
        }
        if (number.intValue() % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }
}
