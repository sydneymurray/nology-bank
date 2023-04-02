package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankInService {
    public static int loggedInCustomerID = 0;
    public static Customer loggedInCustomer = null;

    public static void inService(ArrayList<Customer> customerTable, ArrayList<Account> accountsTable,
                                 ArrayList<Transaction> transactionTable) {
        Scanner keyboardInput = new Scanner(System.in);
        int selection = 0;
        if (loggedInCustomerID != 0) {
            for (Customer customer : customerTable) {
                if (customer.getCustomerID() == loggedInCustomerID) {
                    loggedInCustomer = customer;
                }

            }
        } else {
            loggedInCustomer = null;
        }

        while (true) {
            if (loggedInCustomerID == 0) {
                System.out.println("\n\n     Welcome to Syd-Bank. Please select an option: ");
                System.out.println("\n 1) Sign Up: ");
                System.out.println("\n 2) Login");
                try {
                    selection = keyboardInput.nextInt();
                } catch (InputMismatchException e) {
                    //e.printStackTrace();
                    System.out.println("\nIncorrect selection");
                }
                switch (selection) {
                    case 1:
                        new AddACustomer(customerTable);
                        break;
                    case 2:
                        new LoginCustomer(customerTable);
                        break;
                    default:
                        // code block
                }
            } else {
                System.out.println("\n\n     Welcome " + loggedInCustomer.getUsername() + ". Please select an option: ");
                System.out.println("\n 1) Pay a Customer");
                System.out.println("\n 2) Deposit");
                System.out.println("\n 3) Withdraw");
                System.out.println("\n 4) Logout");
                try {
                    selection = keyboardInput.nextInt();
                } catch (InputMismatchException e) {
                    //e.printStackTrace();
                    System.out.println("\nIncorrect selection");
                }
            }
        }
    }
}
