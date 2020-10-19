package by.academy.service;

import by.academy.pojo.Block;
import by.academy.repository.BlockRepository;
import by.academy.repository.MyWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MiningService {
    private boolean isMiningOn;
    @Autowired
    BlockService blockService;

    @Autowired
    BlockRepository blockRepository;

    @Autowired
    MyWalletRepository walletRepository;

    public void startMining(String walletId, int duration) {
        long startTime = System.currentTimeMillis();
        while (startTime > System.currentTimeMillis() - duration * 1000) {
            mineBlock(walletId);
        }
    }

    @Transactional
    boolean mineBlock(String walletId) {
        Block block = blockService.generateBlock();
        block.getTransactions().forEach(tr -> tr.setStatus(true));
        blockRepository.save(block);
        if (blockRepository.existsById(block.getId())) {
            walletRepository.findById(walletId).get().addBlock(block);
            return true;
        } else return false;
    }
}
