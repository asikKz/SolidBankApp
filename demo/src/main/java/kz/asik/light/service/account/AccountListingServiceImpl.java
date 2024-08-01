package kz.asik.light.service.account;

import kz.asik.light.dao.account.AccountDAO;
import kz.asik.light.models.account.Account;
import kz.asik.light.models.account.AccountDeposit;
import kz.asik.light.models.account.AccountWithdraw;
import kz.asik.light.models.account.type.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountListingServiceImpl implements AccountListingService {

    private final AccountDAO accountDAO;

    @Autowired
    public AccountListingServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public Account getClientAccountByClientId(String clientID, String accountID) {
        return accountDAO.getClientAccount(clientID, accountID);
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        return accountDAO.getClientWithdrawAccount(clientID,accountID);
    }

    @Override
    public List<Account> getClientAccounts() {
        return accountDAO.getClientAccounts();
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return accountDAO.getClientAccountsByType(clientID, accountType);
    }

    @Override
    public Account getClientAccountById(String id) {
        return accountDAO.getClientAccountById(id);
    }

}
