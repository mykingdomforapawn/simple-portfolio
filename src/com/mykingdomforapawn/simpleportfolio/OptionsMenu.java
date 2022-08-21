package com.mykingdomforapawn.simpleportfolio;

import java.text.DecimalFormat;
import java.util.Scanner;

public class OptionsMenu {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    int selection;
    double amount;
    int price;
    String ticker;

    public void getAccountType(Account account) {
        boolean loopVariable = true;

        do {
            try {
                System.out.println("\nWelcome to the Simple Portfolio project!");
                System.out.println("\nSelect the account you want to access: ");
                System.out.println("Type 1 - Saving account");
                System.out.println("Type 2 - Portfolio account");
                System.out.println("Type 3 - Quit application");
                System.out.print("Your choice: ");
                selection = menuInput.nextInt();
            } catch (Exception e) {
                System.out.println("\nInvalid character(s). Try again.");
                menuInput = new Scanner(System.in);
                continue;
            }
            switch (selection) {
                case 1 -> this.getSavingAccount(account);
                case 2 -> this.getPortfolio(account);
                case 3 -> {
                    System.out.println("\nSuccessfully quit application!");
                    loopVariable = false;
                }
                default -> System.out.println("\nInvalid Choice. Try again.");
            }
        } while (loopVariable);
    }

    private void getSavingAccount(Account account) {
        boolean loopVariable = true;

        do {
            try {
                System.out.println("\nSaving account options: ");
                System.out.println("Type 1 - View balance");
                System.out.println("Type 2 - Deposit funds");
                System.out.println("Type 3 - Withdraw funds");
                System.out.println("Type 4 - Exit saving account");
                System.out.print("Your choice: ");
                selection = menuInput.nextInt();
            } catch (Exception e) {
                System.out.println("\nInvalid character(s). Try again.");
                menuInput = new Scanner(System.in);
                continue;
            }
            switch (selection) {
                case 1 ->
                        System.out.println("\nSaving account balance: " + moneyFormat.format(account.getSavingBalance()));
                case 2 -> this.getSavingDepositInput(account);
                case 3 -> this.getSavingWithdrawInput(account);
                case 4 -> {
                    System.out.println("\nSuccessfully exited saving account!");
                    loopVariable = false;
                }
                default -> System.out.println("\nInvalid Choice. Try again.");
            }
        } while (loopVariable);
    }

    private void getSavingDepositInput(Account account) {
        boolean loopVariable = true;

        do {
            try {
                System.out.println("\nSaving account balance: " + moneyFormat.format(account.getSavingBalance()));
                System.out.print("Amount you want to deposit to saving account: ");
                amount = menuInput.nextDouble();
            } catch (Exception e) {
                System.out.println("\nInvalid character(s). Try again.");
                menuInput = new Scanner(System.in);
                continue;
            }
            account.depositFunds(amount);
            System.out.println("\nNew saving account balance: " + moneyFormat.format(account.getSavingBalance()));
            loopVariable = false;
        } while (loopVariable);
    }

    private void getSavingWithdrawInput(Account account) {
        boolean loopVariable = true;

        do {
            try {
                System.out.println("\nSaving account balance: " + moneyFormat.format(account.getSavingBalance()));
                System.out.print("Amount you want to withdraw from saving account: ");
                amount = menuInput.nextDouble();
            } catch (Exception e) {
                System.out.println("\nInvalid character(s). Try again.");
                menuInput = new Scanner(System.in);
                continue;
            }
            account.withdrawFunds(amount);
            System.out.println("\nNew saving account balance: " + moneyFormat.format(account.getSavingBalance()));
            loopVariable = false;
        } while (loopVariable);
    }

    private void getPortfolio(Account account) {
        boolean loopVariable = true;

        do {
            try {
                System.out.println("\nPortfolio account options: ");
                System.out.println("Type 1 - View summary");
                System.out.println("Type 2 - Open position");
                System.out.println("Type 3 - Close position");
                System.out.println("Type 4 - Exit portfolio account");
                System.out.print("Your choice: ");
                selection = menuInput.nextInt();
            } catch (Exception e) {
                System.out.println("\nInvalid character(s). Try again.");
                menuInput = new Scanner(System.in);
                continue;
            }
            switch (selection) {
                case 1 -> account.displayPortfolio();
                case 2 -> this.getPortfolioOpenInput(account);
                case 3 -> this.getSavingWithdrawInput(account);
                case 4 -> {
                    System.out.println("\nSuccessfully exited saving account!");
                    loopVariable = false;
                }
                default -> System.out.println("\nInvalid Choice. Try again.");
            }
        } while (loopVariable);
    }

    private void getPortfolioOpenInput(Account account) {
        boolean loopVariable = true;

        do {
            try {
                System.out.print("Ticker you want to Buy: ");
                ticker = menuInput.next();
                System.out.print("Number of shares you want to buy: ");
                amount = menuInput.nextInt();
                System.out.print("Price per share: ");
                price = menuInput.nextInt();
            } catch (Exception e) {
                System.out.println("\nInvalid character(s). Try again.");
                menuInput = new Scanner(System.in);
                continue;
            }
            account.openPosition(new Position(ticker, amount, price));
            loopVariable = false;
        } while (loopVariable);
    }

    private void getPortfolioCloseInput(Account account) {

    }
}


