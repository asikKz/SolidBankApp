package kz.asik.light.models.account;


import kz.asik.light.models.account.type.AccountType;

public class AccountDeposit extends Account{
    public AccountDeposit(String id, String clientID, double balance, boolean withdrawAllowed, AccountType accountType) {
        super(id, clientID, balance, withdrawAllowed, accountType);
    }
    public AccountDeposit(){}

    @Override
    public void deposit(double amount, AccountDeposit accountDeposit) {
        setBalance(getBalance() + amount);
    }

    @Override
    public void withdraw(double amount) {
        System.out.println(" Не поддерживается !!!");
    }

}
