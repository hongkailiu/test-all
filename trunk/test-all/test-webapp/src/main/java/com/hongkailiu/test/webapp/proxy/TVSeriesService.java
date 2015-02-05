package com.hongkailiu.test.webapp.proxy;

import java.util.List;

import com.hongkailiu.test.webapp.response.json.TVSeriesJsonResult;

public interface TVSeriesService {

	public List<TVSeriesJsonResult> getAllTVSeries();
}
