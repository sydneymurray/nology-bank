package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WithdrawTest {
    @BeforeEach
    void setUp() {
        // Provide System.in
        String userInput = String.format("1%s500", System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        // Capture System.out so it is not displayed
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
    }

    @Test
    public void withdraw500PoundsShowsOnAccountShouldLeave250Pounds() {
        ArrayList<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account(1000, "CURRENT", 750f));
        Withdraw.Withdraw(new Customer("jake", "password", "jake@syd.com"), accounts);

        assertTrue(accounts.get(0).getBalance() == 250);
        assertTrue(FinancialInformation.getTransactionTable().get(0).getAmount() == 500);
    }
}
