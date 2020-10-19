package by.academy.controller;

import by.academy.service.InitialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitialController {
    @Autowired
    InitialService initialService;

    @PostMapping("/init")
    public void initiate() {
        initialService.init();
    }
}
