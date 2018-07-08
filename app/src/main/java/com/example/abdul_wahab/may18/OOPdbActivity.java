package com.example.abdul_wahab.may18;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.objectbox.Box;

public class OOPdbActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oopdb);

        Box<FriendsResponse> fr = ((MyApplication) getApplication()).getBoxstore().boxFor(FriendsResponse.class);

        

    }
}
