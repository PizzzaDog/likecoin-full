package by.academy.repository;

import by.academy.pojo.MyRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRoleRepository extends CrudRepository<MyRole, String> {
    MyRole findByRoleName(String user);
}
