package com.example.accidentzoneidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void loginBTN(View v){
        Intent b1= new Intent(this,Login_Activity.class);
        startActivity(b1);
    }

    public void signUpBTN(View v){
        Intent b1= new Intent(this,SignupActivity.class);
        startActivity(b1);
    }
}
