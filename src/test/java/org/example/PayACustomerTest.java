package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PayACustomerTest {
    FinancialInformation financialInformation = new FinancialInformation();
    @Test
    public void payACustomer500PoundsShows500InCurrentAccountAnd2500InSavingsAccount() {
        financialInformation.resetAllInformation();
        financialInformation.registerACustomer(new Customer("zack", "password", "zack@syd.com"));
        financialInformation.createAnAccount(new Account(financialInformation.getCustomerTable().get(0).getCustomerID(),
                "CURRENT", 1000));
        financialInformation.createAnAccount(new Account(financialInformation.getCustomerTable().get(0).getCustomerID(),
                "SAVINGS", 2000));
        int currentAccountID = financialInformation.getAccountsTable().get(0).getAccountID();
        int savingsAccountID = financialInformation.getAccountsTable().get(1).getAccountID();

        // Provide System.in
        String userInput = String.format("1%s500%sSavings%s" + savingsAccountID,
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        // Capture System.out so it is not displayed
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        PayACustomer.PayACustomer(financialInformation.getCustomerTable().get(0),
                financialInformation.getAccountsTable(), financialInformation);

        assertTrue(financialInformation.getAccountsTable().get(0).getBalance() == 500);
        assertTrue(financialInformation.getAccountsTable().get(1).getBalance() == 2500);
        assertTrue(financialInformation.getTransactionTable().get(0).getAmount() == 500);
    }
}
