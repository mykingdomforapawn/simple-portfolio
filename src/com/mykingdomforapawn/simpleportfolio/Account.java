package com.mykingdomforapawn.simpleportfolio;


import java.util.ArrayList;

public class Account {
    private double savingBalance;
    final private ArrayList<Position> portfolio;

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
        this.portfolio.add(position);
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
