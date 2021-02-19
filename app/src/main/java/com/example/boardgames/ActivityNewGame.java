package com.example.boardgames;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ActivityNewGame extends AppCompatActivity {

    EditText et_DieNumberNew, et_DieSidesNew,et_PlayerName1,et_PlayerName2,et_PlayerName3,et_PlayerName4,et_PlayerName5,et_PlayerName6;
    Button bt_SubmitNew,bt_addFirstPlayer1,bt_addFirstPlayer2,bt_addFirstPlayer3,bt_addFirstPlayer4,bt_addFirstPlayer5,bt_addFirstPlayer6;

    JSONObject jsonObject = new JSONObject();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        et_DieNumberNew = findViewById(R.id.et_DieNumberNew);
        bt_SubmitNew = findViewById(R.id.bt_SubmitNew);
        et_DieSidesNew = findViewById(R.id.et_DieSidesNew);

        et_PlayerName1 = findViewById(R.id.et_PlayerName1);
        et_PlayerName2 = findViewById(R.id.et_PlayerName2);
        et_PlayerName3 = findViewById(R.id.et_PlayerName3);
        et_PlayerName4 = findViewById(R.id.et_PlayerName4);
        et_PlayerName5 = findViewById(R.id.et_PlayerName5);
        et_PlayerName6 = findViewById(R.id.et_PlayerName6);

        bt_addFirstPlayer1 = findViewById(R.id.bt_addFirstPlayer1);
        bt_addFirstPlayer2 = findViewById(R.id.bt_addFirstPlayer2);
        bt_addFirstPlayer3 = findViewById(R.id.bt_addFirstPlayer3);
        bt_addFirstPlayer4 = findViewById(R.id.bt_addFirstPlayer4);
        bt_addFirstPlayer5 = findViewById(R.id.bt_addFirstPlayer5);
        bt_addFirstPlayer6 = findViewById(R.id.bt_addFirstPlayer6);

        bt_SubmitNew.setOnClickListener(v -> {
            try {
                jsonObject.put("dieNumber", Integer.parseInt(et_DieNumberNew.getText().toString()));
                jsonObject.put("dieSides", Integer.parseInt(et_DieSidesNew.getText().toString()));
                String userString = jsonObject.toString();

                File file = new File(getApplicationContext().getFilesDir(), "snake.json");
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(userString);
                bufferedWriter.close();
            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }
            openActivityPlay();
        });

        et_PlayerName1.setVisibility(View.GONE);
        et_PlayerName2.setVisibility(View.GONE);
        et_PlayerName3.setVisibility(View.GONE);
        et_PlayerName4.setVisibility(View.GONE);
        et_PlayerName5.setVisibility(View.GONE);
        et_PlayerName6.setVisibility(View.GONE);

        bt_addFirstPlayer1.setOnClickListener(v -> {
            bt_addFirstPlayer1.setVisibility(View.GONE);
            et_PlayerName1.setVisibility(View.VISIBLE);
        });
        bt_addFirstPlayer2.setOnClickListener(v -> {
            bt_addFirstPlayer2.setVisibility(View.GONE);
            et_PlayerName2.setVisibility(View.VISIBLE);
        });
        bt_addFirstPlayer3.setOnClickListener(v -> {
            bt_addFirstPlayer3.setVisibility(View.GONE);
            et_PlayerName3.setVisibility(View.VISIBLE);
        });
        bt_addFirstPlayer4.setOnClickListener(v -> {
            bt_addFirstPlayer4.setVisibility(View.GONE);
            et_PlayerName4.setVisibility(View.VISIBLE);
        });
        bt_addFirstPlayer5.setOnClickListener(v -> {
            bt_addFirstPlayer5.setVisibility(View.GONE);
            et_PlayerName5.setVisibility(View.VISIBLE);
        });
        bt_addFirstPlayer6.setOnClickListener(v -> {
            bt_addFirstPlayer6.setVisibility(View.GONE);
            et_PlayerName6.setVisibility(View.VISIBLE);
        });

    }

    private void openActivityPlay() {
        Intent intent = new Intent(this, ActivityPlay.class);
        startActivity(intent);
    }
}