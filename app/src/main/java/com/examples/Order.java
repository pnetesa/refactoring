package com.examples;

public class Order {

    private double mAmount;
    private double mBasePrice;

    public Order() {
    }

    public Order(double amount) {
        mAmount = amount;
    }

    public double getAmount() {
        return mAmount;
    }

    public void setAmount(double amount) {
        amount = amount;
    }

    public double getBasePrice() {
        return mBasePrice;
    }

    public void setBasePrice(double basePrice) {
        mBasePrice = basePrice;
    }
}
