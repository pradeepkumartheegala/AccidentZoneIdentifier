package com.example.accidentzoneidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
Button noreportsBTN=findViewById(R.id.ReportAccidentBtn);
noreportsBTN.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

    }
});
    }
    
    public void accidentBTN(View v){
        Intent b1= new Intent(this,Accident.class);
        startActivity(b1);
    }
}
