package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginCustomer {
    public static Customer LoginCustomer(FinancialInformation financialInformation) {
        Scanner keyboardInput = new Scanner(System.in);
        String email;
        String password;

        System.out.println("\n     Please enter your email address: ");
        try {
            email = keyboardInput.nextLine();
        } catch (Exception e) {
            System.out.println("\nIncorrect entry");
            return null;
        }

        System.out.println("\n     Please enter your password: ");
        try {
            password = keyboardInput.nextLine();
        } catch (Exception e) {
            System.out.println("\nIncorrect entry");
            return null;
        }

        ArrayList<Customer> customers = financialInformation.getCustomerTable();
        if (email.equals("") || password.equals("")) return null;
        for (Customer customer : customers) {
            if (email.equals(customer.getEmail()) && password.equals(customer.getPassword())) {
                System.out.println("\nLogin Successful");
                return customer;
            }
        }
        System.out.println("\nLogin Unsuccessful");
        return null;
    }
}