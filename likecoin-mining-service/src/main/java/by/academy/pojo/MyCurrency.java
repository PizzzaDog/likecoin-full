package by.academy.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class MyCurrency {

    @Id
    private String id;
    private String name;
}
