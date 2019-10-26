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

public class Account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);


        SharedPreferences myData = getSharedPreferences("save", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = myData.edit();
        String name = myData.getString("name", "");
        String password = myData.getString("password", "");
        String email = myData.getString("email", "");
        String phonenumber = myData.getString("phNo", "");
        String address = myData.getString("address", "");
        EditText nameEt = findViewById(R.id.accountNameET);
        nameEt.setText(name);
        TextView pwdTV = findViewById(R.id.accountPwdTV);
        pwdTV.setText(password);
        EditText emailet = findViewById(R.id.accountEmailET);
        emailet.setText(email);
        EditText phoneET = findViewById(R.id.accountPhoneET);
        phoneET.setText(phonenumber);
        EditText addresset = findViewById(R.id.accountAddressET);
        addresset.setText(address);



    }

    public void SaveAccount(View v) {
        SharedPreferences myData = getSharedPreferences("save", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = myData.edit();
        EditText nameET = findViewById(R.id.accountNameET);
        TextView pwd = findViewById(R.id.accountPwdTV);
        EditText phno = findViewById(R.id.accountPhoneET);
        EditText address = findViewById(R.id.accountAddressET);
        EditText email = findViewById(R.id.accountEmailET);
        ed.putString("name", (nameET.getText().toString()));
        ed.putString("phNo",phno.getText().toString());
        ed.putString("address",address.getText().toString());
        ed.putString("password",pwd.getText().toString());
        ed.putString("email",email.getText().toString());
        ed.commit();
        Intent b1 = new Intent(this, LoginWelcome.class);
        startActivity(b1);


    }
}