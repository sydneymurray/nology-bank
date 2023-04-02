package org.example;

import java.util.Random;

public class Customer {
    private String username;
    private String email;
    private String password;
    private int customerID;

    public Customer(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email=email;
        Random random = new Random();
        this.customerID = 1000 + random.nextInt(8999);
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCustomerID() {
        return customerID;
    }
}

