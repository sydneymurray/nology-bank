package org.example;

import java.time.LocalDateTime;
import java.util.Date;

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

    public void setPayerAccount(int payerAccount) {
        this.payerAccount = payerAccount;
    }

    public void setPayeeAccount(int payeeAccount) {
        PayeeAccount = payeeAccount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }
}
