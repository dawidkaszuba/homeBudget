package pl.dawidkaszuba.homeBudget.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dawidkaszuba.homeBudget.entity.Savings;
import pl.dawidkaszuba.homeBudget.repository.SavingsRepository;
import pl.dawidkaszuba.homeBudget.service.SavingsService;

import java.math.BigDecimal;

@Service
public class SavingsServiceImpl implements SavingsService {

    private final SavingsRepository savingsRepository;

    @Override
    public Savings updateSavings(String userId, Savings savings) {
        Savings currentSavings = savingsRepository.getSavingsByUserAndMaxModificationDate(userId);
        BigDecimal newSavingsAmount;
        if(currentSavings.getAmount().compareTo(BigDecimal.ZERO) > 0) {
            newSavingsAmount = currentSavings.getAmount().add(savings.getAmount());
        } else {
            newSavingsAmount = currentSavings.getAmount().subtract(savings.getAmount());
        }
        currentSavings.setAmount(newSavingsAmount);
        return this.savingsRepository.save(currentSavings);
    }

    @Autowired
    public SavingsServiceImpl(SavingsRepository savingsRepository) {
        this.savingsRepository = savingsRepository;
    }

    @Override
    public Savings getSavings(String userid) {
        return this.savingsRepository.getSavingsByUserAndMaxModificationDate(userid);
    }
}
