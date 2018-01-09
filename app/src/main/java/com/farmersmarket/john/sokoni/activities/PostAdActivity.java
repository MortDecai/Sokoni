package com.farmersmarket.john.sokoni.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.farmersmarket.john.sokoni.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import other.AppConfig;
import other.AppController;

public class PostAdActivity extends AppCompatActivity {

    private Spinner spinner;
    private Toolbar toolbar;

    // Progress Dialog
    private ProgressDialog pDialog;
    private static final String TAG = PostAdActivity.class.getSimpleName();
    private EditText etTitle, etPrice, etContact, etLocation, etRegion, etImage, etDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_ad);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etTitle = (EditText) findViewById(R.id.ad_name);
        etPrice = (EditText) findViewById(R.id.ad_price);
        etContact = (EditText) findViewById(R.id.ad_contact);
        etLocation = (EditText) findViewById(R.id.ad_location);
        etRegion = (EditText) findViewById(R.id.ad_region);
        etImage = (EditText) findViewById(R.id.ad_image);
        etDescription = (EditText) findViewById(R.id.ad_description);

        spinner = (Spinner) findViewById(R.id.ad_category);

        Button btnSubmit = (Button) findViewById(R.id.btnPostAd);
        Button btnCancel = (Button) findViewById(R.id.btnCancel);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PostAdActivity.this, MainActivity.class));
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // creating new product in background thread
                String category = String.valueOf(spinner.getSelectedItem());
                String title = etTitle.getText().toString();
                String price = etPrice.getText().toString();
                String contact = etContact.getText().toString();
                String location = etLocation.getText().toString();
                String region = etRegion.getText().toString();
                String image = etImage.getText().toString();
                String description = etDescription.getText().toString();

                if (!title.isEmpty() && !price.isEmpty() && !region.isEmpty()) {
                    postAd(title, price, category, contact, location, region, image, description);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter your details!", Toast.LENGTH_LONG)
                            .show();
                }
        }

    });
    }
    /**
     * Function to store ad in MySQL database will post params(tag, name,
     * email, password) to register url
     * */

    private void postAd(final String title, final String price,
                              final String category, final String contact, final String location,
                        final String region, final String image, final String description) {
        // Tag used to cancel the request
        String tag_string_req = "req_register";

        pDialog.setMessage("Posting new ad ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_POST_AD, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Ad post Response: " + response.toString());
                hideDialog();

                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    if (!error) {
                        // User successfully stored in MySQL
                        Toast.makeText(getApplicationContext(), "Ad successfully added. Try refreshing now!", Toast.LENGTH_LONG).show();

                        // Launch login activity
                        Intent intent = new Intent(
                                PostAdActivity.this,
                                MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {

                        // Error occurred in registration. Get the error
                        // message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Uploading Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();
                params.put("title", title);
                params.put("price", price);
                params.put("category", category);
                params.put("contact", contact);
                params.put("location", location);
                params.put("region", region);
                params.put("image", image);
                params.put("description", description);

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}

