package com.hacktx2016.hackdfw;

import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.util.Log;
import android.content.Intent;
/**
 * Created by hotsauce on 4/16/16.
 */
public class AddEventBackEnd   extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_event);


    }
    public void buttonClick(View view){
        finish();
    }
}