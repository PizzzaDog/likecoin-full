package by.academy.service;

import by.academy.pojo.MyWallet;
import by.academy.pojo.Transaction;
import by.academy.repository.MyTransactionRepository;
import by.academy.repository.MyUserRepository;
import by.academy.repository.MyWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WalletMvcService {
    @Autowired
    MyWalletRepository walletRepository;
    @Autowired
    MyUserRepository userRepository;
    @Autowired
    MyTransactionRepository transactionRepository;
    @Autowired
    MyTransactionService transactionService;

    @Transactional
    public List<MyWallet> getWalletsListByUserName(String userName) {
        return walletRepository.findAllByUser(userRepository.findByUserName(userName));
    }
    @Transactional
    public MyWallet createNewWallet(MyWallet wallet, String userName) {
        wallet.setUser(userRepository.findByUserName(userName));
        return walletRepository.save(wallet);
    }

    @Transactional
    public MyWallet getWallet(String id) {
        return walletRepository.findById(id).orElseThrow();

    }

    @Transactional
    public List<Transaction> getSentTransactions(String walletId) {
        return transactionService.getSentTransactions(walletId);
    }

    @Transactional
    public List<Transaction> getReceivedTransactions(String walletId) {
        return transactionService.getReceivedTransactions(walletId);
    }
    @Transactional
    public List<Transaction> getAllTransactions(String walletId) {
        return  transactionService.getAllTransactions(walletId);
    }
}
