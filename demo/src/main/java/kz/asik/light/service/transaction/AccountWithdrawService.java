package kz.asik.light.service.transaction;

import kz.asik.light.models.account.Account;

public interface AccountWithdrawService {
    void withdraw(double amount,Account account);
}
