package org.example;
import java.util.Random;
import java.util.ArrayList;

public class Account {
    private int accountID;
    private int owner;
    private String type;
    private float balance = 0;

    public Account(int owner, String type, float balance) {
        this.owner = owner;
        this.type = type;
        this.balance = balance;
        Random random = new Random();
        this.accountID = 10000000 + random.nextInt(89999999);
    }

    public int getAccountID() {
        return accountID;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void creditBalance(float amount){ balance += amount; }

    public void debitBalance(float amount){ balance -= amount; }

}
