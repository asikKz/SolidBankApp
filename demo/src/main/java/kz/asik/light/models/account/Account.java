package kz.asik.light.models.account;

import kz.asik.light.models.account.type.AccountType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Account {
    private String id;
    private String clientID;
    private double balance;
    boolean withdrawAllowed;
    private AccountType accountType;

    public Account(String id, String clientID, double balance, boolean withdrawAllowed, AccountType accountType) {
        this.id = id;
        this.clientID = clientID;
        this.balance = 0;
        this.withdrawAllowed = withdrawAllowed;
        this.accountType = accountType;

    }
    public Account(){}


    public void setWithdrawAllowed(boolean withdrawAllowed) {
        this.withdrawAllowed = withdrawAllowed;
    }

    public abstract void deposit(double amount, AccountDeposit accountDeposit);
    public abstract void withdraw(double amount);
}
