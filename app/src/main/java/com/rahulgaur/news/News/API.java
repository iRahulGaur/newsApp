package com.rahulgaur.news.News;

import retrofit2.Call;
import retrofit2.http.GET;

//This is important for Retrofit, This interface defines the Base Url of Api and the rest address including API KEY
//here right now Google_Top is Calling using "GET" from Base Url
//we can modify the Call but setting values to getGoogleNews() from the main as we want.

public interface API {
    String BASE_URL = "https://newsapi.org/v2/";
    String Google_top = "top-headlines?sources=google-news-in&apiKey=467a297303ac4ba6ad3b0bbbc54d102d";
    String Times_Of_India_top = "top-headlines?sources=the-times-of-india&apiKey=467a297303ac4ba6ad3b0bbbc54d102d";

    @GET(Google_top)
    Call<News> getGoogleNews();
}