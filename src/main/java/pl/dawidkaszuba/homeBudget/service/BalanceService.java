package pl.dawidkaszuba.homeBudget.service;

import org.springframework.stereotype.Service;
import pl.dawidkaszuba.homeBudget.model.Balance;

@Service
public interface BalanceService {

    Balance getBalance(String userId,String from, String to);
}
