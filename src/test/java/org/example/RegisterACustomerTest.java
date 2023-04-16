package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RegisterACustomerTest {
    @BeforeEach
    void setUp() {
        // Provide System.in
        String userInput = String.format("sydney%spassword%ssyd@syd.com",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        // Capture System.out so it is not displayed
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);
    }

    @Test
    public void registerACustomerStoredTheCorrectDetails() {
        RegisterACustomer.RegisterACustomer();

        assertEquals("sydney", FinancialInformation.getCustomerTable().get(0).getUsername());
        assertEquals("syd@syd.com", FinancialInformation.getCustomerTable().get(0).getEmail());
        assertEquals("password", FinancialInformation.getCustomerTable().get(0).getPassword());
        assertTrue(FinancialInformation.getCustomerTable().get(0).getCustomerID() > 1000);
    }
}
