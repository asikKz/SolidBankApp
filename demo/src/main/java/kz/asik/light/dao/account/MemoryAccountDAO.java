package kz.asik.light.dao.account;

import kz.asik.light.models.account.Account;
import kz.asik.light.models.account.AccountDeposit;
import kz.asik.light.models.account.AccountWithdraw;
import kz.asik.light.models.account.type.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MemoryAccountDAO implements AccountDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public MemoryAccountDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Account> getClientAccounts() {
        String sql = "SELECT * FROM account";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            String id = rs.getString("id");
            String clientID = rs.getString("clientID");
            double balance = rs.getDouble("balance");
            boolean withdrawAllowed = rs.getBoolean("withdrawAllowed");
            AccountType accountType = AccountType.valueOf(rs.getString("accountType"));

                switch (accountType) {
                case SAVING:
                case FIXED:
                    return new AccountDeposit(id, clientID, balance, withdrawAllowed, accountType);
                case CHECKING:
                    return new AccountWithdraw(id, clientID, balance, withdrawAllowed, accountType);
                default:
                    throw new IllegalArgumentException("Неизвестный тип аккаунта: " + accountType);
            }
        });
    }

    @Override
    public void creatNewAccount(Account account) {
        String sql = "INSERT INTO account (clientID, balance, withdrawAllowed, accountType) VALUES ( ?, ?, ?, ?)";
        jdbcTemplate.update(sql, account.getClientID(), account.getBalance(), account.isWithdrawAllowed(), account.getAccountType().toString());
    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("UPDATE account set balance=? WHERE id=?", account.getBalance(), account.getId());
    }

    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType) {
        return jdbcTemplate.query("SELECT * FROM account WHERE clientID = ? AND accountType = ?",
                new Object[]{clientID, accountType.toString()},
                new BeanPropertyRowMapper<>(Account.class));
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID) {
        List<AccountWithdraw> accounts = jdbcTemplate.query("SELECT * FROM account WHERE clientID = ? AND id = ? AND withdrawallowed = true",
                new Object[]{clientID, accountID},
                new BeanPropertyRowMapper<>(AccountWithdraw.class));
        return accounts.stream().findAny().orElse(null);
    }


    @Override
    public Account getClientAccount(String clientID, String accountID) {
        return (Account) jdbcTemplate.query("SELECT * FROM account WHERE clientid = ? AND id = ?",
                new Object[]{clientID, accountID},
                new BeanPropertyRowMapper<>(Account.class));
    }

    @Override
    public Account getClientAccountById(String id) {
        return jdbcTemplate.query("SELECT * FROM account WHERE id=?", new Object[]{id},rs -> {
            if (rs.next()) {
                String accountType = rs.getString("accountType");
                if ("FIXED".equals(accountType)) {
                    return new BeanPropertyRowMapper<>(AccountDeposit.class).mapRow(rs, 1);}
                else {
                    return new BeanPropertyRowMapper<>(AccountWithdraw.class).mapRow(rs, 1);                }
            }
            return null;
        });
    }
}
