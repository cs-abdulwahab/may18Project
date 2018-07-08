package com.example.abdul_wahab.may18;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class FirestoreRecyclerAdapterActivity extends AppCompatActivity {


    private FirebaseFirestore db;
    private FirestoreRecyclerAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firestore_recycler_adapter);

        recyclerView = findViewById(R.id.recViewFire);

        db = FirebaseFirestore.getInstance();

        Query query = db.collection("friends");

        String s="";

    }
}
