package org.example;

import java.time.LocalDateTime;

public class Transaction {
    private Integer payerAccount;
    private Integer PayeeAccount;
    private float amount;
    private String type;
    private LocalDateTime transactionTime;

    public Transaction(Integer payerAccount, Integer payeeAccount, float amount, String type,
                       LocalDateTime transactionTime) {
        this.payerAccount = payerAccount;
        this.PayeeAccount = payeeAccount;
        this.amount = amount;
        this.type = type;
        this.transactionTime = transactionTime;
    }

    public Integer getPayeeAccount() { return PayeeAccount; }
    public Integer getPayerAccount() { return payerAccount; }
    public float getAmount() { return amount; }
    public String getType() { return type; }
    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }
}
