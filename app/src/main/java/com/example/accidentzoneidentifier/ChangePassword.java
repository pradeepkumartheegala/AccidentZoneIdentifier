package com.example.accidentzoneidentifier;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChangePassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        Button pwdBTN = findViewById(R.id.changePasswordBTN);
        pwdBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences myData = getSharedPreferences("save", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = myData.edit();
                EditText currentPwd = findViewById(R.id.currentPwdET);
                String pwd = myData.getString("password", "");
                if (pwd.equals(currentPwd.getText().toString())) {
                    EditText newPwd = findViewById(R.id.newPwdET);
                    ed.putString("password", newPwd.getText().toString());
                    Toast.makeText(getApplicationContext(), "Updated password", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "current password is wrong", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}
