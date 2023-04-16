
package org.example;

        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;

        import java.io.ByteArrayInputStream;
        import java.io.ByteArrayOutputStream;
        import java.io.PrintStream;
        import java.util.ArrayList;

        import static org.junit.jupiter.api.Assertions.*;

class LoginCustomerTest {
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
        FinancialInformation.registerACustomer(new Customer("mick", "password", "mick@syd.com"));
        LoginCustomer.LoginCustomer();

        assertEquals("mick", BankInService.getLoggedInCustomer().getUsername());
        assertEquals("mick@syd.com", BankInService.getLoggedInCustomer().getEmail());

        FinancialInformation.getCustomerTable();
    }
}
