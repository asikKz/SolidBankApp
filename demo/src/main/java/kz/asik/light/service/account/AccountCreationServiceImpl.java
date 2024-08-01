package kz.asik.light.service.account;

import kz.asik.light.dao.account.AccountDAO;
import kz.asik.light.models.account.Account;
import kz.asik.light.models.account.type.AccountType;
import kz.asik.light.models.account.type.CheckingAccount;
import kz.asik.light.models.account.type.FixedAccount;
import kz.asik.light.models.account.type.SavingAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountCreationServiceImpl implements AccountCreationService {
    private final AccountDAO accountDAO;

    @Autowired
    public AccountCreationServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
 @Override
    public void create(AccountType accountType, String clientID, long accountID) {
        Account account;
        switch (accountType) {
            case SAVING:

                account = new SavingAccount(String.valueOf(accountID), clientID, 0.0,
                        true, accountType);
                System.out.println("The account has been successfully created!!!");
                break;
            case CHECKING:
                account = new CheckingAccount(String.valueOf(accountID), clientID, 0.0,
                        true, accountType);
                System.out.println("The account has been successfully created!!!");
                break;
            case FIXED:
                account = new FixedAccount(String.valueOf(accountID), clientID, 0.0,
                        false, accountType);
                System.out.println("The account has been successfully created!!!");
                break;
            default:
                throw new IllegalArgumentException("Unknown account type: " + accountType);
        }
     accountDAO.creatNewAccount(account);
    }
}
