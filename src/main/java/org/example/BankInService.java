package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankInService {
    private static Customer loggedInCustomer = null;
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
        System.out.println("\n 1) Sign Up: ");
        System.out.println("\n 2) Login");
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
        System.out.println("\n\n     Welcome " + loggedInCustomer.getUsername() + ". Please select an option: ");
        System.out.println("\n 1) Pay a Customer");
        System.out.println("\n 2) Deposit");
        System.out.println("\n 3) Withdraw");
        System.out.println("\n 4) Display Statement");
        System.out.println("\n 5) Logout");
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
            case 5:
                loggedInCustomer = null;
                break;
            default:
                // code block
        }
    }

    public static void setLoggedInCustomer(Customer customer){
        loggedInCustomer = customer;
    }
}
