package com.example.accidentzoneidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
    }
    public void LogWelcomeBTN(View v){
        Intent b1= new Intent(this,LoginWelcome.class);
        startActivity(b1);
    }
}
