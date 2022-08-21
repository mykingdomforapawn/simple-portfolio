package com.mykingdomforapawn.simpleportfolio;

public class Position {
    private String ticker;
    private double shares;
    private int price;

    public Position(String ticker, double shares, int price) {
        this.ticker =  ticker;
        this.shares = shares;
        this.price = price;
    }

    public String toString() {
        return "\nTicker: " + ticker + " | Shares: " + shares + " | Price: " + price;
    }

    public double getShares() {
        return shares;
    }

    public void setShares(double shares) {
        this.shares = shares;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
