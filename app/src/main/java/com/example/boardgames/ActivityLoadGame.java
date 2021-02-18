package com.example.boardgames;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ActivityLoadGame extends AppCompatActivity {

    EditText et_DieNumberLoad;
    Button bt_SubmitLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_game);
        et_DieNumberLoad = findViewById(R.id.et_DieNumberLoad);
        bt_SubmitLoad = findViewById(R.id.bt_SubmitLoad);

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
            JSONObject jsonObject = new JSONObject(response);
            et_DieNumberLoad.setText(jsonObject.get("dieNumber").toString());

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        bt_SubmitLoad.setOnClickListener(v -> {
            Die.dieNumber = Integer.parseInt(et_DieNumberLoad.getText().toString());
            openActivityPlay();
        });
    }

    private void openActivityPlay() {
        Intent intent = new Intent(this, ActivityPlay.class);
        startActivity(intent);
    }

}