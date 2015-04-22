package com.hongkailiu.test.app.cucumber.simple;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by ehongka on 4/14/15.
 */
public class Book {

    @Setter
    @Getter
    private String title;
    @Setter
    @Getter
    private String author;
    @Setter
    @Getter
    private Date published;

    public Book(String title, String author, Date published) {
        this.title = title;
        this.author = author;
        this.published = published;
    }


    // constructors, getter, setter ommitted
}
