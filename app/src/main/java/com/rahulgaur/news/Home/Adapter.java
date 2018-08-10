package com.rahulgaur.news.Home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.rahulgaur.news.R;

import java.util.ArrayList;
import java.util.Date;

import static android.support.constraint.Constraints.TAG;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private ArrayList<com.rahulgaur.news.News.articles> articles;
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    public Adapter(ArrayList<com.rahulgaur.news.News.articles> articles) {
        this.articles = articles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        context = parent.getContext();

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final String title = articles.get(position).getTitle();
        final String desc = articles.get(position).getDescription();
        final String imageURL = articles.get(position).getUrlToImage();
        final String url = articles.get(position).getUrl();
        final Date publishedAt = articles.get(position).getPublishedAt();

        Log.e(TAG, "onBindViewHolder: time posted "+publishedAt.toString());

        viewHolder.setDescTV(desc);
        viewHolder.setImageView(imageURL);
        viewHolder.setTitleTV(title);

        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "url "+url, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView titleTV;
        private TextView descTV;
        private View mView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            imageView = mView.findViewById(R.id.item_imageView);
            titleTV = mView.findViewById(R.id.item_titleTV);
            descTV = mView.findViewById(R.id.item_descTV);
        }

        void setImageView(String url){
            try {
                Glide.with(context)
                        .load(url)
                        .into(imageView);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        void setTitleTV(String text){
            titleTV.setText(text);
        }

        void setDescTV(String text){
            descTV.setText(text);
        }
    }

}
