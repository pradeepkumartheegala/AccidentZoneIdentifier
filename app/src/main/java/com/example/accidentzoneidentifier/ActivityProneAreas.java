package com.example.accidentzoneidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ActivityProneAreas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prone_areas);
    }
    public void RouteBTN(View v){
        Intent b1= new Intent(this,AccidentzoneMapsActivity.class);
        Log.d("map","started");
        startActivity(b1);
    }
}
