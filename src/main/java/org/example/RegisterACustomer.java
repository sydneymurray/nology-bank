package org.example;

import java.util.Scanner;

public class RegisterACustomer {
    public static Customer RegisterACustomer() {
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
                return null;
            }
        }

        while (password == null) {
            System.out.println("\n     Please enter a new password: ");
            try {
                password = keyboardInput.nextLine();
            } catch (Exception e) {
                System.out.println("\nIncorrect entry");
                return null;
            }
        }

        while (email == null) {
            System.out.println("\n     Please enter your email address");
            try {
                email = keyboardInput.nextLine();
            } catch (Exception e) {
                System.out.println("\nIncorrect entry");
                return null;
            }
        }

        if (name.equals("") || email.equals("") || password.equals("")) return null;
        System.out.println("Congratulations. Your application has been accepted");
        return new Customer(name, password, email);
    }
}
