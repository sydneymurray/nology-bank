package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginCustomer {
    public LoginCustomer(ArrayList<Customer> customerTable) {
        Scanner keyboardInput = new Scanner(System.in);
        String selection = null;
        String email;
        String password;

        System.out.println("\n     Please enter your email address: ");
        try {
            email = keyboardInput.nextLine();
        } catch (Exception e) {
            System.out.println("\nIncorrect entry");
            return;
        }

        System.out.println("\n     Please enter your password: ");
        try {
            password = keyboardInput.nextLine();
        } catch (Exception e) {
            System.out.println("\nIncorrect entry");
            return;
        }

        for (Customer customer : customerTable) {
            if (email.equals(customer.getEmail()) && password.equals(customer.getPassword())) {
                BankInService.loggedInCustomerID = customer.getCustomerID();
                BankInService.loggedInCustomer = customer;
                System.out.println("\nLogin Successful");
                return;
            }
            System.out.println("\nLogin Unsuccessful");
        }
    }
}