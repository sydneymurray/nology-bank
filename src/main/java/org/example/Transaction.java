package org.example;

import java.util.Date;

public class Transaction {
    private int payerAccount;
    private int PayeeAccount;
    private int amount;
    private int type;
    private Date transactionTime;

    public Transaction(int payerAccount, int payeeAccount, int amount, int type, Date transactionTime) {
        this.payerAccount = payerAccount;
        this.PayeeAccount = payeeAccount;
        this.amount = amount;
        this.type = type;
        this.transactionTime=transactionTime;
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

    public void setType(int type) {
        this.type = type;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }
}
