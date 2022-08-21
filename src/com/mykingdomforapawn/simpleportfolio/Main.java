package com.mykingdomforapawn.simpleportfolio;

public class Main {
    public static void main(String[] args) {
        OptionsMenu optionsMenu = new OptionsMenu();
        Account account = new Account();

        optionsMenu.getAccountType(account);
    }
}
