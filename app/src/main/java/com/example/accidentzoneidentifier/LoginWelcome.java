package com.example.accidentzoneidentifier;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginWelcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_welcome);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.othermenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.aboutt:
                abouttAction();
                return true;
            case R.id.sett:
                settAction();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }


    public void abouttAction() {
        Intent b1 = new Intent(this, Login_Activity.class);
        startActivity(b1);


    }


    public void settAction() {


    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return true;}

    public void AccountBTN(View v) {
        Intent b1 = new Intent(this, Account.class);
        startActivity(b1);
    }

    public void dashboardBTN(View v) {
        Intent b1 = new Intent(this, Dashboard.class);
        startActivity(b1);
    }

    public void proneBTN(View v) {
        Intent b1 = new Intent(this, ActivityProneAreas.class);
        startActivity(b1);
    }

    public void logoutBTN(View v) {
        Intent b1 = new Intent(this, MainActivity.class);
        startActivity(b1);
    }

    public void reportAccBTN(View v) {
        startActivity(new Intent(this, Accident.class));
    }
}
