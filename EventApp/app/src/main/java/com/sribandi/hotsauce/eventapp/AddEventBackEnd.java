package com.sribandi.hotsauce.eventapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;

/**
 * Created by hotsauce on 4/16/16.
 */


public class AddEventBackEnd extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_event);

    }


    public void buttonClicked(View v) {
        EditText titleEdit = (EditText) findViewById(R.id.titleID);
        String title = titleEdit.getText().toString();
        EditText desEdit = (EditText) findViewById(R.id.desID);
        String description = desEdit.getText().toString();
        EditText longEdit = (EditText) findViewById(R.id.longitude);
        Double longtitude = Double.parseDouble(longEdit.getText().toString());
        EditText latEdit = (EditText) findViewById(R.id.latitude);
        Double latitude = Double.parseDouble(latEdit.getText().toString());
        RatingBar rb = (RatingBar) findViewById(R.id.ratingBar);
        int rating = Math.round(rb.getRating());

        Intent resultIntent = new Intent(this, main_activity.class);
        resultIntent.putExtra("Title", title);
        resultIntent.putExtra("Description", description);
        resultIntent.putExtra("Longtitude", longtitude);
        resultIntent.putExtra("Latititude", latitude);
        resultIntent.putExtra("Rating", rating);


        setResult(RESULT_OK, resultIntent);
        finish();
    }

}