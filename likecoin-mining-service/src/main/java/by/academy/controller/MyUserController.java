package by.academy.controller;

import by.academy.pojo.MyUser;
import by.academy.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyUserController {
    @Autowired
    MyUserService myUserService;

    @GetMapping
    public MyUser getUser(@RequestParam String userName) {
        return myUserService.findUserByUserName(userName);
    }
}
