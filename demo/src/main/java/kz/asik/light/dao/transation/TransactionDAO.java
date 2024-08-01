package kz.asik.light.dao.transation;

import kz.asik.light.models.transaction.Transaction;

import java.util.List;

public interface TransactionDAO {
    List<Transaction> getTransactions();
    void addTransaction(Transaction transaction);
}
