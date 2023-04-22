package org.example;

import java.util.ArrayList;

public class FinancialInformation {
    private static ArrayList<Customer> customerTable = new ArrayList<Customer>();
    private static ArrayList<Account> accountsTable = new ArrayList<Account>();
    private static ArrayList<Transaction> transactionTable = new ArrayList<Transaction>();

    public ArrayList<Customer> getCustomerTable() {
        return customerTable;
    }

    public void registerACustomer(Customer customer) {
        if (customer == null) return;
        customerTable.add(customer);
    }

    public ArrayList<Account> getAccountsTable() {
        return accountsTable;
    }

    public void createAnAccount(Account account) { accountsTable.add(account); }

    public ArrayList<Transaction> getTransactionTable() {
        return transactionTable;
    }

    public void recordATransaction(Transaction transaction) {
        transactionTable.add(transaction);
    }

    public ArrayList<Account> getCustomerAccounts(Customer customer) {
        ArrayList<Account> customerAccounts = new ArrayList<Account>();
        for (Account account : accountsTable) {
            if (customer.getCustomerID() == account.getOwner()) customerAccounts.add(account);
        }
        return customerAccounts;
    }

    public void creditAnAccount(int accountNumber, Float amount) throws Exception {
        for (Account account : accountsTable) {
            if (account.getAccountID() == accountNumber) {
                account.creditBalance(amount);
                return;
            }
        }
        throw new Exception("Account " + accountNumber + " does not exist");
    }

    public Integer getAccountOwner(int accountID) {
        for (Account account : accountsTable) {
            if (account.getAccountID() == accountID) return account.getOwner();
        }
        return null;
    }

    public ArrayList<Transaction> getStatement(int accountID) {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        for (Transaction transaction : transactionTable) {
            if (transaction.getPayeeAccount() == accountID || transaction.getPayerAccount() == accountID) {
                transactions.add(transaction);
            }
        }
        return transactions;
    }

    public String getAccountOwnersName(int account) {
        int accountOwnerID = getAccountOwner(account);
        for (Customer customer : customerTable) {
            if (accountOwnerID == customer.getCustomerID()) return customer.getUsername();
        }
        return null;
    }

    public void resetAllInformation(){
        customerTable.clear();
        accountsTable.clear();
        transactionTable.clear();
    }
}