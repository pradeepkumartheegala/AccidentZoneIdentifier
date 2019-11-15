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
    Button AccidentReportBTN;
    DatabaseReference myref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accident);
        myref= FirebaseDatabase.getInstance().getReference("");

        location = findViewById(R.id.LocationET);
        zipCode = findViewById(R.id.zipcodeET);
        street = findViewById(R.id.StreetET);
        landmark = findViewById(R.id.LandET);
        AccidentReportBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loc=location.getText().toString();
                String zip=zipCode.getText().toString();
                String stre=street.getText().toString();
                String land=landmark.getText().toString();
                if(!loc.isEmpty() && !zip.isEmpty() && !stre.isEmpty() && !land.isEmpty()){
                    AccidentData acc=new AccidentData(loc,stre,zip,land);
                    landmark.setText("");
                    location.setText("");
                    zipCode.setText("");
                    street.setText("");
                    myref.setValue(acc);


                }




                Intent b1 = new Intent(Accident.this, LoginWelcome.class);
                startActivity(b1);
            }
        });
    }

    //    Once the user clicks the report then it navigates to users main page

}