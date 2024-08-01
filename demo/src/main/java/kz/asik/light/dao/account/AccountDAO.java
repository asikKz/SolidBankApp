package kz.asik.light.dao.account;

import kz.asik.light.models.account.Account;
import kz.asik.light.models.account.AccountDeposit;
import kz.asik.light.models.account.type.AccountType;
import kz.asik.light.models.account.AccountWithdraw;

import java.util.*;

public interface AccountDAO {
    List<Account> getClientAccounts();
    void creatNewAccount(Account account);
    void updateAccount(Account account);
    List<Account> getClientAccountsByType(String clientID, AccountType accountType);
    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID);
    Account getClientAccount(String clientID, String accountID);

    Account getClientAccountById(String id);

}
