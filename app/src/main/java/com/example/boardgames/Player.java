package com.example.boardgames;

public class Player {

    private String name;
    private int currentPos;
    private boolean lostTurn;
    private boolean canPlayAtStart;
    private boolean hasImmunity;
    private int round;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }

    public boolean isLostTurn() {
        return lostTurn;
    }

    public void setLostTurn(boolean lostTurn) {
        this.lostTurn = lostTurn;
    }

    public boolean isCanPlayAtStart() {
        return canPlayAtStart;
    }

    public void setCanPlayAtStart(boolean canPlayAtStart) {
        this.canPlayAtStart = canPlayAtStart;
    }

    public boolean isHasImmunity() {
        return hasImmunity;
    }

    public void setHasImmunity(boolean hasImmunity) {
        this.hasImmunity = hasImmunity;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round + 1;
    }
}