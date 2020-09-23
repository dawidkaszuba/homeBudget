package pl.dawidkaszuba.homeBudget.serviceImpl;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import pl.dawidkaszuba.homeBudget.entity.Savings;
import pl.dawidkaszuba.homeBudget.repository.SavingsRepository;
import pl.dawidkaszuba.homeBudget.service.SavingsService;

@Service
public class SavingsServiceImpl implements SavingsService {

    private final SavingsRepository savingsRepository;

    @Autowired
    public SavingsServiceImpl(SavingsRepository savingsRepository) {
        this.savingsRepository = savingsRepository;
    }

    @Override
    public Savings getSavings(String userid) {
        return this.savingsRepository.getSavingsByUserAndMaxModificationDate(userid);
    }
}
