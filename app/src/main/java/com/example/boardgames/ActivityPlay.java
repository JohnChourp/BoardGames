package com.example.boardgames;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ActivityPlay extends AppCompatActivity {

    TextView tv_DieResult;
    Button bt_MoveRight, bt_MoveLeft, bt_MoveUp;
    ImageView iv_player1;

    Die die = new Die();

    int yStart = 1730;
    int yEnd = 155;
    int xStart = 11;
    int xEnd = 983;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        tv_DieResult = findViewById(R.id.tv_DieResult);
        iv_player1 = findViewById(R.id.iv_player1);
        bt_MoveRight = findViewById(R.id.bt_MoveRight);
        bt_MoveLeft = findViewById(R.id.bt_MoveLeft);
        bt_MoveUp = findViewById(R.id.bt_MoveUp);

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

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        bt_MoveRight.setOnClickListener(v -> {
            iv_player1.setX(iv_player1.getX() + (108 * die.getDieRolledNumber()));

            if (iv_player1.getX() == xEnd) {
                bt_MoveRight.setVisibility(View.GONE);
                bt_MoveUp.setVisibility(View.VISIBLE);
            }

            if (iv_player1.getX() > xEnd) {
                iv_player1.setY(iv_player1.getY() - 175);
                float temp = iv_player1.getX();
                iv_player1.setX(xEnd);
                temp = iv_player1.getX() - (108 * (((temp - iv_player1.getX()) / 108) - 1));

                iv_player1.setX(temp);
                bt_MoveRight.setVisibility(View.GONE);
                bt_MoveLeft.setVisibility(View.VISIBLE);
            }

            tv_DieResult.setText("" + die.setDieRolledNumber());
        });

        bt_MoveUp.setOnClickListener(v -> {
            iv_player1.setY(iv_player1.getY() - 175);

            if (iv_player1.getX() == xEnd) {
                iv_player1.setX(iv_player1.getX() - (108 * die.getDieRolledNumber() - 1));

                bt_MoveUp.setVisibility(View.GONE);
                bt_MoveLeft.setVisibility(View.VISIBLE);
            }
            if (iv_player1.getX() == xStart) {
                iv_player1.setX(iv_player1.getX() + (108 * die.getDieRolledNumber() - 1));

                bt_MoveUp.setVisibility(View.GONE);
                bt_MoveRight.setVisibility(View.VISIBLE);
            }
            tv_DieResult.setText("" + die.setDieRolledNumber());
            bt_MoveUp.setVisibility(View.GONE);
        });

        bt_MoveLeft.setOnClickListener(v -> {
            iv_player1.setX(iv_player1.getX() - (108 * die.getDieRolledNumber()));

            if (iv_player1.getX() == xStart) {
                bt_MoveLeft.setVisibility(View.GONE);
                bt_MoveUp.setVisibility(View.VISIBLE);
            }

            if (iv_player1.getX() < xStart) {
                iv_player1.setY(iv_player1.getY() - 175);
                float temp = iv_player1.getX();
                iv_player1.setX(xStart);
                temp = iv_player1.getX() + (108 * ((((temp - iv_player1.getX()) * (-1)) / 108) - 1));

                iv_player1.setX(temp);

                bt_MoveLeft.setVisibility(View.GONE);
                bt_MoveRight.setVisibility(View.VISIBLE);
            }

            if (iv_player1.getY() < yEnd) {
                iv_player1.setX(xStart);
                iv_player1.setY(yEnd);
                bt_MoveLeft.setVisibility(View.GONE);
                bt_MoveRight.setVisibility(View.GONE);
                bt_MoveUp.setVisibility(View.GONE);
                Toast.makeText(this, "!!!You Won!!!", Toast.LENGTH_SHORT).show();
            }
            tv_DieResult.setText("" + die.setDieRolledNumber());
        });

        bt_MoveUp.setVisibility(View.GONE);
        bt_MoveLeft.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, ActivityMain.class);
        startActivity(intent);
    }
}