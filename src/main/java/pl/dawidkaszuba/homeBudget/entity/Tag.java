package pl.dawidkaszuba.homeBudget.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private User user;
    @ManyToMany
    private List<Income> income;
    @ManyToMany
    private List<Expenditure> expenditure;

    public Tag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Income> getIncome() {
        return income;
    }

    public void setIncome(List<Income> income) {
        this.income = income;
    }

    public List<Expenditure> getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(List<Expenditure> expenditure) {
        this.expenditure = expenditure;
    }
}
