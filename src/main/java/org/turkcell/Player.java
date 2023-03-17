package org.turkcell;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Player extends User{
    private String nickname; // primitive

    private ArrayList<Game> games = new ArrayList<>();
    private ArrayList<PlayerPurchase> purchases = new ArrayList<>();

    public Player(String nickname, String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    public ArrayList<PlayerPurchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(ArrayList<PlayerPurchase> purchases) {
        this.purchases = purchases;
    }

    @Override
    public String toString() {
        return "Player{" +
                "nickname='" + nickname +
                ", games=" + games +
                ", purchases=" + purchases+
                '}';
    }
}
