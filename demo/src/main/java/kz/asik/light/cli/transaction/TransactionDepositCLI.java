package kz.asik.light.cli.transaction;

import kz.asik.light.models.account.Account;
import kz.asik.light.models.account.AccountDeposit;
import kz.asik.light.service.account.AccountListingService;
import kz.asik.light.ui.transaction.TransactionDeposit;
import kz.asik.light.ui.transaction.WithdrawDepositOperationCLIUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionDepositCLI {
    private final TransactionDeposit transactionDeposit;
    private final WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private final AccountListingService accountListingService;

    @Autowired
    public TransactionDepositCLI(TransactionDeposit transactionDeposit, WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI, AccountListingService accountListingService) {
        this.transactionDeposit = transactionDeposit;
        this.withdrawDepositOperationCLIUI = withdrawDepositOperationCLIUI;
        this.accountListingService = accountListingService;
    }

   public void depositMoney(){
       try {
           String id = withdrawDepositOperationCLIUI.requestClientAccountNumber();
           Account account =  accountListingService.getClientAccountById(id);
           double amount = withdrawDepositOperationCLIUI.requestClientAmount();
           transactionDeposit.execute(account, amount);

           System.out.println("Replenishment of funds has been completed successfully!!!");
       }
       catch (Exception e){
           System.out.println(e.getMessage());
       }
   }
}
