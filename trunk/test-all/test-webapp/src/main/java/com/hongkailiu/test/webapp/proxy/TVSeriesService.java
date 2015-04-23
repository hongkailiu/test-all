package com.hongkailiu.test.webapp.proxy;

import com.hongkailiu.test.webapp.response.json.TVSeriesJsonResult;

import java.util.List;

public interface TVSeriesService {

    public List<TVSeriesJsonResult> getAllTVSeries();
}
