package org.turkcell;

public class Main {
    public static void main(String[] args) {
        AuthenticationManager authenticationManager = new AuthenticationManager();
        Coupon singleUseCoupon = PayManager.coupons[0];
        Coupon multipleUseCoupon = PayManager.coupons[1];
        System.out.println("============================================================");


        // Player ve Müşteri Oluşturma
        Player player1 = new Player("endo", "Engin", "Demirog", "engin.demirog@turkcell.com.tr", "password1");
        Player player2 = new Player("endo", "Engin", "Demirog", "engin.demirog@turkcell.com.tr", "password1");
        Customer customer1 = new Customer("12345678901", new BankAccount(750), 2000, "Mert", "Deniz", "mert.deniz@turkcell.com.tr", "password2");
        System.out.println("============================================================");


        // Kayıt olma
        authenticationManager.register(player1);
        authenticationManager.register(customer1);
        authenticationManager.register(player2);
        System.out.println("Kullanıcı sayısı: " + authenticationManager.getUserCount());
        System.out.println("============================================================");


        // Kullanıcı silme
        authenticationManager.deleteUser(player2);
        System.out.println("Kullanıcı sayısı: " + authenticationManager.getUserCount());
        System.out.println("============================================================");


        // Vatandaş kontrolü
        /*boolean isCitizen = EDevletAPI.verifyIfCitizen(customer1);
        System.out.println(isCitizen? "Vatandaş": "Vatandaş değil");*/


        // Oyun oluşturma
        Game game1 = new Game("GTA V", 276.00);
        Game game2 = new Game("Total War: WARHAMMER III", 401.33);
        Game game3 = new Game("Cyberpunk 2077", 249.50);
        Game game4 = new Game("RUST", 206.36);

        System.out.println("============================================================");
        PayManager.buyGame(customer1, player1, game1, singleUseCoupon);
        System.out.println("============================================================");
        PayManager.buyGame(customer1, player1, game2, singleUseCoupon);
        System.out.println("============================================================");
        PayManager.buyGame(customer1, player1, game3, multipleUseCoupon);
        System.out.println("============================================================");
        PayManager.sellGame(customer1, player1, game1);
        System.out.println("============================================================");
        PayManager.buyGame(customer1, player1, game4 );
        System.out.println("============================================================");

        System.out.println(customer1);
        System.out.println("============================================================");
        System.out.println(player1);
        System.out.println("============================================================");

         /*User[] users = {player1, customer1};
        for(User user: users){
            System.out.println(user.toString());
        }*/
    }
}