package com.mykingdomforapawn.simpleportfolio;

import java.util.ArrayList;

public class Position {
    private final String ticker;
    private double shares;
    private double price;
    private static ArrayList<String> tickerRegistry = new ArrayList<>();

    public Position(String ticker, double shares, int price) {
        this.ticker =  ticker;
        this.shares = shares;
        this.price = price;
    }

    public String toString() {
        return "\nTicker: " + ticker + " | Shares: " + shares + " | Price: " + price;
    }

    public Position mergePositions (Position position) {
        this.shares += position.getShares();
        this.price = (this.price * this.shares
                     + position.getPrice() * position.getShares())
                     / (this.shares + position.shares);
        return this;
    }

    public Position subtractPosition (Position position) {
        this.shares -= position.getShares();
        return this;
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

    public String getTicker() {
        return ticker;
    }

    public double getPrice() {
        return price;
    }
}
