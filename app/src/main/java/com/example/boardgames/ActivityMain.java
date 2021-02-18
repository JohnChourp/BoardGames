package com.example.boardgames;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityMain extends AppCompatActivity {

    Button bt_NewGame, bt_LoadGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_NewGame = findViewById(R.id.bt_NewGame);
        bt_LoadGame = findViewById(R.id.bt_LoadGame);
        bt_NewGame.setOnClickListener(v -> openActivityNewGame());
        bt_LoadGame.setOnClickListener(v -> openActivityLoadGame());
    }

    private void openActivityNewGame() {
        Intent intent = new Intent(this, ActivityNewGame.class);
        startActivity(intent);
    }

    private void openActivityLoadGame() {
        Intent intent = new Intent(this, ActivityLoadGame.class);
        startActivity(intent);
    }
}