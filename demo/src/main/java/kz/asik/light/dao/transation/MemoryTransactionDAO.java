package kz.asik.light.dao.transation;

import kz.asik.light.models.transaction.Transaction;
import kz.asik.light.models.transaction.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MemoryTransactionDAO implements TransactionDAO{
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public MemoryTransactionDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        jdbcTemplate.update(
                "INSERT INTO transaction (accountid, amount, transactiontype) VALUES (?, ?, ?)",
                transaction.getAccountId(),
                transaction.getAmount(),
                transaction.getTransactionType().toString());
    }

    public List<Transaction> getTransactions() {
        String sql = "SELECT * FROM transaction";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            String id = rs.getString("transactionid");

            String accountID = rs.getString("accountid");
            double amount = rs.getDouble("amount");
            TransactionType transactionType = TransactionType.valueOf(rs.getString("transactiontype"));

            return new Transaction(id, accountID, transactionType, amount);
        });
    }
}
