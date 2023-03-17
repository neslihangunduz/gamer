package org.turkcell;

public class PayManager {

    public static Coupon[] coupons = {
            new SingleUseCoupon("X21AS51", .25),
            new MultipleUseCoupon("YXHUSS2", .15, 10),
    };

    public static boolean buyGame(Customer customer, Player player, Game game){
        return _buyGame(customer, player, game, game.getPrice());
    }
    public static boolean buyGame(Customer customer, Player player, Game game, Coupon coupon){
        double price = game.getPrice() * (
                1 - (coupon.isConsumed()? 0: coupon.getDiscount())
            );

        System.out.println(
                coupon.isConsumed()?
                        "Kupon tükendi. Fiyat: " + game.getPrice():
                        "Kupon uygulandı. Fiyat: " + game.getPrice()+ " ₺ -> " + price + " ₺"
        );

        final boolean isBought =  _buyGame(customer, player, game, price);
        if(isBought){
            coupon.useCoupon();
        }
        return isBought;
    }

    private static boolean _buyGame(Customer customer, Player player, Game game, double price){
        boolean paid = customer.getBankAccount().withdraw(price);
        if(!paid){
            System.out.println("Oyun alınamadı!");
            return false;
        }

        System.out.println("Oyun alındı");
        PlayerManager.addGameToPlayer(player, game, price);
        return true;
    }

    public static boolean sellGame(Customer customer, Player player, Game game){
        if(!PlayerManager.hasGame(player, game)) return false;

        var purchases = player.getPurchases();
        for(int i=0, len=purchases.size(); i<len; i++){
            if(purchases.get(i).getGameId() == game.getId()){

                // parayı hesaba yatır
                final double price = purchases.get(i).getPurcasedPrice();
                customer.getBankAccount().deposit(price);

                // purcase çıkar
                purchases.remove(i);
                System.out.println("Oyun satıldı ve hesaba " + price + " ₺ eklendi.");
                break;
            }
        }

        PlayerManager.removeGameToPlayer(player, game);

        return true;
    }
}
