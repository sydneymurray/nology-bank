package org.example;

import java.util.ArrayList;

public class FinancialInformation {
    private static ArrayList<Customer> customerTable = new ArrayList<Customer>();
    private static ArrayList<Account> accountsTable = new ArrayList<Account>();
    private static ArrayList<Transaction> transactionTable = new ArrayList<Transaction>();

    public static ArrayList<Customer> getCustomerTable() {
        return customerTable;
    }

    public static void registerACustomer(Customer customer) {
        customerTable.add(customer);
    }

    public static ArrayList<Account> getAccountsTable() {
        return accountsTable;
    }

    public static void createAnAccount(Account account) {
        accountsTable.add(account);
    }

    public static ArrayList<Transaction> getTransactionTable() {
        return transactionTable;
    }

    public static void recordATransaction(Transaction transaction) {
        transactionTable.add(transaction);
    }

    public static ArrayList<Account> getCustomerAccounts(Customer customer) {
        ArrayList<Account> customerAccounts = new ArrayList<Account>();
        for (Account account: accountsTable) {
            if (customer.getCustomerID() == account.getOwner()) customerAccounts.add(account);
        }
        return customerAccounts;
    }
}
