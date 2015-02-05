package com.hongkailiu.test.webapp.proxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hongkailiu.test.webapp.response.json.TVSeriesJsonResult;

@Repository("tvSeriesServiceImpl")
public class TVSeriesServiceImpl implements TVSeriesService {

	@Override
	public List<TVSeriesJsonResult> getAllTVSeries() {
		List<TVSeriesJsonResult> list = new ArrayList<TVSeriesJsonResult>();
		TVSeriesJsonResult tvSeries = new TVSeriesJsonResult();
		tvSeries.setName("game of thrones");
		list.add(tvSeries);
		tvSeries = new TVSeriesJsonResult();
		tvSeries.setName("friends");
		list.add(tvSeries);
		return list;
	}

}
