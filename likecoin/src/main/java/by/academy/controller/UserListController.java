package by.academy.controller;

import by.academy.pojo.MyUser;
import by.academy.service.MyUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserListController {
    private static Logger log = LoggerFactory.getLogger(UserListController.class);
    @Autowired
    MyUserService userService;

    @GetMapping("/users")
    public ModelAndView getUserList(ModelAndView model) {
        model.addObject("userList", userService.getAll());
        model.setViewName("user-list");
        return model;
    }
    @GetMapping("/users/search")
    public ModelAndView getSearchUserResult(ModelAndView model,
                                            @RequestParam(value = "searchQuery", required = false) String search) {
        if(search.equals("")) {
            model.setViewName("home");
            return model;
        }
        log.info("SEARCH QUERY=" + search);
        List<MyUser> userList = userService.findAll();
        model.addObject("user", userService.findByUserName(search));
        model.setViewName("user-search");
        return model;
    }
    @GetMapping("/users/all")
    public ModelAndView getAllUsers(ModelAndView model) {
        List<MyUser> userList = userService.findAll();
        model.addObject("userList", userList);
        model.setViewName("user-list");
        return model;
    }
}
