package com.example.boardgames;

import java.util.ArrayList;
import java.util.List;

public class PlayerList {

    private final List<Player> playerList = new ArrayList<>();
    private int currentPlayerNumber = 0;

    public void setPlayer(Player playerToAdd) {
        playerList.add(playerToAdd);
    }

    public void setNextPlayer() {
        currentPlayerNumber = (currentPlayerNumber + 1) % playerList.size();
    }

    public Player getCurrentPlayer() {
        return playerList.get(currentPlayerNumber);
    }

    public int getCurrentPlayerNumber() {
        return currentPlayerNumber;
    }

    public void setCurrentPlayerNumber(int currentPlayer) {
        this.currentPlayerNumber = currentPlayer;
    }

    public Player getPlayer(int playerNumber) {
        return playerList.get(playerNumber);
    }

    public int getPlayerPos(int playerNumber) {
        return getPlayer(playerNumber).getCurrentPos();
    }

    public int getCurrentPlayerPos() {
        return getCurrentPlayer().getCurrentPos();
    }

    public void setPlayerPos(int playerNumber, int sendPlayerTo) {
        playerList.get(playerNumber).setCurrentPos(sendPlayerTo);
    }

    public int getPlayerListSize() {
        return playerList.size();
    }
}
