package com.hongkailiu.test.webapp.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hongkailiu.test.webapp.proxy.DataProxy;
import com.hongkailiu.test.webapp.response.json.BaseJsonResult;
import com.hongkailiu.test.webapp.response.json.TVSeriesListJsonResult;


/**
 * 
 * ref: http://www.mkyong.com/spring-mvc/spring-3-mvc-and-json-example/
 * @author Hongkai Liu
 *
 */
@Controller
@RequestMapping("/tvseries")
public class TVSeriesController {
	
	private static final Logger logger = Logger.getLogger(TVSeriesController.class);
	
	@Autowired
	private DataProxy dataProxy;

	@RequestMapping(value = { "/all"}, method = RequestMethod.GET)
	public @ResponseBody BaseJsonResult getAllTVSeries() {
		logger.debug("==============tvseries: getAllTVSeries==================");
		TVSeriesListJsonResult json = new TVSeriesListJsonResult();
		json.setList(dataProxy.getAllTVSeries());
		return json;
	}

}