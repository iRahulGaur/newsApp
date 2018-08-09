package com.rahulgaur.news.News;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    String BASE_URL = "https://newsapi.org/v2/";
    String Google_top = "top-headlines?sources=google-news-in&apiKey=467a297303ac4ba6ad3b0bbbc54d102d";
    String Times_Of_India_top = "top-headlines?sources=the-times-of-india&apiKey=467a297303ac4ba6ad3b0bbbc54d102d";

    @GET(Google_top)
    Call<News> getGoogleNews();
}