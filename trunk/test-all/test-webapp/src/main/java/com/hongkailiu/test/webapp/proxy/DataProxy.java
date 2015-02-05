package com.hongkailiu.test.webapp.proxy;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.hongkailiu.test.webapp.response.json.TVSeriesJsonResult;

@Component
public class DataProxy {

	@Resource(name="tvSeriesServiceImpl")
	TVSeriesService tvSeriesService;
	
	public List<TVSeriesJsonResult> getAllTVSeries() {
		return tvSeriesService.getAllTVSeries();
	}
}
