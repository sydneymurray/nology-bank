package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginCustomer {
    public static void LoginCustomer() {
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

        ArrayList<Customer> customers = FinancialInformation.getCustomerTable();
        for (Customer customer : customers) {
            if (email.equals(customer.getEmail()) && password.equals(customer.getPassword())) {
                BankInService.setLoggedInCustomer(customer);
                System.out.println("\nLogin Successful");
                return;
            }
            System.out.println("\nLogin Unsuccessful");
        }
    }
}