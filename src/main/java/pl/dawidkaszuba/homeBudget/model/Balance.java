package pl.dawidkaszuba.homeBudget.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Balance {

    private BigDecimal value;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
