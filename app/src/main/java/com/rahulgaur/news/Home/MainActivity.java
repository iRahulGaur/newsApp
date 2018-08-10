package com.rahulgaur.news.Home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.rahulgaur.news.News.API;
import com.rahulgaur.news.News.News;
import com.rahulgaur.news.News.articles;
import com.rahulgaur.news.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ArrayList<articles> articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.news_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        articles = new ArrayList<>();

        Adapter adapter = new Adapter(articles);

        recyclerView.setAdapter(adapter);

        //for "GET" method of JSON
        //Also converts the JSON object into Simple Java Object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Needed for "GET"
        API api = retrofit.create(API.class);

        //Getting All API Data in callNews
        Call<News> callNews = api.getGoogleNews();

        try {
            //predefined methods of CALL
            callNews.enqueue(new Callback<News>() {
                @Override
                public void onResponse(Call<News> call, Response<News> response) {
                    //getting the Data in NEWS
                    News news = response.body();
                    //getting the from NEWS and Passing it in ARTICLES
                    articles = news.getArticles();
                    for (articles a : articles) {
                        Log.e(TAG, "onResponse: news status " + a.getTitle());
                        Log.e(TAG, "onResponse: news articles number " + a.getDescription());
                    }
                }

                @Override
                public void onFailure(Call<News> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Failed " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "onFailure: error " + t.getMessage() + " " + t.getLocalizedMessage() + " " + t.getCause());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
