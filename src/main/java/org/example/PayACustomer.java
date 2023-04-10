package org.example;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.*;

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
        int[] payees = loggedInCustomer.getPayees();
        if (loggedInCustomer.getPayees() != null) {
            ArrayList<Customer> customers = FinancialInformation.getCustomerTable();
            System.out.println("       Name          Account");
            for (int i = 0; i < payees.length; i++) {
                System.out.printf("   %2d) %-10s  %10d%n", i + 1,
                        getAccountOwnerName(FinancialInformation.getAccountOwner(payees[i]), customers),
                        payees[i]);
            }
        }
        try {
            payeeAccountID = keyboardInput.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\nIncorrect selection");
            return;
        }

        if(payerAccountID > 0 && payeeAccountID < payees.length + 1) payeeAccountID = payees[payeeAccountID-1];
        try {
            FinancialInformation.creditAnAccount(payeeAccountID, amount);
        } catch (Exception e) {
            System.out.println("Account " + payeeAccountID + " does not exist");
            return;
        }
        loggedInCustomer.addAPayee(payeeAccountID);
        customerAccounts.get(selection).debitBalance(amount);

        LocalDateTime timeAndDate = LocalDateTime.now();
        FinancialInformation.recordATransaction(new Transaction(payerAccountID,
                payeeAccountID, amount, paymentComment, timeAndDate));
    }

    private static String getAccountOwnerName(int ownerID, ArrayList<Customer> customers) {
        for (Customer customer : customers) {
            if (ownerID == customer.getCustomerID()) return customer.getUsername();
        }
        return "";
    }
}

