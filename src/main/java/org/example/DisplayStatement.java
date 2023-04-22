package org.example;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DisplayStatement {
    public static void DisplayStatement(Customer customer, ArrayList<Account> customerAccounts,
                                        FinancialInformation financialInformation) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        Scanner keyboardInput = new Scanner(System.in);
        int selection;

        System.out.println("       Please select an account");
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

        int accountID = customerAccounts.get(selection).getAccountID();
        ArrayList<Transaction> transactions = financialInformation.getStatement(accountID);
        System.out.println("       Date     Name       Amount");
        for (int i = transactions.size(); i > 0; i--) {
            if (transactions.get(i).getType().equals("DEPOSIT")) {
                System.out.printf("   %10s %10s  %10s %n",
                        transactions.get(i).getTransactionTime().toLocalDate(),
                        "DEPOSIT",
                        "£" + decimalFormat.format(transactions.get(i).getAmount()));
                continue;
            }
            if (transactions.get(i).getType().equals("WITHDRAWAL")) {
                System.out.printf("   %10s %10s  %10s %n",
                        transactions.get(i).getTransactionTime().toLocalDate(),
                        "WITHDRAWAL",
                        "£-" + decimalFormat.format(transactions.get(i).getAmount()));
                continue;
            }
            if (accountID == transactions.get(i).getPayeeAccount()) {
                System.out.printf("   %10s %10s  %10s %n",
                        transactions.get(i).getTransactionTime().toLocalDate(),
                        financialInformation.getAccountOwnersName(transactions.get(i).getPayerAccount()),
                        "£" + decimalFormat.format(transactions.get(i).getAmount()));
                continue;
            }
            if (accountID == transactions.get(i).getPayerAccount()) {
                System.out.printf("   %10s %10s  %10s %n",
                        transactions.get(i).getTransactionTime().toLocalDate(),
                        financialInformation.getAccountOwnersName(transactions.get(i).getPayeeAccount()),
                        "£-" + decimalFormat.format(transactions.get(i).getAmount()));
                continue;
            }
        }
    }
}
