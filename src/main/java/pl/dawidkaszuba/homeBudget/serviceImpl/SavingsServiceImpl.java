package pl.dawidkaszuba.homeBudget.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dawidkaszuba.homeBudget.entity.Expenditure;
import pl.dawidkaszuba.homeBudget.entity.Savings;
import pl.dawidkaszuba.homeBudget.entity.User;
import pl.dawidkaszuba.homeBudget.exception.UserNotFoundException;
import pl.dawidkaszuba.homeBudget.repository.SavingsRepository;
import pl.dawidkaszuba.homeBudget.service.ExpenditureService;
import pl.dawidkaszuba.homeBudget.service.SavingsService;
import pl.dawidkaszuba.homeBudget.service.UserService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SavingsServiceImpl implements SavingsService {

    private final SavingsRepository savingsRepository;
    private final ExpenditureService expenditureService;
    private final UserService userService;

    @Autowired
    public SavingsServiceImpl(SavingsRepository savingsRepository,
                              ExpenditureService expenditureService,
                              UserService userService) {
        this.savingsRepository = savingsRepository;
        this.expenditureService = expenditureService;
        this.userService = userService;
    }

    @Override
    public Savings getSavings(String userid) {
        return this.savingsRepository.getSavingsByUserAndMaxModificationDate(userid);
    }

    @Override
    public Savings updateSavings(String userId, Savings savings) {
        User user;
        Optional<User> optionalUser = userService.findById(Long.parseLong(userId));
        if(optionalUser.isPresent()) {
            user = optionalUser.get();
        }else {
            throw new UserNotFoundException("User doesn't exist");
        }
        Expenditure expenditure = new Expenditure();
        expenditure.setNote("savings");
        expenditure.setExpenditureDate(LocalDate.now());
        expenditure.setUser(user);
        expenditure.setAmount(savings.getAmount().abs());
        this.expenditureService.save(expenditure);
        Savings currentSavings = savingsRepository.getSavingsByUserAndMaxModificationDate(userId);
        BigDecimal newSavingsAmount;
        if(currentSavings.getAmount().compareTo(BigDecimal.ZERO) > 0) {
            newSavingsAmount = currentSavings.getAmount().add(savings.getAmount());
        } else {
            newSavingsAmount = currentSavings.getAmount().subtract(savings.getAmount());
        }
        Savings newSavingsRecord = new Savings(newSavingsAmount, LocalDateTime.now(),user);
        return this.savingsRepository.save(newSavingsRecord);
    }
}
