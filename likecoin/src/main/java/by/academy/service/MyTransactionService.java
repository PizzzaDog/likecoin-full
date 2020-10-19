package by.academy.service;

import by.academy.http.MyHttpService;
import by.academy.pojo.MyWallet;
import by.academy.pojo.Transaction;
import by.academy.repository.MyTransactionRepository;
import by.academy.repository.MyWalletRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MyTransactionService {
    private static final Logger log = LoggerFactory.getLogger(MyTransactionService.class);
    @Autowired
    MyTransactionRepository transactionRepository;
    @Autowired
    MyWalletRepository walletRepository;
    @Autowired
    MyHttpService httpService;

    @Transactional
    public List<Transaction> getAllTransactions(String walletId) {
        List<Transaction> transactions = getReceivedTransactions(walletId);
        transactions.addAll(getSentTransactions(walletId));
        return transactions;
    }
    @Transactional
    public List<Transaction> getSentTransactions(String walletId) {
        return transactionRepository.findAllBySenderWalletId(walletId);
    }

    @Transactional
    public List<Transaction> getReceivedTransactions(String walletId) {
        return transactionRepository.findAllByRecipientWalletId(walletId);
    }

    @Transactional
    public Transaction getTransaction(String id) {
        return transactionRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void createTransaction(String senderWalletId, String recipientUserName, String secretKey, int amount) {
        String recipientWalletId = walletRepository.findFirstByUserUserName(recipientUserName).getId();
        httpService.httpCreateTransaction(senderWalletId, recipientWalletId, amount, secretKey);
    }
}

