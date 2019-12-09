package com.example.accidentzoneidentifier;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void loginBTN(View v){
        Intent b1= new Intent(this,Login_Activity.class);
        startActivity(b1);
    }

    public void signUpBTN(View v){
        Intent b1= new Intent(this,SignupActivity.class);
        startActivity(b1);
    }



//    public void RouteBTN(View v) {
//        Intent b1 = new Intent(this, AccidentzoneMapsActivity.class);
//        Log.d("map", "started");
//        startActivity(b1);
//    }


}


