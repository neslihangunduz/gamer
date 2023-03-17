package org.turkcell;

public class PlayerPurchase {
    private final int gameId;
    private final double purcasedPrice;

    public PlayerPurchase(int gameId, double purcasedPrice) {
        this.gameId = gameId;
        this.purcasedPrice = purcasedPrice;
    }

    public int getGameId() {
        return gameId;
    }

    public double getPurcasedPrice() {
        return purcasedPrice;
    }

    @Override
    public String toString() {
        return "PlayerPurchase{" +
                "gameId=" + gameId +
                ", purcasedPrice=" + purcasedPrice +
                "}\n\t";
    }
}
