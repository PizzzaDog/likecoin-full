package by.academy.service;

import by.academy.pojo.Block;
import by.academy.pojo.MyWallet;
import by.academy.pojo.Transaction;
import by.academy.repository.MyUserRepository;
import by.academy.repository.MyWalletRepository;
import by.academy.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    @Autowired
    MyWalletRepository walletRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    MyUserRepository userRepository;

    @Transactional
    public Transaction createTransaction(String senderWalletId, String recipientWalletId, int amount, String secretKey) {
        MyWallet senderWallet = walletRepository.findById(senderWalletId).orElseThrow();
        MyWallet recipientWallet = walletRepository.findById(recipientWalletId).orElseThrow();


        if (!senderWallet.getSecretKey().equals(secretKey)) {return null;}

        if (checkCurrency(senderWallet, recipientWallet)) {
            Set<Block> trBlocks = senderWallet.getBlocks();
            if (trBlocks.size() < amount) return null;

            trBlocks = trBlocks.stream().limit(amount).collect(Collectors.toSet());

            senderWallet.removeBlocks(trBlocks);
            recipientWallet.addBlocks(trBlocks);

            Transaction transaction = new Transaction();
            transaction.setSenderWalletId(senderWallet.getId());
            transaction.setRecipientWalletId(recipientWallet.getId());
            transaction.setAmount(amount);
            transaction.setStatus(false);

            walletRepository.save(senderWallet);
            walletRepository.save(recipientWallet);
            return transactionRepository.save(transaction);
        }
        return null;
    }
    private boolean checkCurrency(MyWallet sender, MyWallet recipient) {
        if (!sender.getCurrency().equals(recipient.getCurrency())) {
            recipient = walletRepository.findByUserIdAndCurrency(recipient.getUser().getId(), sender.getCurrency()).orElse(null);
            return recipient != null;
        }
        return true;
    }
}
