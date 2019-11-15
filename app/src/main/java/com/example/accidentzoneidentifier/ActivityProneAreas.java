package com.example.accidentzoneidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityProneAreas extends AppCompatActivity {
    Button proneBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prone_areas);
        Button proneBTN=findViewById(R.id.GetRouteBTN);
        proneBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent b1 = new Intent(ActivityProneAreas.this, AccidentzoneMapsActivity.class);
                Log.d("map", "started");
                startActivity(b1);
            }
        });

    }
//    public void RouteBTN(View v){
//        SharedPreferences myData = getSharedPreferences("saveProne", Context.MODE_PRIVATE);
//        SharedPreferences.Editor ed = myData.edit();
//        EditText start = findViewById(R.id.EditStart);
//        EditText dest = findViewById(R.id.editDest);
//       ed.putString("sta",start.getText().toString());
//        ed.putString("des",dest.getText().toString());
//        ed.commit();
//        Toast.makeText(getApplicationContext(),"ProneAreas Created",Toast.LENGTH_SHORT).show();
//        Intent b1= new Intent(this,AccidentzoneMapsActivity.class);
//        startActivity(b1);
//
//    }


}
