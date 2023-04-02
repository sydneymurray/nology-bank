package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AddACustomer {
    public AddACustomer(ArrayList<Customer> customerTable) {
        Scanner keyboardInput = new Scanner(System.in);
        String name = null;
        String password = null;
        String email = null;

        while (name == null) {
            System.out.println("\n     Please enter your name: ");
            try {
                name = keyboardInput.nextLine();
            } catch (Exception e) {
                System.out.println("\nIncorrect entry");
                return;
            }
        }

        while (password == null) {
            System.out.println("\n     Please enter a new password: ");
            try {
                password = keyboardInput.nextLine();
            } catch (Exception e) {
                System.out.println("\nIncorrect entry");
                return;
            }
        }

        while (email == null) {
            System.out.println("\n     Please enter your email address");
            try {
                email = keyboardInput.nextLine();
            } catch (Exception e) {
                System.out.println("\nIncorrect entry");
                return;
            }
        }

        customerTable.add(new Customer(name, password, email));
        System.out.println("Congratulations. Your application has been accepted");
    }
}
