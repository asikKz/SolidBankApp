package kz.asik.light.cli.account;

import kz.asik.light.service.account.AccountListingService;
import kz.asik.light.models.account.Account;
import kz.asik.light.ui.account.BankCore;
import kz.asik.light.ui.account.CreateAccountOperationUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountBasicCLI {
    private final CreateAccountOperationUI createAccountOperationUI;
    private final AccountListingService accountListingService;
    private final BankCore bankCore;

    @Autowired
    public AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI, AccountListingService accountListingService, BankCore bankCore) {
        this.createAccountOperationUI = createAccountOperationUI;
        this.accountListingService = accountListingService;
        this.bankCore = bankCore;
    }

    public void createAccountRequest() {
        bankCore.creatNewAccount(createAccountOperationUI.requestAccountType());
    }

    public void getAccounts() {
        List<Account> accounts = accountListingService.getClientAccounts();
        for (Account account : accounts) {
            System.out.println("Account ID: " + account.getId());
            System.out.println("Client ID: " + account.getClientID());
            System.out.println("Balance: " + account.getBalance());
            System.out.println("Withdraw Allowed: " + account.isWithdrawAllowed());
            System.out.println("Account Type: " + account.getAccountType());
            System.out.println("------------");
        }
    }
}
