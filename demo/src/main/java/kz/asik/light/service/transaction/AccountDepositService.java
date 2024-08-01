package kz.asik.light.service.transaction;

import kz.asik.light.models.account.Account;
import kz.asik.light.models.account.AccountDeposit;
import kz.asik.light.models.account.AccountWithdraw;

public interface AccountDepositService {
    void deposit(double amount, Account account);

}
