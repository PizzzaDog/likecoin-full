package by.academy.controller;

import by.academy.pojo.MyWallet;
import by.academy.service.MyUserService;
import by.academy.service.WalletMvcService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WalletController {
    @Autowired
    WalletMvcService walletSevice;
    @Autowired
    MyUserService userService;

    @GetMapping("/wallet/{id}")
    public ModelAndView walletDetails(ModelAndView model, @PathVariable String id) {
        model.addObject(walletSevice.getWallet(id));
        model.addObject("receivedTransactions", walletSevice.getReceivedTransactions(id));
        model.addObject("sentTransactions", walletSevice.getSentTransactions(id));
        model.addObject("allTransactions", walletSevice.getAllTransactions(id));
        model.addObject("user", (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.setViewName("wallet");
        return model;
    }
    @GetMapping("/wallet/createWallet")
    public ModelAndView getCreateWallet(ModelAndView model) {
        model.setViewName("new-wallet");
        return model;
    }

    @PostMapping("/wallet/createWallet")
    public String postCreateWallet(@ModelAttribute MyWallet wallet) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        walletSevice.createNewWallet(wallet, user.getUsername());
        return "redirect:/wallets_list";
    }
}
