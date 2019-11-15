package com.example.accidentzoneidentifier;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Dashboard extends AppCompatActivity {
    Button noreportsBTN;
    TextView noReports;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        noreportsBTN = findViewById(R.id.ReportAccidentBtn);

        noReports=(TextView) findViewById(R.id.ReportsNumber);
        noreportsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ref= FirebaseDatabase.getInstance().getReference().child("Areas");
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String areaNumber=dataSnapshot.child("number").getValue().toString();
                        noReports.setText(areaNumber);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });






                Intent b1= new Intent(Dashboard.this,Accident.class);
                startActivity(b1);
            }
        });
    }

}
