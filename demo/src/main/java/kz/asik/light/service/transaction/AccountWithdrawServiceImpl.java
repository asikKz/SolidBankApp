package kz.asik.light.service.transaction;

import kz.asik.light.dao.account.AccountDAO;
import kz.asik.light.models.account.Account;
import kz.asik.light.models.account.type.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountWithdrawServiceImpl implements AccountWithdrawService{
    private final AccountDAO accountDAO;
@Autowired
    public AccountWithdrawServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void withdraw(double amount, Account account) {
    if(account.getAccountType() == AccountType.FIXED){
        System.out.println("You have a fixed account. You can't send money");

    } else if (amount > account.getBalance()) {
        System.out.println("You don't have enough money!!");
    }
    else {
        account.setBalance(account.getBalance() - amount);
        accountDAO.updateAccount(account);
        System.out.println("Replenishment of funds has been completed successfully!!!");
        }
    }


}
