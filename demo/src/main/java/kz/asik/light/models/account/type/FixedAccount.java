package kz.asik.light.models.account.type;

import kz.asik.light.models.account.AccountDeposit;

public class FixedAccount extends AccountDeposit {
    public FixedAccount(String id, String clientID, double balance, boolean withdrawAllowed, AccountType accountType) {
        super(id, clientID, balance, withdrawAllowed, accountType );
    }


}
