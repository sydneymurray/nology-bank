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
    FinancialInformation financialInformation = new FinancialInformation();

    public void inService() {
        while (true) {
            if (loggedInCustomer == null) displayLoggedOutMenu();
            else displayLoggedinMenu();
        }
    }

    private void displayLoggedOutMenu() {
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
                financialInformation.registerACustomer(RegisterACustomer.RegisterACustomer());
                break;
            case 2:
                loggedInCustomer = LoginCustomer.LoginCustomer();
                break;
            default:
                // code block
        }
    }

    private void displayLoggedinMenu() {
        customerAccounts = financialInformation.getCustomerAccounts(loggedInCustomer);
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
                PayACustomer.PayACustomer(loggedInCustomer, customerAccounts, financialInformation);
                break;
            case 2:
                Deposit.Deposit(loggedInCustomer, customerAccounts, financialInformation);
                break;
            case 3:
                Withdraw.Withdraw(loggedInCustomer, customerAccounts, financialInformation);
                break;
            case 4:
                DisplayStatement.DisplayStatement(loggedInCustomer, customerAccounts, financialInformation);
                break;
            case 5:
                CreateAnAccount.CreateAnAccount(loggedInCustomer, financialInformation);
                break;
            case 6:
                loggedInCustomer = null;
                break;
            default:
                // code block
        }
    }

    private void displayCustomerAccounts() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (customerAccounts.size() < 1) return;

        System.out.println("    Account   Type            Balance");
        for (Account account : customerAccounts) {
            System.out.printf("    %8d  %-8s %15s%n", account.getAccountID(), account.getType(),
                    "£" + decimalFormat.format(account.getBalance()));
        }
    }

    public Customer getLoggedInCustomer() {
        return loggedInCustomer;
    }
}

/*
        // Create fake customers
        financialInformation.registerACustomer(new Customer("Bill", "password", "bill@syd.com"));
        financialInformation.registerACustomer(new Customer("Ted", "password", "ted@syd.com"));
        financialInformation.registerACustomer(new Customer("Claudia", "password", "claudia@syd.com"));

        // Display fake customers
        ArrayList<Customer> customers = financialInformation.getCustomerTable();
        System.out.println("\nCUSTOMERS");
        for(Customer customer: customers){
            //System.out.println(customer.getCustomerID() + " " + customer.getUsername() + " " + customer.getEmail());
            System.out.printf("%6d %-8s %-12s%n",customer.getCustomerID(), customer.getUsername(), customer.getEmail());
        }

        // Create fake accounts
        financialInformation.createAnAccount(new Account(
                customers.get(0).getCustomerID(), "CURRENT", 230));
        financialInformation.createAnAccount(new Account(
                customers.get(1).getCustomerID(), "CURRENT", 49));
        financialInformation.createAnAccount(new Account(
                customers.get(2).getCustomerID(), "CURRENT", 155));

        // Display fake accounts
        System.out.println("\nACCOUNTS");
        ArrayList<Account> accounts = financialInformation.getAccountsTable();

        for(Account account: accounts){
            System.out.printf("%8d %8d %8s %9s%n", account.getAccountID(), account.getOwner(), account.getType(),
                    "£" + decimalFormat.format(account.getBalance()));
        }
 */
