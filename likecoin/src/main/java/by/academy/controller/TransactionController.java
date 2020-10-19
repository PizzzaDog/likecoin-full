package by.academy.controller;

import by.academy.service.MyTransactionService;
import by.academy.service.WalletMvcService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TransactionController {
    @Autowired
    MyTransactionService transactionService;
    @Autowired
    WalletMvcService walletService;

    @GetMapping("/wallet/{walletId}/transaction/{id}")
    public ModelAndView transactionDetails(ModelAndView model,@PathVariable String walletId, @PathVariable String id) {
        model.addObject("transaction", transactionService.getTransaction(id));
        model.addObject("walletId", walletId);
        model.setViewName("transaction");
        return model;
    }
    @GetMapping("/send_to/{recipientUserName}")
    public ModelAndView createTransaction(@PathVariable String recipientUserName, ModelAndView model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addObject("recipientUserName", recipientUserName);
        model.addObject("wallets", walletService.getWalletsListByUserName(user.getUsername()));
        model.setViewName("wallet-select");
        return model;
    }
    @GetMapping("/send_to/{recipientUserName}/from/{senderWalletId}")
    public ModelAndView prepareTransaction(@PathVariable String recipientUserName, @PathVariable String senderWalletId, ModelAndView model) {
        model.addObject("recipientUserName", recipientUserName);
        model.addObject("senderWalletId", senderWalletId);
        model.setViewName("prepare-transaction");
        return model;
    }
    @PostMapping("/send_to/{recipientUserName}/from_{senderWalletId}")
    public ModelAndView createTransaction(@PathVariable String recipientUserName,
                                          @PathVariable String senderWalletId,
                                          @RequestParam int amount,
                                          @RequestParam String secretKey,
                                          ModelAndView model) {
        transactionService.createTransaction(senderWalletId, recipientUserName, secretKey, amount);
        model.setViewName("redirect:/wallet/" + senderWalletId);
        return model;
    }

}
