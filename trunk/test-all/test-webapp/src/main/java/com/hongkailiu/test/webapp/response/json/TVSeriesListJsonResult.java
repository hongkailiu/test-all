package com.hongkailiu.test.webapp.response.json;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.List;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL) public class TVSeriesListJsonResult
    extends BaseJsonResult {

    private List<TVSeriesJsonResult> list;

    public List<TVSeriesJsonResult> getList() {
        return list;
    }

    public void setList(List<TVSeriesJsonResult> list) {
        this.list = list;
    }


}
