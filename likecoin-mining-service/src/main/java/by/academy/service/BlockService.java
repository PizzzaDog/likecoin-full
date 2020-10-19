package by.academy.service;


import by.academy.pojo.Block;
import by.academy.pojo.Transaction;
import by.academy.repository.BlockRepository;
import by.academy.repository.TransactionRepository;
import com.google.common.hash.Hashing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class BlockService {
    private static final Logger log = LoggerFactory.getLogger(BlockService.class);
    private static final Random random = new Random();

    @Autowired
    BlockRepository blockRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Transactional
    public Block generateBlock() {
        log.info("Checking is any block exist");
//        if (LatestBlockId.getLastId() != null) {
            log.info("Block exist! Start mining.");
        Block block = new Block();
//        block.setPreviousHash(blockRepository.findFirstById(LatestBlockId.getLastId()).getHash());
        block.setPreviousHash(blockRepository.findByMaxTimeStamp().orElse(generateFirstBlock()).getHash());
        block.setTimeStamp(System.nanoTime());
        block.setBlockData(generateData());
        block.setHash(generateHash(block));
        block.setTransactions(getInvalidTransactions());
        return block;
//        } else return generateFirstBlock();
    }


    private String generateHash(Block block) {
        String toHash = block.getPreviousHash() + block.getTimeStamp() + block.getBlockData();
        return Hashing.sha256().hashString(toHash,  StandardCharsets.UTF_8).toString();
    }

    private String generateData() {
        return "Block random data:" + random.nextInt(10000000);
    }

    private List<Transaction> getInvalidTransactions() {
        return transactionRepository.findAllByStatus(false).stream().limit(10).collect(Collectors.toList());
    }

    public Block generateFirstBlock() {
        log.info("block is not exist, creating first block");
        Block block = new Block();
        block.setPreviousHash("First hash in the world");
        block.setTimeStamp(System.nanoTime());
        block.setBlockData(generateData());
        block.setHash(generateHash(block));
        block.setTransactions(getInvalidTransactions());
        return block;
    }
}
