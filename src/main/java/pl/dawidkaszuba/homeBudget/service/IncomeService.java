package pl.dawidkaszuba.homeBudget.service;

import org.springframework.stereotype.Service;
import pl.dawidkaszuba.homeBudget.entity.Income;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface IncomeService {

    List<Income> findAll();
    Optional<Income> findById(Long id);
    void deleteById(Long id);
    Income save(Income income);

    BigDecimal findSumAmountFromTo(String userId,String from, String to);

    List<Income> findAllByUserId(Long userId);

    List<Income> findAllByUserIdAndIncomeDateBetween(Long userId, LocalDate from, LocalDate to);
}

