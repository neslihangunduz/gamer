package org.turkcell;

import java.util.ArrayList;

public class PlayerManager {

    static void addGameToPlayer(Player player, Game game, double priceWithDiscount){

        // oyun ekle
        ArrayList<Game> games = player.getGames();
        games.add(game);

        // satın alma fiyatı ekle
        ArrayList<PlayerPurchase> purchases = player.getPurchases();
        purchases.add(new PlayerPurchase(game.getId(), priceWithDiscount));

        System.out.println("Oyun ve fatura player'a eklendi.");
    }

    static void removeGameToPlayer(Player player, Game game){
        ArrayList<Game> games = player.getGames();
        for(int i=0, len=games.size(); i<len; i++){
            if(games.get(i).getId() == game.getId()){
                games.remove(i);
                System.out.println("Oyun player'dan çıkartıldı.");
                break;
            }
        }
    }

    static boolean hasGame(Player player, Game game){
        for(Game game2: player.getGames()){
            if(game2.getId() == game.getId()){
                System.out.println("Satılmak istenen oyun("+game.getId()+") player(" + player.getId()+")'da bulundu.");
                return true;
            }
        }
        System.out.println("Satılmak istenen oyun("+game.getId()+") player(" + player.getId()+")'da bulunamadı...");
        return false;
    }
}