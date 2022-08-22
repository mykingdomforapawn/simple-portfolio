package com.mykingdomforapawn.simpleportfolio;

import java.util.ArrayList;

public class Position {
    private String ticker;
    private double shares;
    private double price;
    private static ArrayList<String> tickerRegistry;
    private int portfolioValue;

    public Position(String ticker, double shares, int price) {
        this.ticker =  ticker;
        this.shares = shares;
        this.price = price;
    }

    public String toString() {
        return "\nTicker: " + ticker + " | Shares: " + shares + " | Price: " + price;
    }

    public static ArrayList<String> getTickerRegistry() {
        return tickerRegistry;
    }

    public static void setTickerRegistry(ArrayList<String> tickerRegistry) {
        Position.tickerRegistry = tickerRegistry;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
