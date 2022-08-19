package com.mykingdomforapawn.simpleportfolio;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionsMenu {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    int selection;
    double amount;
    HashMap<Integer, Integer> credentials = new HashMap<>();

    public void getStartMenu() {
        boolean loopVariable = true;

        do {
            try {
                System.out.println("\nWelcome to the Simple Portfolio project!");
                System.out.println("Select one of the options below: ");
                System.out.println("Type 1 - Login");
                System.out.println("Type 2 - Quit application");
                System.out.println("Your choice: ");
                selection = menuInput.nextInt();
            } catch (Exception e) {
                System.out.println("\nInvalid character(s). Try again.");
                menuInput = new Scanner(System.in);
                continue;
            }
            switch (selection) {
                case 1 -> this.getLogin();
                case 2 -> {
                    System.out.println("\nSuccessfully quit application!");
                    loopVariable = false;
                }
                default -> System.out.println("\nInvalid Choice. Try again.");
            }
        } while (loopVariable);
    }

    public void getLogin() {
        boolean loopVariable = true;
        Account account = new Account();

        do {
                try {
                    credentials.put(3366,4477);
                    System.out.println("\nWelcome to the login page!");
                    System.out.println("Enter your username: ");
                    account.setUsername(menuInput.nextInt());
                    System.out.println("Enter your password: ");
                    account.setPassword(menuInput.nextInt());
                } catch (Exception e) {
                    System.out.println("\nInvalid character(s). Try again.");
                    menuInput = new Scanner(System.in);
                    continue;
                }
                for (Entry<Integer, Integer> entry : credentials.entrySet()) {
                    if (entry.getKey() == account.getUsername() && entry.getValue() == account.getPassword()) {
                        System.out.println("\nSuccessfully logged in!");
                        this.getAccountType(account);
                    }
                }
                loopVariable = false;
        } while (loopVariable);
    }

    public void getAccountType(Account account) {
        boolean loopVariable = true;

        do {
            try {
                System.out.println("\nSelect the account you want to access: ");
                System.out.println("Type 1 - Saving account");
                System.out.println("Type 2 - Portfolio account");
                System.out.println("Type 3 - Logout");
                System.out.print("Your choice: ");
                selection = menuInput.nextInt();
            } catch (Exception e) {
                System.out.println("\nInvalid character(s). Try again.");
                menuInput = new Scanner(System.in);
                continue;
            }
            switch (selection) {
                case 1 -> this.getSavingAccount(account);
                //case 2 -> this.getPortfolio(account);
                case 3 -> {
                    System.out.println("\nSuccessfully logged out!");
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
}
