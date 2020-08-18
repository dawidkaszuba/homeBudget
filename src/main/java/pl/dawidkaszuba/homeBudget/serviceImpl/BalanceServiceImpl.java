package pl.dawidkaszuba.homeBudget.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dawidkaszuba.homeBudget.model.Balance;
import pl.dawidkaszuba.homeBudget.service.BalanceService;
import pl.dawidkaszuba.homeBudget.service.ExpenditureService;
import pl.dawidkaszuba.homeBudget.service.IncomeService;

import java.math.BigDecimal;

@Service
public class BalanceServiceImpl implements BalanceService {


    private final Balance balance;
    private final IncomeService incomeService;
    private final ExpenditureService expenditureService;

    @Autowired
    public BalanceServiceImpl(Balance balance, IncomeService incomeService, ExpenditureService expenditureService) {
        this.balance = balance;
        this.incomeService = incomeService;
        this.expenditureService = expenditureService;
    }

    @Override
    public Balance getBalance(String userId, String from, String to) {


        BigDecimal incomes = incomeService.findSumAmountFromTo(userId,from,to);
        BigDecimal expenditures = expenditureService.findSumAmountFromTo(userId,from,to);

        if(incomes == null )
            incomes = new BigDecimal(0.00);
        if(expenditures == null)
            expenditures = new BigDecimal(0.00);
        balance.setValue(incomes.subtract(expenditures));

        return balance;
    }
}
