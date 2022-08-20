package com.mykingdomforapawn.simpleportfolio;


import java.util.List;

public class Account {
    private int username;
    private int password;
    private double savingBalance;
    private List<Position> portfolio;

    public Account() {
        savingBalance = 0;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public List<Position> getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(List<Position> portfolio) {
        this.portfolio = portfolio;
    }

    public String printPortfolio () {
        return "Hello There!";
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
}
