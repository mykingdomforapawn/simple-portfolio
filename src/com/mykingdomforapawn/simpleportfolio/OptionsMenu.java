package com.mykingdomforapawn.simpleportfolio;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionsMenu {
    Scanner menuInput = new Scanner(System.in);
    int selection;
    HashMap<Integer, Integer> credentials = new HashMap<Integer, Integer>();

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
                System.out.println("\nInvalid character(s). Only numbers.");
                loopVariable = false;
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
                    System.out.println("\nInvalid character(s). Only numbers.");
                    loopVariable = false;
                }
                for (Entry<Integer, Integer> entry : credentials.entrySet()) {
                    if (entry.getKey() == account.getUsername() && entry.getValue() == account.getPassword()) {
                        System.out.println("\nSuccessfully logged in!");
                        this.getAccountType(account);
                    }
                }
        } while (loopVariable);
    }

    public void getAccountType(Account account) {
        boolean loopVariable = true;

        do {
            try {
                System.out.println("\nSelect the account you want to access: ");
                System.out.println("Type 1 - Checking account");
                System.out.println("Type 2 - Saving account");
                System.out.println("Type 3 - Logout");
                System.out.print("Your choice: ");
                selection = menuInput.nextInt();
            } catch (Exception e) {
                System.out.println("\nInvalid character(s). Only numbers.");
                loopVariable = false;
            }
            switch (selection) {
                case 1:
                    //getChecking();
                    break;
                case 2:
                    //getSaving();
                    break;
                case 3:
                    System.out.println("\nSuccessfully logged out!");
                    this.getLogin();
                    break;
                default:
                    System.out.println("\nInvalid Choice. Try again.");
                    break;
            }
        } while (loopVariable);
    }
}
