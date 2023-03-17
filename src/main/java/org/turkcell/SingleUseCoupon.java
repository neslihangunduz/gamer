package org.turkcell;

public class SingleUseCoupon extends Coupon{
    public SingleUseCoupon(String code, double discount){
        super(code, discount, 1);
    }
}