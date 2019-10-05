package com.example.accidentzoneidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Accident extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accident);
    }
    public void reportBTN(View v){
        Intent b1= new Intent(this,LoginWelcome.class);
        startActivity(b1);
    }
}
