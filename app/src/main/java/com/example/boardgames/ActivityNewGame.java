package com.example.boardgames;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ActivityNewGame extends AppCompatActivity {

    EditText et_DieNumberNew, et_DieSidesNew, et_PlayerName1, et_PlayerName2, et_PlayerName3, et_PlayerName4, et_PlayerName5, et_PlayerName6;
    Button bt_SubmitNew, bt_addFirstPlayer1, bt_addFirstPlayer2, bt_addFirstPlayer3, bt_addFirstPlayer4, bt_addFirstPlayer5, bt_addFirstPlayer6;
    ImageView iv_delete1, iv_delete2, iv_delete3, iv_delete4, iv_delete5, iv_delete6;

    JSONObject joDie = new JSONObject();
    JSONArray joArrayPlayer = new JSONArray();
    JSONObject joPlayerName = new JSONObject();
    JSONObject joPlayerCurrentPos = new JSONObject();

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

        iv_delete1 = findViewById(R.id.iv_delete1);
        iv_delete2 = findViewById(R.id.iv_delete2);
        iv_delete3 = findViewById(R.id.iv_delete3);
        iv_delete4 = findViewById(R.id.iv_delete4);
        iv_delete5 = findViewById(R.id.iv_delete5);
        iv_delete6 = findViewById(R.id.iv_delete6);

        bt_SubmitNew.setOnClickListener(v -> {
            try {
                if (!et_DieNumberNew.getText().toString().isEmpty() && !et_DieSidesNew.getText().toString().isEmpty()) {
                    if (Integer.parseInt(et_DieNumberNew.getText().toString()) > 0 && Integer.parseInt(et_DieNumberNew.getText().toString()) <= 99 && Integer.parseInt(et_DieSidesNew.getText().toString()) > 0 && Integer.parseInt(et_DieSidesNew.getText().toString()) <= 99) {
                        joDie.put("dieNumber", Integer.parseInt(et_DieNumberNew.getText().toString()));
                        joDie.put("dieSides", Integer.parseInt(et_DieSidesNew.getText().toString()));

                        if (et_PlayerName1.getVisibility() == View.VISIBLE && !(et_PlayerName1.getText().toString().equals(""))){
                            joPlayerName.put("player1Name", et_PlayerName1.getText().toString());
                            joPlayerCurrentPos.put("player1CurrentPos", 0);
                        }
                        if (et_PlayerName2.getVisibility() == View.VISIBLE && !(et_PlayerName2.getText().toString().equals(""))){
                            joPlayerName.put("player2Name", et_PlayerName2.getText().toString());
                            joPlayerCurrentPos.put("player2CurrentPos", 0);
                        }
                        if (et_PlayerName3.getVisibility() == View.VISIBLE && !(et_PlayerName3.getText().toString().equals(""))) {
                            joPlayerName.put("player3Name", et_PlayerName3.getText().toString());
                            joPlayerCurrentPos.put("player3CurrentPos", 0);
                        }
                        if (et_PlayerName4.getVisibility() == View.VISIBLE && !(et_PlayerName4.getText().toString().equals(""))){
                            joPlayerName.put("player4Name", et_PlayerName4.getText().toString());
                            joPlayerCurrentPos.put("player4CurrentPos", 0);
                        }
                        if (et_PlayerName5.getVisibility() == View.VISIBLE && !(et_PlayerName5.getText().toString().equals(""))){
                            joPlayerName.put("player5Name", et_PlayerName5.getText().toString());
                            joPlayerCurrentPos.put("player5CurrentPos", 0);
                        }
                        if (et_PlayerName6.getVisibility() == View.VISIBLE && !(et_PlayerName6.getText().toString().equals(""))){
                            joPlayerName.put("player6Name", et_PlayerName6.getText().toString());
                            joPlayerCurrentPos.put("player6CurrentPos", 0);
                        }

                        joArrayPlayer.put(0, joDie);
                        joArrayPlayer.put(1, joPlayerName);
                        joArrayPlayer.put(2,joPlayerCurrentPos);
                        String jsonArrayString = joArrayPlayer.toString();
                        System.out.println(jsonArrayString);

                        File file = new File(getApplicationContext().getFilesDir(), "snake.json");
                        FileWriter fileWriter = new FileWriter(file);
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        bufferedWriter.write(jsonArrayString);
                        bufferedWriter.close();
                        openActivityPlay();
                    } else {
                        et_DieNumberNew.setError("Type 1-99");
                        et_DieSidesNew.setError("Type 1-99");
                    }
                } else {
                    et_DieNumberNew.setError("Type 1-99");
                    et_DieSidesNew.setError("Type 1-99");
                }
            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }
        });

        et_PlayerName1.setVisibility(View.GONE);
        et_PlayerName2.setVisibility(View.GONE);
        et_PlayerName3.setVisibility(View.GONE);
        et_PlayerName4.setVisibility(View.GONE);
        et_PlayerName5.setVisibility(View.GONE);
        et_PlayerName6.setVisibility(View.GONE);

        bt_addFirstPlayer2.setVisibility(View.GONE);
        bt_addFirstPlayer3.setVisibility(View.GONE);
        bt_addFirstPlayer4.setVisibility(View.GONE);
        bt_addFirstPlayer5.setVisibility(View.GONE);
        bt_addFirstPlayer6.setVisibility(View.GONE);

        iv_delete1.setVisibility(View.GONE);
        iv_delete2.setVisibility(View.GONE);
        iv_delete3.setVisibility(View.GONE);
        iv_delete4.setVisibility(View.GONE);
        iv_delete5.setVisibility(View.GONE);
        iv_delete6.setVisibility(View.GONE);

        bt_addFirstPlayer1.setOnClickListener(v -> {
            bt_addFirstPlayer1.setVisibility(View.GONE);
            bt_addFirstPlayer2.setVisibility(View.VISIBLE);
            et_PlayerName1.setVisibility(View.VISIBLE);
            iv_delete1.setVisibility(View.VISIBLE);
        });
        bt_addFirstPlayer2.setOnClickListener(v -> {
            bt_addFirstPlayer2.setVisibility(View.GONE);
            bt_addFirstPlayer3.setVisibility(View.VISIBLE);
            et_PlayerName2.setVisibility(View.VISIBLE);
            iv_delete2.setVisibility(View.VISIBLE);
        });
        bt_addFirstPlayer3.setOnClickListener(v -> {
            bt_addFirstPlayer3.setVisibility(View.GONE);
            bt_addFirstPlayer4.setVisibility(View.VISIBLE);
            et_PlayerName3.setVisibility(View.VISIBLE);
            iv_delete3.setVisibility(View.VISIBLE);
        });
        bt_addFirstPlayer4.setOnClickListener(v -> {
            bt_addFirstPlayer4.setVisibility(View.GONE);
            bt_addFirstPlayer5.setVisibility(View.VISIBLE);
            et_PlayerName4.setVisibility(View.VISIBLE);
            iv_delete4.setVisibility(View.VISIBLE);
        });
        bt_addFirstPlayer5.setOnClickListener(v -> {
            bt_addFirstPlayer5.setVisibility(View.GONE);
            bt_addFirstPlayer6.setVisibility(View.VISIBLE);
            et_PlayerName5.setVisibility(View.VISIBLE);
            iv_delete5.setVisibility(View.VISIBLE);
        });
        bt_addFirstPlayer6.setOnClickListener(v -> {
            bt_addFirstPlayer6.setVisibility(View.GONE);
            et_PlayerName6.setVisibility(View.VISIBLE);
            iv_delete6.setVisibility(View.VISIBLE);
        });

        iv_delete1.setOnClickListener(v -> {
            iv_delete1.setVisibility(View.GONE);
            et_PlayerName1.setVisibility(View.GONE);
            et_PlayerName1.setText("");
            bt_addFirstPlayer1.setVisibility(View.VISIBLE);
        });
        iv_delete2.setOnClickListener(v -> {
            iv_delete2.setVisibility(View.GONE);
            et_PlayerName2.setVisibility(View.GONE);
            et_PlayerName2.setText("");
            bt_addFirstPlayer2.setVisibility(View.VISIBLE);
        });
        iv_delete3.setOnClickListener(v -> {
            iv_delete3.setVisibility(View.GONE);
            et_PlayerName3.setVisibility(View.GONE);
            et_PlayerName3.setText("");
            bt_addFirstPlayer3.setVisibility(View.VISIBLE);
        });
        iv_delete4.setOnClickListener(v -> {
            iv_delete4.setVisibility(View.GONE);
            et_PlayerName4.setVisibility(View.GONE);
            et_PlayerName4.setText("");
            bt_addFirstPlayer4.setVisibility(View.VISIBLE);
        });
        iv_delete5.setOnClickListener(v -> {
            iv_delete5.setVisibility(View.GONE);
            et_PlayerName5.setVisibility(View.GONE);
            et_PlayerName5.setText("");
            bt_addFirstPlayer5.setVisibility(View.VISIBLE);
        });
        iv_delete6.setOnClickListener(v -> {
            iv_delete6.setVisibility(View.GONE);
            et_PlayerName6.setVisibility(View.GONE);
            et_PlayerName6.setText("");
            bt_addFirstPlayer6.setVisibility(View.VISIBLE);
        });
    }

    private void openActivityPlay() {
        Intent intent = new Intent(this, ActivityPlay.class);
        startActivity(intent);
    }
}