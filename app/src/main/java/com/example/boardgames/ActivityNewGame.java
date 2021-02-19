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
import java.util.regex.Pattern;

public class ActivityNewGame extends AppCompatActivity {

    EditText et_DieNumberNew,et_DieSidesNew;
    Button bt_SubmitNew;

    JSONObject jsonObject = new JSONObject();
    Die die = new Die();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);
        et_DieNumberNew = findViewById(R.id.et_DieNumberNew);
        bt_SubmitNew = findViewById(R.id.bt_SubmitNew);
        et_DieSidesNew = findViewById(R.id.et_DieSidesNew);

        bt_SubmitNew.setOnClickListener(v -> {
            String dieNumber = et_DieNumberNew.getText().toString();
            String dieSides = et_DieSidesNew.getText().toString();

            die.setDieNumber(Integer.parseInt(dieNumber));
            die.setDieSides(Integer.parseInt(dieSides));
            try {
                jsonObject.put("dieNumber", die.getDieNumber());
                jsonObject.put("dieSides", die.getDieSides());
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