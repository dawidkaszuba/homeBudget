package pl.dawidkaszuba.homeBudget.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Savings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private LocalDateTime lastModificationDate;
    @OneToOne
    private User user;

    public Savings() {
    }
}
