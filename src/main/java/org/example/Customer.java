package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Customer {
    private String username;
    private String email;
    private String password;
    private int customerID;
    //private HashSet<Integer> payees = new HashSet<Integer>();
    private Set<Integer> payees = new HashSet<Integer>();


    public Customer(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
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

    public void addAPayee(int payee) {
        payees.add(payee);
    }

//    public int[] getPayees() {
//        int[] payeeArr = new int[this.payees.size()];
//        int i = 0;
//        for (int payee: payees) {
//            payeeArr[i++] = payee;
//        }
//        return payeeArr;
//    }
    public ArrayList<Integer> getPayees() {
        ArrayList<Integer> payeeArr = new ArrayList<Integer>();
        for (int payee: payees) {
            payeeArr.add(payee);
        }
        return payeeArr;
    }
}
