package by.academy.controller;

import by.academy.pojo.MyWallet;
import by.academy.service.MyWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WalletController {
    @Autowired
    MyWalletService walletService;

    @PostMapping("/wallet")
    public MyWallet createWallet(@ModelAttribute MyWallet wallet) {
        return walletService.createNewWallet(wallet);
    }

    @GetMapping("/wallet/get_amount/{walletId}")
    public int getWalletAmount(@PathVariable String walletId) {
        return walletService.getAmountOfBlocks(walletId);
    }
}
