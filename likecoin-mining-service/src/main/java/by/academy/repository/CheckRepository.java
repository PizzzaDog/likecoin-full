package by.academy.repository;

import by.academy.pojo.MyCheck;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckRepository extends CrudRepository<MyCheck, String> {
    MyCheck findByName(String name);
}
