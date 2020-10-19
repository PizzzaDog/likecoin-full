package by.academy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping(value = "/home")
    public ModelAndView homePage(ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        modelAndView.addObject("greeting", "HELLO");
        return modelAndView;
    }
}
