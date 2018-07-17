package com.m1.news.domain;

import java.util.List;

public class Intro {
    private String id;
    private String title;
    private List<String> images;

    public Intro(String id, String title, List<String> images) {
        this.id = id;
        this.title = title;
        this.images = images;
    }

    public Intro() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
