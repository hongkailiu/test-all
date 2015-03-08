package com.hongkailiu.test.webapp.cxf.service.impl;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import com.hongkailiu.test.webapp.cxf.service.MathService;

@WebService(endpointInterface = "com.hongkailiu.test.webapp.cxf.service.MathService")
public class MathServiceImpl implements MathService {
	
	static Logger logger = Logger.getLogger(MathServiceImpl.class);

	
	@Override
	public boolean isOdd(@WebParam(name="number") Integer number) {
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
