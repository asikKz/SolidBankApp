package kz.asik.light.models.account.type;


import kz.asik.light.models.account.AccountWithdraw;

public class SavingAccount extends AccountWithdraw {
    public SavingAccount(String id, String clientID, double balance, boolean withdrawAllowed, AccountType accountType) {
        super(id, clientID, balance, withdrawAllowed , accountType );
    }
}