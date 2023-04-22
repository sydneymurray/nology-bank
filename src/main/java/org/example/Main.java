package org.example;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");
    public static void main(String[] args) {
        BankInService bankInService = new BankInService();
        bankInService.inService();
    }
}