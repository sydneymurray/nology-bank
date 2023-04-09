package org.example;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankInService {
    private static Customer loggedInCustomer = null;
    private static ArrayList<Account> customerAccounts = new ArrayList<Account>();
    private static Scanner keyboardInput = new Scanner(System.in);
    private static int selection = 0;

    public static void inService() {
        while (true) {
            if (loggedInCustomer == null) displayLoggedOutMenu();
            else displayLoggedinMenu();
        }
    }

    private static void displayLoggedOutMenu() {
        System.out.println("\n\n     Welcome to Syd-Bank. Please select an option: ");
        System.out.println("\n    1) Sign Up: ");
        System.out.println("\n    2) Login");
        try {
            selection = keyboardInput.nextInt();
        } catch (InputMismatchException e) {
            //e.printStackTrace();
            System.out.println("\nIncorrect selection");
            return;
        }
        switch (selection) {
            case 1:
                RegisterACustomer.RegisterACustomer();
                break;
            case 2:
                LoginCustomer.LoginCustomer();
                break;
            default:
                // code block
        }
    }

    private static void displayLoggedinMenu() {
        customerAccounts = FinancialInformation.getCustomerAccounts(loggedInCustomer);
        System.out.println("\n\n     Welcome " + loggedInCustomer.getUsername() + ". Please select an option: \n");
        displayCustomerAccounts();

        System.out.println("\n    1) Pay a Customer");
        System.out.println("\n    2) Deposit");
        System.out.println("\n    3) Withdraw");
        System.out.println("\n    4) Display Statement");
        System.out.println("\n    5) Create an Account");
        System.out.println("\n    6) Logout");
        try {
            selection = keyboardInput.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\nIncorrect selection");
            return;
        }
        switch (selection) {
            case 1:
                //
                break;
            case 2:
                Deposit.Deposit(loggedInCustomer, customerAccounts);
                break;
            case 3:
                Withdraw.Withdraw(loggedInCustomer, customerAccounts);
                break;
            case 4:
                //
                break;
            case 5:
                CreateAnAccount.CreateAnAccount(loggedInCustomer);
                break;
            case 6:
                loggedInCustomer = null;
                break;
            default:
                // code block
        }
    }

    private static void displayCustomerAccounts() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (customerAccounts.size() < 1) return;

        System.out.println("    Account   Type            Balance");
        for (Account account : customerAccounts) {
            System.out.printf("    %8d  %-8s %15s%n", account.getAccountID(), account.getType(),
                    "£" + decimalFormat.format(account.getBalance()));
        }
    }

    public static void setLoggedInCustomer(Customer customer) {
        loggedInCustomer = customer;
    }

    public static Customer getLoggedInCustomer() {
        return loggedInCustomer;
    }
}
