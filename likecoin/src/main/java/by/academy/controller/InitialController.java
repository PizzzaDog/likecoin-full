package by.academy.controller;

import by.academy.service.InitialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InitialController {
    @Autowired
    InitialService initService;

    @GetMapping("/init")
    public String getInitiatePage() {
        return "init";
    }

    @PostMapping("/init")
    public String initiate(@RequestParam String initPassword, @RequestParam String adminPassword) {
        return initService.init(initPassword, adminPassword);
    }
}
