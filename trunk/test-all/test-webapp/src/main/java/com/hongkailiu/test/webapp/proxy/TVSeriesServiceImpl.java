package com.hongkailiu.test.webapp.proxy;

import com.hongkailiu.test.app.util.MathUtil;
import com.hongkailiu.test.webapp.response.json.TVSeriesJsonResult;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("tvSeriesServiceImpl") public class TVSeriesServiceImpl implements TVSeriesService {

    @Override public List<TVSeriesJsonResult> getAllTVSeries() {
        List<TVSeriesJsonResult> list = new ArrayList<TVSeriesJsonResult>();
        TVSeriesJsonResult tvSeries = new TVSeriesJsonResult();
        tvSeries.setId(0);
        tvSeries.setName("game of thrones");
        tvSeries.setSeasonOnAir(3);
        tvSeries.setEpisodeOnAir(12);
        tvSeries.setEpisodeWatched(MathUtil.random(6));
        tvSeries.setSeasonWatched(3);
        tvSeries.setImageUrl(
            "http://192.168.0.59:8080/test-webapp/i/got-" + MathUtil.random(2) + ".jpg");
        list.add(tvSeries);
        tvSeries = new TVSeriesJsonResult();
        tvSeries.setId(1);
        tvSeries.setName("friends");
        tvSeries.setSeasonOnAir(10);
        tvSeries.setEpisodeOnAir(20);
        tvSeries.setEpisodeWatched(MathUtil.random(12));
        tvSeries.setSeasonWatched(6);
        tvSeries.setImageUrl(
            "http://192.168.0.59:8080/test-webapp/i/friends-" + MathUtil.random(2) + ".jpg");
        list.add(tvSeries);
        return list;
    }

}
