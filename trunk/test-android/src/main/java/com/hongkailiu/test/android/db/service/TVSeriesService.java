package com.hongkailiu.test.android.db.service;

import java.util.List;

import android.content.Context;

import com.hongkailiu.test.android.db.dao.TVSeriesDAO;
import com.hongkailiu.test.android.db.entity.TVSeries;

public class TVSeriesService {
	private static TVSeriesService mInstance;
	private static TVSeriesDAO tvSeriesDAO;

	public synchronized static TVSeriesService getInstance(Context context) {
		if (mInstance == null) {
			mInstance = new TVSeriesService(context);
		}

		return mInstance;
	}

	private TVSeriesService(Context context) {
		super();
		tvSeriesDAO = TVSeriesDAO.getInstance(context);
	}

	public long insert(TVSeries tvSeries) {
		return tvSeriesDAO.insert(tvSeries);
	}

	public List<TVSeries> getAllTVSeries() {
		return tvSeriesDAO.getAllTVSeries();
	}
	
	public boolean save(TVSeries tvSeries) {
		return tvSeriesDAO.save(tvSeries);
	}
}
