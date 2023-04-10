package org.example;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Withdraw {
    public static void Withdraw(Customer customer, ArrayList<Account> customerAccounts){
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        Scanner keyboardInput = new Scanner(System.in);
        int selection;
        float amount;

        System.out.println("       Please select a withdrawal account");
        System.out.println("       Account   Type          Balance");
        for (int i = 0; i < customerAccounts.size(); i++) {
            System.out.printf("   %1d) %8d  %-8s %15s%n", i+1, customerAccounts.get(i).getAccountID(),
                    customerAccounts.get(i).getType(),
                    "£" + decimalFormat.format(customerAccounts.get(i).getBalance()));
        }

        try {
            selection = keyboardInput.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("\nIncorrect selection");
            return;
        }

        selection--;
        if (selection > customerAccounts.size()) return;
        int accountID = customerAccounts.get(selection).getAccountID();
        System.out.println("       Please select the withdrawal amount");
        try {
            amount = keyboardInput.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("\nIncorrect selection");
            return;
        }

        if (amount > customerAccounts.get(selection).getBalance()){
            System.out.println("       Insufficient funds");
            return;
        }

        LocalDateTime timeAndDate = LocalDateTime.now();
        FinancialInformation.recordATransaction(new Transaction( null, accountID, amount, "WITHDRAWAL",
                timeAndDate));
        customerAccounts.get(selection).debitBalance(amount);
    }
}
