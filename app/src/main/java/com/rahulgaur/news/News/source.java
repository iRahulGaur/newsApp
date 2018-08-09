package com.rahulgaur.news.News;

public class source {
    private String id;
    private String name;

    public source(){
    }

    public source(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
