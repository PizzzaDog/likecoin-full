package by.academy.controller;

import by.academy.pojo.MyWallet;
import by.academy.service.WalletMvcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Secured({"ROLE_USER", "ROLE_ADMIN"})
@Controller
public class WalletsListController {
    @Autowired
    WalletMvcService walletMvcService;

    @GetMapping("/wallets_list")
    public ModelAndView getWalletsList(ModelAndView model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<MyWallet> wallets = walletMvcService.getWalletsListByUserName(user.getUsername());
        if (wallets.isEmpty()) {
            model.addObject("errorMessage", "You got no wallets, please create one.");
            model.addObject("redirectLink", "/likecoin/wallet/createWallet");
            model.addObject("username", user.getUsername());
            model.setViewName("error-page");
            return model;
        }
        model.addObject(wallets);
        model.setViewName("wallets-list");
        return model;
    }
}
