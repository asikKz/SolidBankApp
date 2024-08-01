package kz.asik.light.service.account;

import kz.asik.light.models.account.type.AccountType;

public interface AccountCreationService {
    void create(AccountType accountType,String clientID, long accountID);
}
