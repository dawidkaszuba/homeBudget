package pl.dawidkaszuba.homeBudget.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dawidkaszuba.homeBudget.model.Balance;
import pl.dawidkaszuba.homeBudget.service.BalanceService;
import pl.dawidkaszuba.homeBudget.service.ExpenditureService;
import pl.dawidkaszuba.homeBudget.service.IncomeService;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private final Balance balance;
    @Autowired
    private final IncomeService incomeService;
    @Autowired
    private final ExpenditureService expenditureService;


    public BalanceServiceImpl(Balance balance, IncomeService incomeService, ExpenditureService expenditureService) {
        this.balance = balance;
        this.incomeService = incomeService;
        this.expenditureService = expenditureService;
    }

    @Override
    public Balance getBalance(String from, String to) {

        balance.setValue(incomeService.findSumAmountFromTo(from,to).subtract(expenditureService.findSumAmountFromTo(from,to)));

        return balance;
    }
}
