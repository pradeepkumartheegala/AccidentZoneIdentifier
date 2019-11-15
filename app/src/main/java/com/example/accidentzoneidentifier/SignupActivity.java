package com.example.accidentzoneidentifier;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    FirebaseAuth mFirebaseAuth;
    EditText nameET ;
    EditText pwd ;
    EditText phno;
    EditText address;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mFirebaseAuth = FirebaseAuth.getInstance();
         nameET = findViewById(R.id.NameET);
         pwd = findViewById(R.id.passwordET);
         phno = findViewById(R.id.phoneET);
         address = findViewById(R.id.EditAddressTV);
         email = findViewById(R.id.EmailET);
          Button RegisterBTN = findViewById(R.id.RegisterBTN);
          RegisterBTN.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  String emailid = email.getText().toString();
                  String passwd = pwd.getText().toString();
                  if(emailid.isEmpty()){
                      email.setError("Enter the email");
                      email.requestFocus();
                  }else if(passwd.isEmpty()){
                      pwd.setError("Enter the password");
                      pwd.requestFocus();
                  }else if (emailid.isEmpty()&&passwd.isEmpty()){
                      Toast.makeText(SignupActivity.this, "fields are empty", Toast.LENGTH_SHORT).show();

                  }else if(!(emailid.isEmpty()&&passwd.isEmpty())){
                      mFirebaseAuth.createUserWithEmailAndPassword(emailid,passwd).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                          @Override
                          public void onComplete(@NonNull Task<AuthResult> task) {
                              if(!task.isSuccessful()){
                                  Toast.makeText(SignupActivity.this, "Fields are empty try again", Toast.LENGTH_SHORT).show();
                              }else{
                                  Toast.makeText(getApplicationContext(),"Account Created",Toast.LENGTH_SHORT).show();
                                  Intent b1= new Intent(SignupActivity.this,Login_Activity.class);
                                  startActivity(b1);                              }
                          }
                      });
                  }

              }
          });
    }
//    public void create(View v){
//
//
//        SharedPreferences myData = getSharedPreferences("save",Context.MODE_PRIVATE);
//        SharedPreferences.Editor ed = myData.edit();
//
//        ed.putString("name", (nameET.getText().toString()));
//        ed.putString("phNo",phno.getText().toString());
//        ed.putString("address",address.getText().toString());
//        ed.putString("password",pwd.getText().toString());
//        ed.putString("email",email.getText().toString());
//        ed.commit();
//        Toast.makeText(getApplicationContext(),"Account Created",Toast.LENGTH_SHORT).show();
//        Intent b1= new Intent(this,Login_Activity.class);
//        startActivity(b1);
//
//    }

}
