package com.sribandi.hotsauce.eventapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;


public class main_activity extends AppCompatActivity {
//    KdTree<Event> db;
    HashMap<Pair<Integer, Integer>, ArrayList<Event>> db;
//    private final int ROUNDING = 100;
//    TreeManager db;
    Button search;
    EditText latEdit;
    EditText longEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_header);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        db = new KdTree<Event>(360, 360);
        db = new HashMap<Pair<Integer, Integer>, ArrayList<Event>> ();
//        db = new TreeManager();

        FloatingActionButton pack = (FloatingActionButton) findViewById(R.id.pack);
        pack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getApplicationContext(), AddEventBackEnd.class );
                startActivityForResult(myIntent, 1);
            }
        });

        search = (Button) findViewById(R.id.search);
        latEdit = (EditText) findViewById(R.id.latitude);
        longEdit = (EditText)findViewById(R.id.longitude);

    }

    @Override
    /* Get info about one event, create a event object and add it to the kdTree. */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                String title = data.getStringExtra("Title");
                String description = data.getStringExtra("Description");
                Double longitude = data.getDoubleExtra("Longitude", -1);
                Double latitude = data.getDoubleExtra("Latitude", -1);
                int rating = data.getIntExtra("Rating", -1);
                if (longitude == -1 || latitude == -1)
                    throw new IllegalStateException("Invalid latitude or longitude");
                if (rating < 0)
                    throw new IllegalStateException("Invalid rating");

                Event entry = new Event(title, description, rating, longitude, latitude);
//                db.addEvent(latitude, longitude, title, description, rating);
                add_entry(entry);
            }
        }
    }

    // onclick listener for search button
    public void find (View v){
        //NEED TO IMPLEMENT THIS :o

    }



    // Helper function that updates the event entry to the database.
    private void add_entry (Event entry) {
        // cute off the last 2 digits. Flexible for general location.
        int rounded_longitude = (int) entry.getLongitude()*ROUNDING;
        int rounded_latitude = (int) entry.getLatitude()*ROUNDING;
        Pair<Integer, Integer> pair = new Pair<Integer, Integer>(rounded_longitude, rounded_latitude);
        if (db.containsKey(pair))
            db.get(pair).add(entry);
        else
        {
            ArrayList<Event> events = new ArrayList<Event>();
            events.add(entry);
            db.put(pair, events);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_doing_things, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
