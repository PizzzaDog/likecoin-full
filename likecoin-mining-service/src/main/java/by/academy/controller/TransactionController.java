package by.academy.controller;

import by.academy.pojo.Transaction;
import by.academy.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/create_transaction/{senderWalletId}/{recipientWalletId}/{amount}/{secretKey}")
    public Transaction createTransaction(@PathVariable String senderWalletId, @PathVariable String recipientWalletId, @PathVariable int amount, @PathVariable String secretKey) {
        return transactionService.createTransaction(senderWalletId, recipientWalletId, amount, secretKey);
    }
}
