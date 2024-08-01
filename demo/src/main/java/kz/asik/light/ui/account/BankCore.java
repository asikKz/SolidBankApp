package kz.asik.light.ui.account;

import kz.asik.light.service.account.AccountCreationService;
import kz.asik.light.models.account.type.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BankCore {
    private static  long id = 4;
    private  long lastAccountNumber = 4;
    private  AccountCreationService accountCreationService;
    @Autowired
    public BankCore(AccountCreationService accountCreationService){
        this.accountCreationService = accountCreationService;
    }
    public void creatNewAccount(AccountType accountType){
        accountCreationService.create(accountType, String.valueOf(id), lastAccountNumber);
        incrementLastAccount();
    }
    public void  incrementLastAccount(){
        lastAccountNumber++;

    }
}
