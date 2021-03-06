package com.example.accidentzoneidentifier;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
    AutoCompleteTextView autoCompleteTextView;
    AutoCompleteTextView autoCompleteTextView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prone_areas);
        myRef = FirebaseDatabase.getInstance().getReference("message");
        st = findViewById(R.id.EditStart);
        dt = findViewById(R.id.editDest);

        routebtn = findViewById(R.id.GetRouteBTN);
        routebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RouteBTN();

            }
        });

        autoCompleteTextView = findViewById(R.id.editDest);
        autoCompleteTextView.setAdapter(new PlaceAutoSuggestAdapter(ActivityProneAreas.this, android.R.layout.simple_list_item_1));

        autoCompleteTextView1 = findViewById(R.id.EditStart);
        autoCompleteTextView1.setAdapter(new PlaceAutoSuggestAdapter(ActivityProneAreas.this, android.R.layout.simple_list_item_1));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.othermenu, menu);
        return true;}

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id){
            case R.id.aboutt:
                abouttAction();
                return true;
            case R.id.sett:
                settAction();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }


    public void abouttAction(){
        Intent b1=new Intent(this,Login_Activity.class);
        startActivity(b1);



    }


    public void settAction(){


    }


    public void RouteBTN() {
        String startpt = autoCompleteTextView.getText().toString();
        String destpt = autoCompleteTextView1.getText().toString();
        if (startpt.isEmpty()) {
            Toast.makeText(this, "Enter the starting point", Toast.LENGTH_SHORT).show();
        } else if (destpt.isEmpty()) {
            Toast.makeText(this, "Enter the ending point", Toast.LENGTH_SHORT).show();
        } else {
            Intent mapIntent = new Intent(this, MapsActivity.class);
            mapIntent.putExtra("start", startpt);
            mapIntent.putExtra("end", destpt);
            startActivity(mapIntent);
        }
    }
}