package by.academy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class MyWallet {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    private String secretKey;

    @ManyToOne
    private MyUser user;

    private String currency;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Block> blocks;

    public void addBlock(Block block) {
        if (blocks == null) {
            blocks = Set.of(block);
        } else {
            blocks.add(block);
        }
    }
    public void addBlocks(Set<Block> blocks) {
        this.blocks.addAll(blocks);
    }
    public void removeBlocks(Set<Block> blocks) {
        this.blocks.removeAll(blocks);
    }
}
