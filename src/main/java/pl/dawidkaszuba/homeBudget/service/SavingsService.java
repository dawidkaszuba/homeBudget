package pl.dawidkaszuba.homeBudget.service;

import org.springframework.stereotype.Service;
import pl.dawidkaszuba.homeBudget.entity.Savings;

@Service
public interface SavingsService {
    Savings getSavings(String userid);
}
