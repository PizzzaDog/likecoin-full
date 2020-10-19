package by.academy.service;

import by.academy.pojo.MyWallet;
import by.academy.repository.MyWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyWalletService {
    @Autowired
    MyWalletRepository walletRepository;

    @Transactional
    public MyWallet createNewWallet(MyWallet wallet) {
        return walletRepository.save(wallet);
    }

    @Transactional
    public int getAmountOfBlocks(String walletId) {
        return walletRepository.findById(walletId).orElseThrow().getBlocks().size();
    }
//    @Transactional
//    public MyWallet getWalletById(String id) {
//        return (MyWallet) walletRepository.findById(id);
//    }
}
