package com.example.accidentzoneidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mFirebaseAuth = FirebaseAuth.getInstance();
        EditText nameET = findViewById(R.id.NameET);
        EditText pwd = findViewById(R.id.passwordET);
        EditText phno = findViewById(R.id.phoneET);
        EditText address = findViewById(R.id.EditAddressTV);
        EditText email = findViewById(R.id.EmailET);
    }
    public void create(View v){


        SharedPreferences myData = getSharedPreferences("save",Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = myData.edit();

        ed.putString("name", (nameET.getText().toString()));
        ed.putString("phNo",phno.getText().toString());
        ed.putString("address",address.getText().toString());
        ed.putString("password",pwd.getText().toString());
        ed.putString("email",email.getText().toString());
        ed.commit();
        Toast.makeText(getApplicationContext(),"Account Created",Toast.LENGTH_SHORT).show();
        Intent b1= new Intent(this,Login_Activity.class);
        startActivity(b1);

    }

}
