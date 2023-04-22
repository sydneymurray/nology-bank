package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateAnAccount {
    public static void CreateAnAccount(Customer customer, FinancialInformation financialInformation) {
        Scanner keyboardInput = new Scanner(System.in);
        int selection = 0;
        String type = null;

        System.out.println("\n Please  select an Account Type");
        System.out.println("\n 1) CURRENT");
        System.out.println("\n 2) SAVINGS");
        System.out.println("\n 3) BUSINESS");
        System.out.println("\n 4) LOAN");

        try {
            selection = keyboardInput.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\nIncorrect selection");
            return;
        }
        switch (selection) {
            case 1:
                type ="CURRENT";
                break;
            case 2:
                type ="SAVINGS";
                break;
            case 3:
                type ="BUSINESS";
                break;
            case 4:
                type ="LOAN";
                break;

            default:
                return;
        }

        financialInformation.createAnAccount(new Account(customer.getCustomerID(), type, 0));
        System.out.println("\n You have successfully created a " + type + " Account");
    }
}
