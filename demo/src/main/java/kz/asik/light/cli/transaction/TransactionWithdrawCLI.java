package kz.asik.light.cli.transaction;

import kz.asik.light.models.account.Account;
import kz.asik.light.models.transaction.Transaction;
import kz.asik.light.service.account.AccountListingService;
import kz.asik.light.ui.transaction.TransactionWithdraw;
import kz.asik.light.ui.transaction.WithdrawDepositOperationCLIUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionWithdrawCLI {
    private final TransactionWithdraw transactionWithdraw;
    private final WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private final AccountListingService accountListingService;

    @Autowired
    public TransactionWithdrawCLI(TransactionWithdraw transactionWithdraw,
                                  WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI,
                                  AccountListingService accountListingService) {
        this.transactionWithdraw = transactionWithdraw;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListingService = accountListingService;
    }
    public void withdrawMoney(){
        String id = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        Account account =  accountListingService.getClientAccountById(id);
        double amount = withdrawDepositOperationCLIUI.requestClientAmount();

        transactionWithdraw.execute(account, amount);
    }

    public void printAllTransaction(){
        List<Transaction> transactions = transactionWithdraw.printTransaction();
        for(Transaction transaction : transactions){
            System.out.println("Transaction ID: " + transaction.getTransactionId());
            System.out.println("Account id: " + transaction.getAccountId());
            System.out.println("Transaction Type: " + transaction.getTransactionType());
            System.out.println("Transaction amount: " + transaction.getAmount());
            System.out.println("------------");

        }
    }
}
