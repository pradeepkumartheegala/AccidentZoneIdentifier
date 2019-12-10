package com.example.accidentzoneidentifier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_Activity extends AppCompatActivity {

    //variables used to refer layout
    private EditText userName, userPwd;
    private Button loginBTN;
    private TextView forgotTV, link_signupTV;
    //Firebase authenticator
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        userName = findViewById(R.id.loginEmail);
        userPwd = findViewById(R.id.loginPassword);
        firebaseAuth = FirebaseAuth.getInstance();

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser != null) {
                    Toast.makeText(Login_Activity.this, "you are logged in", Toast.LENGTH_SHORT).show();
                    Intent b1 = new Intent(Login_Activity.this, LoginWelcome.class);
                    startActivity(b1);
                } else {
                    Toast.makeText(Login_Activity.this, "PLease login", Toast.LENGTH_SHORT).show();
                }

            }
        };

        loginBTN = findViewById(R.id.userLoginBTN);
        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String emailid = userName.getText().toString();
                String passwd = userPwd.getText().toString();

                if (emailid.isEmpty()) {
                    userName.setError("Enter the email");
                    userName.requestFocus();
                } else if (passwd.isEmpty()) {
                    userPwd.setError("Enter the password");
                    userPwd.requestFocus();
                } else if (emailid.isEmpty() && passwd.isEmpty()) {
                    Toast.makeText(Login_Activity.this, "fields are empty", Toast.LENGTH_SHORT).show();
                } else if (!(emailid.isEmpty() && passwd.isEmpty())) {
                    final ProgressBar progressBar = findViewById(R.id.progressBar);
                    progressBar.setVisibility(View.VISIBLE);
                    firebaseAuth.signInWithEmailAndPassword(emailid, passwd).addOnCompleteListener(Login_Activity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                progressBar.setVisibility(View.GONE);

                                Toast.makeText(Login_Activity.this, "Failed to login", Toast.LENGTH_SHORT).show();
                            } else {

                                startActivity(new Intent(Login_Activity.this, LoginWelcome.class));
                            }

                        }
                    });
                    progressBar.setVisibility(View.GONE);

                } else {
                    Toast.makeText(Login_Activity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        forgotTV = findViewById(R.id.forgotTV);
        forgotTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_Activity.this, ForgotPass.class));
            }
        });

        link_signupTV = findViewById(R.id.link_signupTV);
        link_signupTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Activity.this, SignupActivity.class));
            }
        });
    }
}
