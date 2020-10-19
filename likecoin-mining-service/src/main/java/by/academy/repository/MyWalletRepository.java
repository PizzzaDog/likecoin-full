package by.academy.repository;

import by.academy.pojo.MyWallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyWalletRepository extends CrudRepository<MyWallet, String> {

    Optional<MyWallet> findByUserIdAndCurrency(String userId, String currency);
}
