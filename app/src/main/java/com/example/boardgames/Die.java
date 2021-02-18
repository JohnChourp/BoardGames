package com.example.boardgames;

import java.util.Random;

public class Die {
    private final Random dieRand = new Random(System.currentTimeMillis());
    public static int dieNumber;
    private int dieRolledNumber;

    public int setDieRolledNumber() {
        dieRolledNumber = dieRand.nextInt(dieNumber * 6) + 1;
        return dieRolledNumber;
    }

    public int getDieRolledNumber() {
        return dieRolledNumber;
    }
}
