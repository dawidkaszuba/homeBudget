package pl.dawidkaszuba.homeBudget.service;

import org.springframework.stereotype.Service;
import pl.dawidkaszuba.homeBudget.entity.PlannedExpenditure;

import java.util.List;
import java.util.Optional;

@Service
public interface PlannedExpenditureService {

    Optional<PlannedExpenditure> findById(Long id);
    void deleteById(Long id);
    PlannedExpenditure save(PlannedExpenditure plannedExpenditure);
    List<PlannedExpenditure> findAllByUserId(Long userId);
}
