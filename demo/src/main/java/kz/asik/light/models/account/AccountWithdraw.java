package kz.asik.light.models.account;

import kz.asik.light.models.account.type.AccountType;


public class AccountWithdraw extends Account{
    public AccountWithdraw(String id, String clientID, double balance, boolean withdrawAllowed, AccountType accountType) {
        super(id, clientID, balance, withdrawAllowed, accountType);
    }
    public AccountWithdraw(){}
    @Override
    public void deposit(double amount, AccountDeposit accountDeposit) {
        setBalance(getBalance() + amount);
    }

    @Override
    public void withdraw(double amount) {
        if(amount <= getBalance()){
            setBalance(getBalance() - amount);
        }
        else System.out.println("У вас не хватает средств");
    }


}
