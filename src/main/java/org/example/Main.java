package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Create fake customers
        FinancialInformation.registerACustomer(new Customer("Bill", "password", "bill@syd.com"));
        FinancialInformation.registerACustomer(new Customer("Ted", "password", "ted@syd.com"));
        FinancialInformation.registerACustomer(new Customer("Claudia", "password", "claudia@syd.com"));

        // Display fake customers
        ArrayList<Customer> customers = FinancialInformation.getCustomerTable();
        System.out.println("\nCUSTOMERS");
        for(Customer customer: customers){
            //System.out.println(customer.getCustomerID() + " " + customer.getUsername() + " " + customer.getEmail());
            System.out.printf("%6d %-8s %-12s%n",customer.getCustomerID(), customer.getUsername(), customer.getEmail());
        }

        // Create fake accounts
        FinancialInformation.createAnAccount(new Account(
                customers.get(0).getCustomerID(), "CURRENT", 230));
        FinancialInformation.createAnAccount(new Account(
                customers.get(1).getCustomerID(), "CURRENT", 49));
        FinancialInformation.createAnAccount(new Account(
                customers.get(2).getCustomerID(), "CURRENT", 155));

        // Display fake accounts
        System.out.println("\nACCOUNTS");
        ArrayList<Account> accounts = FinancialInformation.getAccountsTable();
        for(Account account: accounts){
            System.out.printf("%8d %8d %8s %6d%n", account.getAccountID(), account.getOwner(), account.getType(),
                    account.getBalance());
        }

        // OK Lets go
        BankInService.inService();
    }
}