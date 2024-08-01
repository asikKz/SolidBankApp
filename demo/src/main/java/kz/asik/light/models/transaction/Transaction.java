package kz.asik.light.models.transaction;

import kz.asik.light.models.account.AccountDeposit;
import kz.asik.light.models.account.type.AccountType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Transaction {
    private String transactionId;
    private String accountId;
    private TransactionType transactionType;
    private double amount;
    public Transaction(String accountId, TransactionType transactionType, double amount) {

        this.accountId = accountId;
        this.transactionType = transactionType;
        this.amount = amount;
    }
    public Transaction(){}

    public Transaction(String transactionId, String accountId, TransactionType transactionType, double amount) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.amount = amount;
    }
}
