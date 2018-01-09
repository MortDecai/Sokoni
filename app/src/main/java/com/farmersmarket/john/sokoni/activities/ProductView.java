package com.farmersmarket.john.sokoni.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.farmersmarket.john.sokoni.R;

import java.util.List;

import adapters.MarketCardAdapter;
import other.Ads;

public class ProductView extends AppCompatActivity {

    private List<Ads> adsList;
    private RecyclerView rv;
    private Context context;
    MarketCardAdapter adapter = new MarketCardAdapter(adsList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);

    }
}
