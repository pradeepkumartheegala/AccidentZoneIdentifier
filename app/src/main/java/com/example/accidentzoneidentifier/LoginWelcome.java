package com.example.accidentzoneidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginWelcome extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_welcome);
        SharedPreferences myData = getSharedPreferences("save", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = myData.edit();
        String  name = myData.getString("name","");
        TextView displayTV = findViewById(R.id.displayUser);
        displayTV.setText("Welcome "+name);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id){
            case R.id.aboutt:
                abouttAction();
                return true;
            case R.id.sett:
                settAction();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }


    public void abouttAction(){
        Intent b1=new Intent(this,Login_Activity.class);
        startActivity(b1);



    }


    public void settAction(){


    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return true;}

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
    public void reportAccBTN(View v){
        startActivity(new Intent(this, Accident.class));
    }
}
