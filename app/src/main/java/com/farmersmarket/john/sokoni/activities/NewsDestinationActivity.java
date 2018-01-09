package com.farmersmarket.john.sokoni.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.farmersmarket.john.sokoni.R;

import other.News;

public class NewsDestinationActivity extends AppCompatActivity {


    ImageView imageView;
    TextView heading;
    TextView body;
    TextView author;
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_destination);

        imageView = (ImageView) findViewById(R.id.news_det_image);
        heading = (TextView) findViewById(R.id.news_det_title);
        body = (TextView) findViewById(R.id.news_det_body);
        author = (TextView) findViewById(R.id.news_det_author);
        date = (TextView) findViewById(R.id.news_det_date);

        Intent intent = getIntent();
        News news = intent.getExtras().getParcelable("news");

        imageView.setImageResource(news.newsPhoto);
        heading.setText(news.heading);
        body.setText(news.body);
        author.setText(news.author);
        date.setText(news.date);


    }
}
