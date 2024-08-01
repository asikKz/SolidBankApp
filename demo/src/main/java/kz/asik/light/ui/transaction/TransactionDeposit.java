package kz.asik.light.ui.transaction;

import kz.asik.light.dao.transation.TransactionDAO;
import kz.asik.light.models.account.Account;
import kz.asik.light.models.account.AccountDeposit;
import kz.asik.light.models.transaction.Transaction;
import kz.asik.light.models.transaction.TransactionType;
import kz.asik.light.service.transaction.AccountDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionDeposit {
    private  final  AccountDepositService accountDepositService;
    private final TransactionDAO transactionDAO;
    @Autowired
    public TransactionDeposit(AccountDepositService accountDepositService, TransactionDAO transactionDAO) {
        this.accountDepositService = accountDepositService;
        this.transactionDAO = transactionDAO;
    }

    public void execute(Account account, double amount ){
        accountDepositService.deposit(amount, account);

        Transaction transaction = new Transaction(account.getId(), TransactionType.DEPOSIT, amount);
        transactionDAO.addTransaction(transaction);
    };
}
