package com.example.abdul_wahab.may18;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    List<Node> nodeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nodeList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {

            nodeList.add(new Node("name " + i, "url " + i));
        }


        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setAdapter(new NodeAdapter(nodeList));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));






    }
}
