package org.example;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PayACustomer {
    public static void PayACustomer(Customer loggedInCustomer, ArrayList<Account> customerAccounts) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        Scanner keyboardInput = new Scanner(System.in);
        int selection;
        int payeeAccountID;
        float amount;
        String paymentComment = "";

        System.out.println("       Please select the payer account");
        System.out.println("       Account   Type          Balance");
        for (int i = 0; i < customerAccounts.size(); i++) {
            System.out.printf("   %1d) %8d  %-8s %15s%n", i + 1, customerAccounts.get(i).getAccountID(),
                    customerAccounts.get(i).getType(),
                    "£" + decimalFormat.format(customerAccounts.get(i).getBalance()));
        }
        try {
            selection = keyboardInput.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\nIncorrect selection");
            return;
        }
        selection--;
        if (selection > customerAccounts.size()) return;
        int payerAccountID = customerAccounts.get(selection).getAccountID();

        System.out.println("       Please enter the amount");
        try {
            amount = keyboardInput.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("\nIncorrect entry");
            return;
        }

        if (amount > customerAccounts.get(selection).getBalance()) {
            System.out.println("       Insufficient funds");
            return;
        }

        System.out.println("       Please enter the payment title or reference");
        try {
            paymentComment = keyboardInput.next();
        } catch (InputMismatchException e) {
            System.out.println("\nIncorrect entry");
            return;
        }

        System.out.println("       Please select a payee option or account number");
        try {
            payeeAccountID = keyboardInput.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\nIncorrect selection");
            return;
        }

        try{
            FinancialInformation.creditAnAccount(payeeAccountID, amount);
        }
        catch (Exception e){
            System.out.println("Account " + payeeAccountID + " does not exist");
            return;
        }
        customerAccounts.get(selection).debitBalance(amount);

        LocalDateTime timeAndDate = LocalDateTime.now();
        FinancialInformation.recordATransaction(new Transaction(payerAccountID,
                payeeAccountID, amount, paymentComment, timeAndDate));
    }
}

