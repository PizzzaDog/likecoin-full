package by.academy.repository;

import by.academy.pojo.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyTransactionRepository extends CrudRepository<Transaction, String> {
    List<Transaction> findAllBySenderWalletId(String walletId);

    List<Transaction> findAllByRecipientWalletId(String walletId);
}
