package com.hongkailiu.test.webapp.response.json;

import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;


@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class TVSeriesListJsonResult extends BaseJsonResult {

	private List<TVSeriesJsonResult> list;

	public List<TVSeriesJsonResult> getList() {
		return list;
	}

	public void setList(List<TVSeriesJsonResult> list) {
		this.list = list;
	}

	
}
