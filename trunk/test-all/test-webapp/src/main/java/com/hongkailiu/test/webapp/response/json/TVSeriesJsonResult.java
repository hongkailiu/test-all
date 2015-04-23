package com.hongkailiu.test.webapp.response.json;

import org.codehaus.jackson.map.annotate.JsonSerialize;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL) public class TVSeriesJsonResult
    extends BaseJsonResult {

    private long id;
    private String name;
    private int seasonOnAir;
    private int episodeOnAir;
    private int seasonWatched;
    private int episodeWatched;
    private byte[] image;
    private String imageMd5;
    private String imageUrl;

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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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

}
