package com.example.boardgames;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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

        File file = new File(getApplicationContext().getFilesDir(), "snake.json");
        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line).append("\n");
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            String response = stringBuilder.toString();
            JSONArray joArray = new JSONArray(response);

            die.setDieNumber(joArray.getJSONObject(0).getInt("dieNumber"));
            die.setDieSides(joArray.getJSONObject(0).getInt("dieSides"));
            bt_RollDie.setOnClickListener(v -> tv_DieResult.setText("" + die.setDieRolledNumber()));

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}