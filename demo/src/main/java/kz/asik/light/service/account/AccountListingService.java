package kz.asik.light.service.account;

import kz.asik.light.models.account.Account;
import kz.asik.light.models.account.AccountDeposit;
import kz.asik.light.models.account.AccountWithdraw;
import kz.asik.light.models.account.type.AccountType;

import java.util.List;

public interface AccountListingService {
    Account getClientAccountByClientId(String clientID, String accountID);
    AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) ;
    List<Account> getClientAccounts();
    List<Account> getClientAccountsByType(String clientID, AccountType accountType);
    Account getClientAccountById(String id);
}
