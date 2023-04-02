package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customerTable = new ArrayList<Customer>();
        ArrayList<Account> accountsTable = new ArrayList<Account>();
        ArrayList<Transaction> transactionTable = new ArrayList<Transaction>();

        customerTable.add(new Customer("Syd", "password", "syd@syd.com"));
        customerTable.add(new Customer("Bill", "password", "bill@syd.com"));
        customerTable.add(new Customer("Trish", "password", "trish@syd.com"));

        // new AddACustomer(customerTable);

        System.out.println("\nCUSTOMERS");
        for(Customer customer: customerTable){
            //System.out.println(customer.getCustomerID() + " " + customer.getUsername() + " " + customer.getEmail());
            System.out.printf("%6d %-8s %-12s%n",customer.getCustomerID(), customer.getUsername(), customer.getEmail());
        }

        accountsTable.add(new Account(customerTable.get(0).getCustomerID(), "CURRENT", 230));
        accountsTable.add(new Account(customerTable.get(1).getCustomerID(), "CURRENT", 49));
        accountsTable.add(new Account(customerTable.get(2).getCustomerID(), "CURRENT", 155));

        System.out.println("\nACCOUNTS");
        for(Account account: accountsTable){
            System.out.printf("%8d %8d %8s %6d%n", account.getAccountID(), account.getOwner(), account.getType(), account.getBalance());
        }

        BankInService.inService(customerTable, accountsTable, transactionTable);
    }
}