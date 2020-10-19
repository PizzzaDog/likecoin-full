package by.academy.controller;

import by.academy.pojo.MyCheck;
import by.academy.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class CheckController {
    @Autowired
    CheckService service;

    @GetMapping("/check")
    public MyCheck getCheck(@RequestParam String name) {
        return service.getByName(name);
    }

    @PostMapping("/check")
    public MyCheck postCheck(@ModelAttribute MyCheck check) {
        return service.createCheck(check);
    }
}
