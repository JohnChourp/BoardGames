package com.example.boardgames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityMain extends AppCompatActivity {

    Button bt_Start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_Start = findViewById(R.id.bt_Start);
        bt_Start.setOnClickListener(v -> openActivityPlay());

    }

    private void openActivityPlay() {
        Intent intent = new Intent(this, ActivityPlay.class);
        startActivity(intent);
    }
}