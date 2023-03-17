package org.turkcell;

public abstract class Coupon {
    private final String code;
    private final double discount;
    private boolean consumed;
    private int quantity;

    public Coupon(String code, double discount,int quantity) {
        this.code = code;
        this.discount = discount;
        this.consumed = quantity<1;
        this.quantity = quantity;
    }

    public boolean useCoupon(){
        if(consumed){
            System.out.println("Kupon(" +getCode() + ") tükendi.");
            return false;
        }

        --quantity;
        System.out.println("Kupon(" +getCode() + ") kullanıldı.");
        if(quantity == 0){
            consumed = true;
            System.out.println("Kupon(" + getCode()+ ") bitmiştir.");
        }

        return true;
    }

    public double getDiscount() {
        return discount;
    }

    public boolean isConsumed() {
        return consumed;
    }

    public void setConsumed(boolean consumed) {
        this.consumed = consumed;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "code='" + code + '\'' +
                ", discount=" + discount +
                ", consumed=" + consumed +
                ", quantity=" + quantity +
                '}';
    }
}

