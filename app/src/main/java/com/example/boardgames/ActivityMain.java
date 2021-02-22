package com.example.boardgames;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
        finish();
        Intent intent = new Intent(this, ActivityNewGame.class);
        startActivity(intent);
    }

    private void openActivityLoadGame() {
        finish();
        Intent intent = new Intent(this, ActivityLoadGame.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityMain.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.mipmap.ic_snakes_and_ladders_round);
        builder.setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", (dialog, id) -> finish())
                .setNegativeButton("No", (dialog, id) -> dialog.cancel());
        AlertDialog alert = builder.create();
        alert.show();
    }
}