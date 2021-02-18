package com.example.boardgames;

import java.util.Random;

public class Die {

    private int dieNumber = 1;
    private int dieRolledNumber;
    private final Random dieRand = new Random(System.currentTimeMillis());

    public int rollDie() {
        dieRolledNumber = dieRand.nextInt(dieNumber * 6) + 1;
        return dieRolledNumber;
    }

    public int getDieNumber() {
        return dieNumber;
    }

    public void setDieNumber(int dieNumber) {
        this.dieNumber = dieNumber;
    }

    public int getDieRolledNumber() {
        return dieRolledNumber;
    }

    public void setDieRolledNumber(int dieRolledNumber) {
        this.dieRolledNumber = dieRolledNumber;
    }

    public Random getDieRand() {
        return dieRand;
    }
}
