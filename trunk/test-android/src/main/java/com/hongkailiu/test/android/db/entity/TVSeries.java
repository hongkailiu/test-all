package com.hongkailiu.test.android.db.entity;

import com.hongkailiu.test.android.json.TVSeriesJsonResult;


public class TVSeries {

	private long id;
	private String name;
	private int seasonOnAir;
	private int episodeOnAir;
	private int seasonWatched;
	private int episodeWatched;
	private String imageMd5;
	private String imageUrl;
	private String imageFilename;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSeasonOnAir() {
		return seasonOnAir;
	}
	public void setSeasonOnAir(int seasonOnAir) {
		this.seasonOnAir = seasonOnAir;
	}
	public int getEpisodeOnAir() {
		return episodeOnAir;
	}
	public void setEpisodeOnAir(int episodeOnAir) {
		this.episodeOnAir = episodeOnAir;
	}
	public int getSeasonWatched() {
		return seasonWatched;
	}
	public void setSeasonWatched(int seasonWatched) {
		this.seasonWatched = seasonWatched;
	}
	public int getEpisodeWatched() {
		return episodeWatched;
	}
	public void setEpisodeWatched(int episodeWatched) {
		this.episodeWatched = episodeWatched;
	}
	public String getImageMd5() {
		return imageMd5;
	}
	public void setImageMd5(String imageMd5) {
		this.imageMd5 = imageMd5;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getImageFilename() {
		return imageFilename;
	}
	public void setImageFilename(String imageFilename) {
		this.imageFilename = imageFilename;
	}
	public TVSeries(TVSeriesJsonResult json) {
		super();
		if (json!=null) {
			this.id = json.getId();
			this.name = json.getName();
			this.episodeOnAir = json.getEpisodeOnAir();
			this.seasonOnAir = json.getSeasonOnAir();
			this.episodeWatched = json.getEpisodeWatched();
			this.seasonWatched = json.getSeasonWatched();
			this.imageMd5 = json.getImageMd5();
			this.imageUrl = json.getImageUrl();
		}
	}
	
	public TVSeries() {
		super();
	}

}
