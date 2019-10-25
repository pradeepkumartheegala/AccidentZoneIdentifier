package com.example.accidentzoneidentifier;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
    }

    public void LogWelcomeBTN(View v) {
        SharedPreferences myData = getSharedPreferences("save", Context.MODE_PRIVATE);
        EditText userName = findViewById(R.id.loginEmail);
        EditText userPwd = findViewById(R.id.loginPassword);
        String email = myData.getString("email", "");
        String pwd = myData.getString("password", "");
        if (!email.equals("") && !pwd.equals("")) {
            if (email.equalsIgnoreCase(userName.getText().toString()) && pwd.equalsIgnoreCase(userPwd.getText().toString())) {
                Intent b1 = new Intent(this, LoginWelcome.class);
                startActivity(b1);
            } else {
                Toast.makeText(getApplicationContext(), "Username or Password is incorrect", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "NO DATA FOUND", Toast.LENGTH_SHORT).show();

        }
    }
}
