
package org.example;

        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;

        import java.io.ByteArrayInputStream;
        import java.io.ByteArrayOutputStream;
        import java.io.PrintStream;

        import static org.junit.jupiter.api.Assertions.*;

class LoginCustomerTest {
    FinancialInformation financialInformation = new FinancialInformation();
    @BeforeEach
    void setUp() {
        // Provide System.in
        String userInput = String.format("mick@syd.com%spassword",
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
    public void LoginCustomerTest() {
        financialInformation.registerACustomer(new Customer("mick", "password", "mick@syd.com"));
        Customer loggedInCustomer = LoginCustomer.LoginCustomer(financialInformation);

        assertEquals("mick", loggedInCustomer.getUsername());
        assertEquals("mick@syd.com", loggedInCustomer.getEmail());
    }
}
