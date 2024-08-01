package kz.asik.light.service.transaction;

import kz.asik.light.dao.account.AccountDAO;
import kz.asik.light.models.account.Account;
import kz.asik.light.models.account.AccountDeposit;
import kz.asik.light.models.account.AccountWithdraw;
import kz.asik.light.models.transaction.Transaction;
import kz.asik.light.ui.transaction.TransactionDeposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountDepositServiceImpl implements AccountDepositService{
    private final AccountDAO accountDAO;
    @Autowired
    public AccountDepositServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }


    @Override
    public void deposit(double amount, Account account) {
        account.setBalance(account.getBalance() + amount);
        accountDAO.updateAccount(account);
    }
}
