package com.sribandi.hotsauce.eventapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.EditText;


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

        Intent resultIntent = new Intent(AddEventBackEnd.this, main_activity.class);
        resultIntent.putExtra(title, 1331);
        resultIntent.putExtra(description, 1331);

        finish();
    }
}