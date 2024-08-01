package kz.asik.light.ui.transaction;

import kz.asik.light.dao.transation.TransactionDAO;
import kz.asik.light.models.account.Account;
import kz.asik.light.models.transaction.Transaction;
import kz.asik.light.models.transaction.TransactionType;
import kz.asik.light.service.transaction.AccountWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionWithdraw {
    private final AccountWithdrawService accountWithdrawService;
    private final TransactionDAO transactionDAO;

@Autowired
    public TransactionWithdraw(AccountWithdrawService accountWithdrawService, TransactionDAO transactionDAO) {
        this.accountWithdrawService = accountWithdrawService;
        this.transactionDAO = transactionDAO;
    }
    public void execute(Account account, double amount){
    accountWithdrawService.withdraw(amount, account);
        Transaction transaction = new Transaction(account.getId(), TransactionType.WITHDRAW, amount);
        transactionDAO.addTransaction(transaction);
    }
    public List<Transaction> printTransaction(){
        return transactionDAO.getTransactions();
}
}
