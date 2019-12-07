package com.example.accidentzoneidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;





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


public class ActivityProneAreas extends AppCompatActivity {
    DatabaseReference myRef;
    Button routebtn;
    EditText st, dt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prone_areas);
        myRef = FirebaseDatabase.getInstance().getReference("message");
        st = (EditText) findViewById(R.id.EditStart);
        dt = (EditText) findViewById(R.id.editDest);

        routebtn = findViewById(R.id.GetRouteBTN);
        routebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RouteBTN();

            }
        });

    }

    public void RouteBTN() {
        String startpt = st.getText().toString();
        String destpt = dt.getText().toString();
        if (!TextUtils.isEmpty(startpt) && !TextUtils.isEmpty(destpt)) {
            String id = myRef.push().getKey();
            ProneArea p = new ProneArea(id, startpt, destpt);
            myRef.child(id).setValue(p);
            st.setText("");
            dt.setText("");
            Toast.makeText(getApplicationContext(),"ProneAreas Created", Toast.LENGTH_SHORT).show();
//            Intent b1 = new Intent(com.example.accidentzoneidentifier.ActivityProneAreas.this, AccidentzoneMapsActivity.class);
//            Log.d("map", "started");
//            startActivity(b1);


        } else {
            Toast.makeText(getApplicationContext(),"enter valid areas",Toast.LENGTH_SHORT).show();


        }

    }
}