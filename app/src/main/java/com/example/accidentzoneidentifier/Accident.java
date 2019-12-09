package com.example.accidentzoneidentifier;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Accident extends AppCompatActivity {

    EditText address, state, zipcode;
    Button reportBTN;
    FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accident);


        address = findViewById(R.id.LocationET);
        state = findViewById(R.id.StreetET);
        zipcode = findViewById(R.id.zipcodeET);
        reportBTN = findViewById(R.id.reportBTN);
        firebaseFirestore = FirebaseFirestore.getInstance();

        reportBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveAccident(address.getText().toString(), state.getText().toString(), zipcode.getText().toString());
            }
        });
    }


//    public boolean onCreateOptionsMenu(Menu menu){
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return true;
//    }


    private void saveAccident(String addressStr, String stateStr, String zipStr) {
        String id = UUID.randomUUID().toString();
        Map<String, Object> doc = new HashMap<>();
        doc.put("id", id);
        doc.put("address", addressStr);
        doc.put("state", stateStr);
        doc.put("zipcode", zipStr);

        firebaseFirestore.collection("Accidents").document(id).set(doc)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        Toast.makeText(Accident.this, "Accident Added..", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Accident.this, LoginWelcome.class));
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(Accident.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

    }
}
