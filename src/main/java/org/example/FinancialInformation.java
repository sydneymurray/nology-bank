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

    public static void createAnAccount(Account account) { accountsTable.add(account); }

    public static ArrayList<Transaction> getTransactionTable() {
        return transactionTable;
    }

    public static void recordATransaction(Transaction transaction) {
        transactionTable.add(transaction);
    }

    public static ArrayList<Account> getCustomerAccounts(Customer customer) {
        ArrayList<Account> customerAccounts = new ArrayList<Account>();
        for (Account account : accountsTable) {
            if (customer.getCustomerID() == account.getOwner()) customerAccounts.add(account);
        }
        return customerAccounts;
    }

    public static void creditAnAccount(int accountNumber, Float amount) throws Exception {
        for (Account account : accountsTable) {
            if (account.getAccountID() == accountNumber) {
                account.creditBalance(amount);
                return;
            }
        }
        throw new Exception("Account " + accountNumber + " does not exist");
    }

    public static Integer getAccountOwner(int accountID) {
        for (Account account : accountsTable) {
            if (account.getAccountID() == accountID) return account.getOwner();
        }
        return null;
    }

    public static ArrayList<Transaction> getStatement(int accountID) {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        for (Transaction transaction : transactionTable) {
            if (transaction.getPayeeAccount() == accountID || transaction.getPayerAccount() == accountID) {
                transactions.add(transaction);
            }
        }
        return transactions;
    }

    public static String getAccountOwnersName(int account) {
        int accountOwnerID = getAccountOwner(account);
        for (Customer customer : customerTable) {
            if (accountOwnerID == customer.getCustomerID()) return customer.getUsername();
        }
        return null;
    }
}