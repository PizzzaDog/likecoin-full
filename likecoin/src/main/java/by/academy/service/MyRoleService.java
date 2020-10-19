package by.academy.service;

import by.academy.pojo.MyRole;
import by.academy.repository.MyRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyRoleService {

    @Autowired
    @Qualifier("myRoleRepository")
    MyRoleRepository myRoleRepository;

    @Transactional
    public MyRole createNewRole(MyRole myRole) {
        return myRoleRepository.save(myRole);
    }

}
