package pl.dawidkaszuba.homeBudget.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class PlannedCashFlow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String note;
    private BigDecimal currentSumAmount;
    private BigDecimal plannedAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isSumAmountExceeded;
    @ManyToOne
    private User user;

    public PlannedCashFlow() {
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BigDecimal getCurrentSumAmount() {
        return currentSumAmount;
    }

    public void setCurrentSumAmount(BigDecimal currentSumAmount) {
        this.currentSumAmount = currentSumAmount;
    }

    public BigDecimal getPlannedAmount() {
        return plannedAmount;
    }

    public void setPlannedAmount(BigDecimal plannedAmount) {
        this.plannedAmount = plannedAmount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isSumAmountExceeded() {
        return isSumAmountExceeded;
    }

    public void setSumAmountExceeded(boolean sumAmountExceeded) {
        isSumAmountExceeded = sumAmountExceeded;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "PlannedCashFlow{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                ", currentSumAmount=" + currentSumAmount +
                ", plannedAmount=" + plannedAmount +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isSumAmountExceeded=" + isSumAmountExceeded +
                ", user=" + user +
                '}';
    }

    public String printPlannedCashFlowList(List<PlannedCashFlow> plannedCashFlowList) {
        return plannedCashFlowList.stream()
                .map(PlannedCashFlow::toString)
                .collect(Collectors.joining());
    }
}
