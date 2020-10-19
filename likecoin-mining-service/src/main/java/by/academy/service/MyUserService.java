package by.academy.service;

import by.academy.pojo.MyUser;
import by.academy.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyUserService {

    @Autowired
    MyUserRepository myUserRepository;

    @Transactional
    public MyUser findUserByUserName(String userName) {
        return myUserRepository.findByUserName(userName);
    }
}
