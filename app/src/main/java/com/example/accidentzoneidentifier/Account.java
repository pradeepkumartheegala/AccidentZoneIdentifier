package com.example.accidentzoneidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        SharedPreferences myData = getSharedPreferences("save", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = myData.edit();
        String name = myData.getString("name", "");
        String password = myData.getString("password", "");
        String email = myData.getString("email", "");
        String phonenumber = myData.getString("phNo", "");
        String address = myData.getString("address", "");


    }



}
