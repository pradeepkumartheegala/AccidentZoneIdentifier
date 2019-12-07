package com.example.accidentzoneidentifier;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {
    List<AccidentData> accidentList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    FirebaseFirestore firebaseFireStore;
    AccidentAdapter accidentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        firebaseFireStore = FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        retrieveData();
    }

    private void retrieveData() {
        firebaseFireStore.collection("Accidents").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                accidentList.clear();

                for (DocumentSnapshot accidentInformation : task.getResult()) {
                    accidentList.add(new AccidentData(accidentInformation.getString("id"), accidentInformation.getString("address"), accidentInformation.getString("state"), accidentInformation.getString("zipcode")));
                }

                accidentAdapter = new AccidentAdapter(Dashboard.this, accidentList);
                recyclerView.setAdapter(accidentAdapter);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(Dashboard.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
