package com.example.boardgames;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ActivityLoadGame extends AppCompatActivity {

    TextView tv_DieNumber, tv_DieSides, tv_PlayerName1, tv_PlayerName2, tv_PlayerName3, tv_PlayerName4, tv_PlayerName5, tv_PlayerName6;
    Button bt_SubmitLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_game);

        tv_DieNumber = findViewById(R.id.tv_DieNumber);
        tv_DieSides = findViewById(R.id.tv_DieSides);

        tv_PlayerName1 = findViewById(R.id.tv_PlayerName1);
        tv_PlayerName2 = findViewById(R.id.tv_PlayerName2);
        tv_PlayerName3 = findViewById(R.id.tv_PlayerName3);
        tv_PlayerName4 = findViewById(R.id.tv_PlayerName4);
        tv_PlayerName5 = findViewById(R.id.tv_PlayerName5);
        tv_PlayerName6 = findViewById(R.id.tv_PlayerName6);

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
            JSONArray joArray = new JSONArray(response);

            tv_DieNumber.setText(joArray.getJSONObject(0).get("dieNumber").toString());
            tv_DieSides.setText(joArray.getJSONObject(0).get("dieSides").toString());

            if (joArray.getJSONObject(1).has("player1Name"))
                tv_PlayerName1.setText(joArray.getJSONObject(1).get("player1Name").toString());
            if (joArray.getJSONObject(1).has("player2Name"))
                tv_PlayerName2.setText(joArray.getJSONObject(1).get("player2Name").toString());
            if (joArray.getJSONObject(1).has("player3Name"))
                tv_PlayerName3.setText(joArray.getJSONObject(1).get("player3Name").toString());
            if (joArray.getJSONObject(1).has("player4Name"))
                tv_PlayerName4.setText(joArray.getJSONObject(1).get("player4Name").toString());
            if (joArray.getJSONObject(1).has("player5Name"))
                tv_PlayerName5.setText(joArray.getJSONObject(1).get("player5Name").toString());
            if (joArray.getJSONObject(1).has("player6Name"))
                tv_PlayerName6.setText(joArray.getJSONObject(1).get("player6Name").toString());

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
        bt_SubmitLoad.setOnClickListener(v -> openActivityPlay());
    }

    private void openActivityPlay() {
        finish();
        Intent intent = new Intent(this, ActivityPlay.class);
        startActivity(intent);
    }

}