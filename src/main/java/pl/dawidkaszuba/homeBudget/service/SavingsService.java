package pl.dawidkaszuba.homeBudget.service;

import org.jvnet.hk2.annotations.Service;
import pl.dawidkaszuba.homeBudget.entity.Savings;

@Service
public interface SavingsService {
    Savings getSavings(String userid);
}
