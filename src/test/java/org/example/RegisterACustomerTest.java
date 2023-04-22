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
        String userInput = String.format("sydney%spassword%ssyd@syd.com%s",
                System.lineSeparator(),
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
    public void registerACustomerReturnsTheCorrectDetails() {
        Customer newCustomer = RegisterACustomer.RegisterACustomer();

        assertEquals("sydney", newCustomer.getUsername());
        assertEquals("syd@syd.com", newCustomer.getEmail());
        assertEquals("password", newCustomer.getPassword());
        assertTrue(newCustomer.getCustomerID() > 1000);
    }
}
