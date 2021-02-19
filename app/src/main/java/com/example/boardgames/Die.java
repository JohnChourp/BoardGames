package com.example.boardgames;

import java.util.Random;

public class Die{

    private int dieNumber;
    private int dieSides;
    private int dieRolledNumber;

    public int getDieNumber() {
        return dieNumber;
    }

    public void setDieNumber(int dieNumber) {
        this.dieNumber = dieNumber;
    }

    public int getDieSides() {
        return dieSides;
    }

    public void setDieSides(int dieSides) {
        this.dieSides = dieSides;
    }

    public int setDieRolledNumber() {
        Random dieRand = new Random();
        int dieBound = dieNumber*dieSides;
        dieRolledNumber = dieRand.nextInt(dieBound) + 1;
        return dieRolledNumber;
    }

    public int getDieRolledNumber() {
        return dieRolledNumber;
    }
}
