package com.hongkailiu.test.webapp.proxy;

import com.hongkailiu.test.webapp.response.json.TVSeriesJsonResult;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component public class DataProxy {

    @Resource(name = "tvSeriesServiceImpl") TVSeriesService tvSeriesService;

    public List<TVSeriesJsonResult> getAllTVSeries() {
        return tvSeriesService.getAllTVSeries();
    }
}
