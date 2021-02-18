package com.example.boardgames;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityMain extends AppCompatActivity {

    Button bt_Start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_Start = findViewById(R.id.bt_Start);
        bt_Start.setOnClickListener(v -> openActivityInitialize());

    }

    private void openActivityInitialize() {
        Intent intent = new Intent(this, ActivityInitialize.class);
        startActivity(intent);
    }
}