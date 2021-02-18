package com.example.boardgames;

import android.content.Intent;
import android.os.Bundle;
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

    EditText et_DieNumberNew;
    Button bt_SubmitNew;
    JSONObject jsonObject = new JSONObject();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        et_DieNumberNew = findViewById(R.id.et_DieNumberNew);
        bt_SubmitNew = findViewById(R.id.bt_SubmitNew);

        bt_SubmitNew.setOnClickListener(v -> {

            Die.dieNumber = Integer.parseInt(et_DieNumberNew.getText().toString());
            try {
                jsonObject.put("dieNumber", Die.dieNumber);
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

    }

    private void openActivityPlay() {
        Intent intent = new Intent(this, ActivityPlay.class);
        startActivity(intent);
    }
}