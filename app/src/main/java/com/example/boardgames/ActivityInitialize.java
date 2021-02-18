package com.example.boardgames;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityInitialize extends AppCompatActivity {

    EditText et_DieNumber;
    Button bt_Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initialize);
        et_DieNumber = findViewById(R.id.et_DieNumber);
        bt_Submit = findViewById(R.id.bt_Submit);

        bt_Submit.setOnClickListener(v -> {
            Die.dieNumber = Integer.parseInt(et_DieNumber.getText().toString());
            openActivityPlay();
        });
    }

    private void openActivityPlay() {
        Intent intent = new Intent(this, ActivityPlay.class);
        startActivity(intent);
    }
}