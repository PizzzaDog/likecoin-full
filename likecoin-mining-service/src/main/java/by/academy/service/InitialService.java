package by.academy.service;

import by.academy.pojo.MyUser;
import by.academy.pojo.MyWallet;
import by.academy.repository.MyUserRepository;
import by.academy.repository.MyWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InitialService {
    @Autowired
    MyUserRepository userRepository;
    @Autowired
    MyWalletRepository walletRepository;

    @Transactional
    public void init() {
        for(int i = 1; i <=2; i++) {
            MyUser user = new MyUser();
            user.setUserName("TestUser" + i);
            MyWallet wallet = new MyWallet();
            wallet.setUser(user);
            wallet.setCurrency("USD");
            wallet.setSecretKey("secret" + i);
            userRepository.save(user);
            walletRepository.save(wallet);
        }
    }
}
