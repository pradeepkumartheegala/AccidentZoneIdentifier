package com.example.accidentzoneidentifier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Account extends AppCompatActivity {
    EditText nameEt;
    TextView pwdTV;
    EditText emailet;
    EditText phoneET;
    EditText addresset;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        //initializing the firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();

        //getting the reference to account layout
        nameEt = findViewById(R.id.accountNameET);
        pwdTV = findViewById(R.id.accountPwdTV);
        emailet = findViewById(R.id.accountEmailET);
        phoneET = findViewById(R.id.accountPhoneET);
        addresset = findViewById(R.id.accountAddressET);
        String user_id = firebaseAuth.getCurrentUser().getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("userdata").child(user_id);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("name").getValue().toString();
                String password = dataSnapshot.child("password").getValue().toString();
                String email = dataSnapshot.child("email").getValue().toString();
                String phonenumber = dataSnapshot.child("phonenumber").getValue().toString();
                String address = dataSnapshot.child("address").getValue().toString();
                nameEt.setText(name);
                pwdTV.setText(password);
                emailet.setText(email);
                phoneET.setText(phonenumber);
                addresset.setText(address);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        SharedPreferences myData = getSharedPreferences("save", Context.MODE_PRIVATE);
//        SharedPreferences.Editor ed = myData.edit();
//        String name = myData.getString("name", "");
//        String password = myData.getString("password", "");
//        String email = myData.getString("email", "");
//        String phonenumber = myData.getString("phNo", "");
//        String address = myData.getString("address", "");
//        EditText nameEt = findViewById(R.id.accountNameET);
//        nameEt.setText(name);
//        TextView pwdTV = findViewById(R.id.accountPwdTV);
//        pwdTV.setText(password);
//        EditText emailet = findViewById(R.id.accountEmailET);
//        emailet.setText(email);
//        EditText phoneET = findViewById(R.id.accountPhoneET);
//        phoneET.setText(phonenumber);
//        EditText addresset = findViewById(R.id.accountAddressET);
//        addresset.setText(address);

        Button changepwd = findViewById(R.id.changePasswordBTN);
        changepwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent start = new Intent(Account.this, ChangePassword.class);
                startActivity(start);
            }
        });


    }
//
//    public void SaveAccount(View v) {
//        SharedPreferences myData = getSharedPreferences("save", Context.MODE_PRIVATE);
//        SharedPreferences.Editor ed = myData.edit();
//        EditText nameET = findViewById(R.id.accountNameET);
//        TextView pwd = findViewById(R.id.accountPwdTV);
//        EditText phno = findViewById(R.id.accountPhoneET);
//        EditText address = findViewById(R.id.accountAddressET);
//        EditText email = findViewById(R.id.accountEmailET);
//        ed.putString("name", (nameET.getText().toString()));
//        ed.putString("phNo",phno.getText().toString());
//        ed.putString("address",address.getText().toString());
//        ed.putString("password",pwd.getText().toString());
//        ed.putString("email",email.getText().toString());
//        ed.commit();
//        Intent b1 = new Intent(this, LoginWelcome.class);
//        startActivity(b1);
//        Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_SHORT).show();
//
//
//    }
}