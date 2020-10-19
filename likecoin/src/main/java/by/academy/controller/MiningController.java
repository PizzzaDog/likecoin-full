package by.academy.controller;

import by.academy.http.MyHttpService;
import by.academy.service.WalletMvcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MiningController {
    @Autowired
    MyHttpService httpService;
    @Autowired
    WalletMvcService walletService;

    @GetMapping("/start_mining")
    public String getStartMining() {
        return "redirect:/wallets_list";
    }
    @GetMapping("/wallet/{walletId}/mining")
    public ModelAndView getMiningPage(@PathVariable String walletId, ModelAndView model) {
        model.addObject(walletService.getWallet(walletId));
        model.setViewName("wallet-mining");
        return model;
    }
    @PostMapping("/wallet/{walletId}/mining")
    public ModelAndView postMiningPage(@PathVariable String walletId, @RequestParam int duration, ModelAndView model) {
        httpService.httpStartMining(walletId, duration);
        model.addObject("duration", duration);
        model.setViewName("wallets-list");
        return model;
    }
}
