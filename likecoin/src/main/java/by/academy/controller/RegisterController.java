package by.academy.controller;

import by.academy.pojo.MyUser;
import by.academy.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    @Autowired
    MyUserService myUserService;

    @GetMapping("/register")
    public ModelAndView signUpPage(ModelAndView model) {
        model.setViewName("register");
        return model;
    }
    @PostMapping("/register")
    public ModelAndView registerNewUser(@ModelAttribute MyUser myUser, ModelAndView model) {
        if (myUserService.createNewUser(myUser)) {
            model.setViewName("redirect:/login");
        } else {
            model.addObject("errorMessage", "Cannot create a new user");
            model.setViewName("error-page");
        }
        return model;
    }
}
