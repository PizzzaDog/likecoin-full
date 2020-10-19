package by.academy.service;

import by.academy.pojo.MyCheck;
import by.academy.repository.CheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckService {

    @Autowired
    CheckRepository repo;

    public MyCheck getByName(String name) {
        return repo.findByName(name);
    }

    public MyCheck createCheck(MyCheck check) {
        return repo.save(check);
    }
}
