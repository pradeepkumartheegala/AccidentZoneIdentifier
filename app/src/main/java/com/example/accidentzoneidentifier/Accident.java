package com.example.accidentzoneidentifier;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
        SharedPreferences myData = getSharedPreferences("saveAccident", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = myData.edit();
        EditText location = findViewById(R.id.LocationET);
        EditText zipCode = findViewById(R.id.zipcodeET);
        EditText street = findViewById(R.id.StreetET);
        EditText landmark = findViewById(R.id.LandET);
        ed.putString("name", (location.getText().toString()));
        ed.putString("phNo",zipCode.getText().toString());
        ed.putString("address",street.getText().toString());
        ed.putString("password",landmark.getText().toString());

        ed.commit();
    }
}
