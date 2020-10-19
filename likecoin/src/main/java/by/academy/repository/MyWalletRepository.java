package by.academy.repository;

import by.academy.pojo.MyUser;
import by.academy.pojo.MyWallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyWalletRepository extends CrudRepository<MyWallet, String> {
    List<MyWallet> findAllByUser(MyUser user);

    MyWallet findFirstByUserUserName(String userName);
}
