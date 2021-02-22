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
    Button bt_MoveRight,bt_MoveLeft,bt_MoveUp;
    ImageView iv_player1;

    Die die = new Die();

    int y1 = 1730;
    int y2 = 1730;

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
            tv_DieResult.setText("" + die.setDieRolledNumber());
            if (iv_player1.getX() < 983 && iv_player1.getY() == y1)
                iv_player1.setX(iv_player1.getX() + 108 * die.getDieRolledNumber());
            if (iv_player1.getX() == 983 && iv_player1.getY() == y1) {
                bt_MoveRight.setVisibility(View.GONE);
                bt_MoveUp.setVisibility(View.VISIBLE);
            }
            if (iv_player1.getX() == 1091 && iv_player1.getY() == y1) {
                iv_player1.setX(iv_player1.getX() - 108);
                iv_player1.setY(iv_player1.getY() - 175);
                y1 = y1 - 175;
                bt_MoveRight.setVisibility(View.GONE);
                bt_MoveLeft.setVisibility(View.VISIBLE);
            }
            if (iv_player1.getX() == 1199 && iv_player1.getY() == y1) {
                iv_player1.setX(iv_player1.getX() - 108 * 2);
                iv_player1.setY(iv_player1.getY() - 175);
                y1 = y1 - 175;
                bt_MoveRight.setVisibility(View.GONE);
                bt_MoveLeft.setVisibility(View.VISIBLE);
            }
            if (iv_player1.getX() == 1307 && iv_player1.getY() == y1) {
                iv_player1.setX(iv_player1.getX() - 108 * 3);
                iv_player1.setY(iv_player1.getY() - 175);
                y1 = y1 - 175;
                bt_MoveRight.setVisibility(View.GONE);
                bt_MoveLeft.setVisibility(View.VISIBLE);
            }
            if (iv_player1.getX() == 1415 && iv_player1.getY() == y1) {
                iv_player1.setX(iv_player1.getX() - 108 * 4);
                iv_player1.setY(iv_player1.getY() - 175);
                y1 = y1 - 175;
                bt_MoveRight.setVisibility(View.GONE);
                bt_MoveLeft.setVisibility(View.VISIBLE);
            }
            if (iv_player1.getX() == 1523 && iv_player1.getY() == y1) {
                iv_player1.setX(iv_player1.getX() - 108 * 5);
                iv_player1.setY(iv_player1.getY() - 175);
                y1 = y1 - 175;
                bt_MoveRight.setVisibility(View.GONE);
                bt_MoveLeft.setVisibility(View.VISIBLE);
            }
        });

        bt_MoveLeft.setOnClickListener(v -> {
            if (iv_player1.getX() > 11 && iv_player1.getY() == y1)
                iv_player1.setX(iv_player1.getX() - 108 * die.getDieRolledNumber());
            if (iv_player1.getX() == 11 && iv_player1.getY() == y1) {
                bt_MoveLeft.setVisibility(View.GONE);
                bt_MoveUp.setVisibility(View.VISIBLE);
            }
            if (iv_player1.getX() == -97 && iv_player1.getY() == y1) {
                iv_player1.setX(iv_player1.getX() + 108);
                iv_player1.setY(iv_player1.getY() - 175);
                y1 = y1 - 175;
                bt_MoveLeft.setVisibility(View.GONE);
                bt_MoveRight.setVisibility(View.VISIBLE);
            }
            if (iv_player1.getX() == -205 && iv_player1.getY() == y1) {
                iv_player1.setX(iv_player1.getX() + 108 * 2);
                iv_player1.setY(iv_player1.getY() - 175);
                y1 = y1 - 175;
                bt_MoveLeft.setVisibility(View.GONE);
                bt_MoveRight.setVisibility(View.VISIBLE);
            }
            if (iv_player1.getX() == -313 && iv_player1.getY() == y1) {
                iv_player1.setX(iv_player1.getX() + 108 * 3);
                iv_player1.setY(iv_player1.getY() - 175);
                y1 = y1 - 175;
                bt_MoveLeft.setVisibility(View.GONE);
                bt_MoveRight.setVisibility(View.VISIBLE);
            }
            if (iv_player1.getX() == -421 && iv_player1.getY() == y1) {
                iv_player1.setX(iv_player1.getX() + 108 * 4);
                iv_player1.setY(iv_player1.getY() - 175);
                y1 = y1 - 175;
                bt_MoveLeft.setVisibility(View.GONE);
                bt_MoveRight.setVisibility(View.VISIBLE);
            }
            if (iv_player1.getX() == -529 && iv_player1.getY() == y1) {
                iv_player1.setX(iv_player1.getX() + 108 * 5);
                iv_player1.setY(iv_player1.getY() - 175);
                y1 = y1 - 175;
                bt_MoveLeft.setVisibility(View.GONE);
                bt_MoveRight.setVisibility(View.VISIBLE);
            }
        });

        bt_MoveUp.setOnClickListener(v -> {
            if (iv_player1.getX() == 11 && iv_player1.getY() == 1730) {
                iv_player1.setY(iv_player1.getY() - 175);
                y1 = y1 - 175;
                bt_MoveUp.setVisibility(View.GONE);
                bt_MoveRight.setVisibility(View.VISIBLE);
            }
            if (iv_player1.getX() == 11 && iv_player1.getY() == 1555) {
                iv_player1.setY(iv_player1.getY() - 175*2);
                iv_player1.setX(iv_player1.getX() + 108 * 2);
                y1 = y1 - 175;
                bt_MoveUp.setVisibility(View.GONE);
                bt_MoveRight.setVisibility(View.VISIBLE);
            }
            if (iv_player1.getX() == 11 && iv_player1.getY() == 1380) {
                iv_player1.setY(iv_player1.getY() - 175*3);
                iv_player1.setX(iv_player1.getX() + 108 * 3);
                y1 = y1 - 175;
                bt_MoveUp.setVisibility(View.GONE);
                bt_MoveRight.setVisibility(View.VISIBLE);
            }
            if (iv_player1.getX() == 11 && iv_player1.getY() == 1205) {
                iv_player1.setY(iv_player1.getY() - 175*4);
                iv_player1.setX(iv_player1.getX() + 108 * 4);
                y1 = y1 - 175;
                bt_MoveUp.setVisibility(View.GONE);
                bt_MoveRight.setVisibility(View.VISIBLE);
            }
            if (iv_player1.getX() == 11 && iv_player1.getY() == 1030) {
                iv_player1.setY(iv_player1.getY() - 175*5);
                iv_player1.setX(iv_player1.getX() + 108 * 5);
                y1 = y1 - 175;
                bt_MoveUp.setVisibility(View.GONE);
                bt_MoveRight.setVisibility(View.VISIBLE);
            }


            if (iv_player1.getX() == 983 && iv_player1.getY() == 1730) {
                iv_player1.setY(iv_player1.getY() - 175);
                y1 = y1 - 175;
                bt_MoveUp.setVisibility(View.GONE);
                bt_MoveLeft.setVisibility(View.VISIBLE);
            }
            if (iv_player1.getX() == 983 && iv_player1.getY() == 1555) {
                iv_player1.setY(iv_player1.getY() - 175*2);
                iv_player1.setX(iv_player1.getX() + 108 * 2);
                y1 = y1 - 175;
                bt_MoveUp.setVisibility(View.GONE);
                bt_MoveLeft.setVisibility(View.VISIBLE);
            }
            if (iv_player1.getX() == 983 && iv_player1.getY() == 1380) {
                iv_player1.setY(iv_player1.getY() - 175*3);
                iv_player1.setX(iv_player1.getX() + 108 * 3);
                y1 = y1 - 175;
                bt_MoveUp.setVisibility(View.GONE);
                bt_MoveLeft.setVisibility(View.VISIBLE);
            }
            if (iv_player1.getX() == 983 && iv_player1.getY() == 1205) {
                iv_player1.setY(iv_player1.getY() - 175*4);
                iv_player1.setX(iv_player1.getX() + 108 * 4);
                y1 = y1 - 175;
                bt_MoveUp.setVisibility(View.GONE);
                bt_MoveLeft.setVisibility(View.VISIBLE);
            }
            if (iv_player1.getX() == 983 && iv_player1.getY() == 1030) {
                iv_player1.setY(iv_player1.getY() - 175*5);
                iv_player1.setX(iv_player1.getX() + 108 * 5);
                y1 = y1 - 175;
                bt_MoveUp.setVisibility(View.GONE);
                bt_MoveLeft.setVisibility(View.VISIBLE);
            }
        });

        bt_MoveLeft.setVisibility(View.GONE);
        bt_MoveUp.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, ActivityMain.class);
        startActivity(intent);
    }
}