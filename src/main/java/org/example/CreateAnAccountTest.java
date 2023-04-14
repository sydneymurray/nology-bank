package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CreateAnAccountTest {

    @Test
    public void registerCustomerHasAName() {
        String userInput = String.format("sydney%spassword%ssyd@syd.com",
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        RegisterACustomer.RegisterACustomer(); // call the main method
        
        assertEquals(FinancialInformation.getCustomerTable().get(0).getUsername(),"sydney");
    }
}

// How to test inputs and outputs
// https://www.danvega.dev/blog/2020/12/16/testing-standard-in-out-java/