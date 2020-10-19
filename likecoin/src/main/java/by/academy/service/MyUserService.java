package by.academy.service;

import by.academy.pojo.MyUser;
import by.academy.pojo.MyWallet;
import by.academy.repository.MyRoleRepository;
import by.academy.repository.MyUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class MyUserService {
    private static final Logger log = LoggerFactory.getLogger(MyUserService.class);

    @Autowired
    private MyUserRepository myUserRepository;
    @Autowired
    private MyRoleRepository myRoleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Transactional
    public boolean createNewUser(MyUser user) {
        if (myUserRepository.existsByUserName(user.getUserName())) return false;
        log.info("Creating new user with name: {}", user.getUserName());
        final String encodedPassword = passwordEncoder.encode(user.getUserPassword());
        user.setUserPassword(encodedPassword);
        user.setRoles(Collections.singletonList(myRoleRepository.findByRoleName("USER")));
        myUserRepository.save(user);
        return myUserRepository.existsById(user.getId());
    }

    @Transactional
    public boolean addWalletToUser(MyUser user, MyWallet wallet) {
        //user.getMyWalletList().add(wallet);
        myUserRepository.save(user);
        return true;
    }
    @Transactional
    public MyUser findUserByUserName(String userName) {
        return myUserRepository.findByUserName(userName);
    }

    public List<MyUser> getAll() {
        List<MyUser> users = new ArrayList<>();
        myUserRepository.findAll().forEach(users::add);
        return users;
    }

    public List<MyUser> findAllByUserName(String userName) {
        return myUserRepository.findAllByUserName(userName);
    }
    public MyUser findByUserName(String userName) {
        return myUserRepository.findByUserName(userName);
    }
    public List<MyUser> findAll() {
        List<MyUser> users = new ArrayList<>();
        myUserRepository.findAll().forEach(users::add);
        return users;
    }
    public MyUser findById(String id) {
        return myUserRepository.findById(id).orElseThrow();
    }

}
