package by.academy.controller;

import by.academy.service.MiningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiningController {

    @Autowired
    private MiningService miningService;

    @PostMapping("/start_mining/{walletId}/{duration}")
    public void startMining(@PathVariable String walletId, @PathVariable int duration) {
        miningService.startMining(walletId, duration);
    }
}
