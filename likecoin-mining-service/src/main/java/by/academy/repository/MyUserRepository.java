package by.academy.repository;

import by.academy.pojo.MyUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends CrudRepository<MyUser, String> {
    MyUser findByUserName(String userName);
}
