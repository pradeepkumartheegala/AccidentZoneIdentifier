package com.example.accidentzoneidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
    }

    public void SetPassBTN(View v){
        Intent b1= new Intent(this,Login_Activity.class);
        startActivity(b1);
    }
    public void saveBTN(View v){
        Intent b1= new Intent(this,LoginWelcome.class);
        startActivity(b1);
    }
}
