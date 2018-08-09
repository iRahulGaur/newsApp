package com.rahulgaur.news.News;

import java.util.ArrayList;

//this is the main JSON Object, which includes JSON Array Article.

public class News {
    private String status;
    private int totalResults;
    private ArrayList<articles> articles;

    public News() {
    }

    public News(String status, int totalResults, ArrayList<com.rahulgaur.news.News.articles> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<com.rahulgaur.news.News.articles> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<com.rahulgaur.news.News.articles> articles) {
        this.articles = articles;
    }
}
