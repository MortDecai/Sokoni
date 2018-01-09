package com.farmersmarket.john.sokoni.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.farmersmarket.john.sokoni.R;

import other.Ads;

public class MarketDestinationActivity extends AppCompatActivity {

    ImageView imageView;
    TextView heading;
    TextView price;
    TextView location;
    TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_destination);

        imageView = (ImageView) findViewById(R.id.ad_det_image);
        heading = (TextView) findViewById(R.id.ad_det_title);
        price = (TextView) findViewById(R.id.ad_det_price);
        location = (TextView) findViewById(R.id.ad_det_location);
        time = (TextView) findViewById(R.id.ad_det_time);

        Intent intent = getIntent();
        Ads ads = intent.getExtras().getParcelable("ads");

        imageView.setImageResource(ads.adPhoto);
        heading.setText(ads.heading);
        price.setText(ads.price);
        location.setText(ads.location);
        time.setText(ads.time);

    }
}
