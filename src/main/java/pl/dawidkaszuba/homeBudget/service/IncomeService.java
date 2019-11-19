package pl.dawidkaszuba.homeBudget.service;

import org.springframework.stereotype.Service;
import pl.dawidkaszuba.homeBudget.entity.Income;

import java.util.List;
import java.util.Optional;

@Service
public interface IncomeService {

    List<Income> findAll();
    Optional<Income> findById(Long id);
    void deleteById(Long id);
    void save(Income income);
}
