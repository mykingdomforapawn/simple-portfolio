package com.mykingdomforapawn.simpleportfolio;


import java.text.DecimalFormat;
import java.util.ArrayList;

public class Account {
    private double savingBalance;
    final private ArrayList<Position> portfolio;
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    public Account() {
        savingBalance = 0;
        portfolio = new ArrayList<>();
    }

    public void displayPortfolio() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Position position:portfolio) {
            stringBuilder.append(position.toString());
        }

        if (stringBuilder.length() == 0) {
            System.out.println("\nThere are no open positions in your portfolio.");
        } else {
            System.out.println(stringBuilder);
        }
    }

    public void openPosition (Position position) {
        ArrayList<String> tickerRegistry = Position.getTickerRegistry();
        String ticker = position.getTicker();

        if (this.savingBalance >= position.getShares() * position.getPrice()) {
            this.savingBalance -= position.getShares() * position.getPrice();

            if (tickerRegistry.contains(ticker)) {
                int tickerRegistryPosition = tickerRegistry.indexOf(ticker);
                Position existingPosition = this.portfolio.get(tickerRegistryPosition);
                this.portfolio.set(tickerRegistryPosition, existingPosition.mergePositions(position));
            } else {
                tickerRegistry.add(position.getTicker());
                Position.setTickerRegistry(tickerRegistry);
                this.portfolio.add(position);
            }
        } else {
            System.out.println("\nThere are not enough funds in your saving account.");
        }
    }

    public void closePosition (Position position) {
        ArrayList<String> tickerRegistry = Position.getTickerRegistry();
        String ticker = position.getTicker();

        if (tickerRegistry.contains(ticker)) {
            int tickerRegistryPosition = tickerRegistry.indexOf(ticker);
            Position existingPosition = this.portfolio.get(tickerRegistryPosition);

            if (existingPosition.getShares() >= position.getShares()) {
                double returnOnInvestment;
                returnOnInvestment = (position.getPrice() - existingPosition.getPrice()) * position.getShares();
                System.out.println("\nYour return on investment was: " + moneyFormat.format(returnOnInvestment));

                if (existingPosition.getShares() == position.getShares()) {
                    this.portfolio.remove(tickerRegistryPosition);
                } else {
                    this.portfolio.set(tickerRegistryPosition, existingPosition.subtractPosition(position));
                }

            } else {
                System.out.println("\nThere are not enough shares in this position.");
            }

        } else {
            System.out.println("\nThere is no position with that ticker in your portfolio.");
        }
        // subtract shares, if shares zero, delete position
        // calculate return and display on screen
        // add return to saving account
    }

    public void depositFunds(double amount) {
        if (amount >= 0) {
            this.setSavingBalance(this.getSavingBalance() + amount);
            System.out.println("\nDeposit successful!");
        } else {
            System.out.println("\nDeposit not successful! The amount cannot be negative.");
        }
    }

    public void withdrawFunds(double amount) {
        if (amount >= 0) {
            if (amount <= this.getSavingBalance()) {
                this.setSavingBalance(this.getSavingBalance() - amount);
                System.out.println("\nWithdraw successful!");
            } else {
                System.out.println("\nWithdraw not successful! Not enough funds in the account.");
            }
        } else {
            System.out.println("\nWithdraw not successful! The amount cannot be negative.");
        }
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }
}
