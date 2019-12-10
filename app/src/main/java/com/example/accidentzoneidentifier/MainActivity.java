package com.example.accidentzoneidentifier;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;

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


//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
    public void loginBTN(View v){
        Intent b1= new Intent(this,Login_Activity.class);
        startActivity(b1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id){
            case R.id.about:
                aboutAction();
                return true;
            case R.id.set:
                setAction();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }


    public void aboutAction(){



    }


    public void setAction(){


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


