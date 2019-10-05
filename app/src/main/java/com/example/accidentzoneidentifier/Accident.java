package com.example.accidentzoneidentifier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Accident extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accident);
    }

    //    Once the user clicks the report then it navigates to users main page
    public void reportBTN(View v) {
        Intent b1 = new Intent(this, LoginWelcome.class);
        startActivity(b1);
    }
}
