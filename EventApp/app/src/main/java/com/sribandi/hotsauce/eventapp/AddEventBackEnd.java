package com.sribandi.hotsauce.eventapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


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
        finish();
    }
}