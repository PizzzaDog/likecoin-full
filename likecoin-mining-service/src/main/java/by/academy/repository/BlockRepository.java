package by.academy.repository;

import by.academy.pojo.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.Optional;

@Repository
public interface BlockRepository extends CrudRepository<Block, String> {

    @Query(value = "SELECT b FROM Block b where b.timeStamp = (SELECT MAX(b.timeStamp) FROM Block b)")
    Optional<Block> findByMaxTimeStamp();

}
