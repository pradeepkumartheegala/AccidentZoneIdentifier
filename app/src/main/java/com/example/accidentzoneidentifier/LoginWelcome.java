package com.example.accidentzoneidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginWelcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_welcome);
    }
    public void AccountBTN(View v){
        Intent b1= new Intent(this,Account.class);
        startActivity(b1);
    }
    public void dashboardBTN(View v){
        Intent b1= new Intent(this,Dashboard.class);
        startActivity(b1);
        }
    public void proneBTN(View v){
        Intent b1= new Intent(this,ActivityProneAreas.class);
        startActivity(b1);
    }
    public void logoutBTN(View v){
        Intent b1= new Intent(this,MainActivity.class);
        startActivity(b1);
    }
}
