package by.academy.service;

import by.academy.http.MyHttpService;
import by.academy.pojo.MyRole;
import by.academy.pojo.MyUser;
import by.academy.repository.MyRoleRepository;
import by.academy.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InitialService {
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private static final String rootPassword = "$2a$10$WPtG4BnSTV6v3w5fB7B.7.h21vuYN8f7v0MJeS/0Cs7/wf0oFlQWe";
    @Autowired
    MyUserService userService;
    @Autowired
    MyRoleRepository roleRepository;
    @Autowired
    MyUserRepository userRepository;
    @Autowired
    MyHttpService httpService;


    @Transactional
    public String init(String rootPass, String adminPass) {
        if (!encoder.matches(rootPass, rootPassword)) return "error-page";
        roleRepository.save(new MyRole("USER"));
        roleRepository.save(new MyRole("ADMIN"));

        MyUser admin = new MyUser();
        admin.setUserName("Woof");
        admin.setRoles(List.of(roleRepository.findByRoleName("ADMIN"), roleRepository.findByRoleName("USER")));
        admin.setUserPassword(encoder.encode(adminPass));
        userRepository.save(admin);
        httpService.httpInitiate();
        return "home";
    }
}
