package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DepositTest {
    @BeforeEach
    void setUp() {
        // Provide System.in
        String userInput = String.format("1");
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        // Capture System.out so it is not displayed
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
    }

    @Test
    public void createAnAccountCreatedACurrentAccount() {
        CreateAnAccount.CreateAnAccount(new Customer("jake", "password", "jake@syd.com"));

        assertEquals("CURRENT", FinancialInformation.getAccountsTable().get(0).getType());
        assertTrue(FinancialInformation.getAccountsTable().get(0).getAccountID() > 10000000);
        assertTrue(FinancialInformation.getAccountsTable().get(0).getBalance() == 0);
    }
}
