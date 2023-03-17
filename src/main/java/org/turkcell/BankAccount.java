package org.turkcell;

public class BankAccount {
    private double wallet;

    public BankAccount(double wallet) {
        this.wallet = wallet;
    }

    public boolean withdraw(double amount){
        if(wallet<amount){
            System.out.println(amount + " ₺ çekilemedi. Yetersiz bakiye. Bakiye durumu: " + getWallet() + " ₺");
            return false;
        }
        else{
            setWallet(wallet-amount);
            System.out.println("Para çekildi: " + amount + " ₺. Mevcut bakiye: " + getWallet() + " ₺");
            return true;
        }
    }

    public void deposit(double amount){
        this.wallet += amount;
        System.out.println("Para yatırıldı: " + amount + " ₺");
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "wallet=" + wallet + " ₺"+
                '}';
    }
}
