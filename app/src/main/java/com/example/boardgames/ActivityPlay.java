package com.example.boardgames;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityPlay extends AppCompatActivity {

    TextView tv_DieResult;
    Button bt_RollDie;

    Die die = new Die();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        tv_DieResult = findViewById(R.id.tv_DieResult);
        bt_RollDie = findViewById(R.id.bt_RollDie);

        bt_RollDie.setOnClickListener(v -> tv_DieResult.setText("" + die.setDieRolledNumber()));
    }
}