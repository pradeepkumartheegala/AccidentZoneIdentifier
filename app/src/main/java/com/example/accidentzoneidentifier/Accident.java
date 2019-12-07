package com.example.accidentzoneidentifier;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Accident extends AppCompatActivity {
    EditText landmark,street,zipCode,location;
    Button accidentReportBTN;
    DatabaseReference myref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accident);
        myref= FirebaseDatabase.getInstance().getReference("Accidents");
        accidentReportBTN=findViewById(R.id.reportBTN);
        location = findViewById(R.id.LocationET);
        zipCode = findViewById(R.id.zipcodeET);
        street = findViewById(R.id.StreetET);
        landmark = findViewById(R.id.LandET);
        accidentReportBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loc=location.getText().toString();
                String zip=zipCode.getText().toString();
                String stre=street.getText().toString();
                String land=landmark.getText().toString();

                if(!loc.isEmpty() && !zip.isEmpty() && !stre.isEmpty() && !land.isEmpty()){
                    String id=myref.push().getKey();
                    AccidentData p=new AccidentData(id,loc,stre,zip,land);
                    myref.child(id).setValue(p);
                    landmark.setText("");
                    location.setText("");
                    zipCode.setText("");
                    street.setText("");

                }

                Intent b1 = new Intent(Accident.this, LoginWelcome.class);
                startActivity(b1);
            }
        });
    }

    //    Once the user clicks the report then it navigates to users main page

}