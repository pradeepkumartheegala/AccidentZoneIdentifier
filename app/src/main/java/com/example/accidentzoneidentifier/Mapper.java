package com.example.accidentzoneidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mapper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapper);
        Button btn=findViewById(R.id.MapBTN);
        btn.setOnClickListener(new View.OnClickListener(){


                                   @Override
                                   public void onClick(View view) {

                                   }
                               }


        );
    }
}
