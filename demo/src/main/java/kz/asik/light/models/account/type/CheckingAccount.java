package kz.asik.light.models.account.type;

import kz.asik.light.models.account.AccountWithdraw;

public class CheckingAccount extends AccountWithdraw {

    public CheckingAccount(String id, String clientID, double balance, boolean withdrawAllowed, AccountType accountType) {
        super(id, clientID, balance, withdrawAllowed , accountType );
    }
}
