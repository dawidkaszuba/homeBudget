package pl.dawidkaszuba.homeBudget.service;

import org.springframework.stereotype.Service;
import pl.dawidkaszuba.homeBudget.entity.PlannedCashFlow;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public interface PlannedCashFlowService {

    Optional<PlannedCashFlow> findById(Long id);

    void deleteById(Long id);

    PlannedCashFlow save(PlannedCashFlow plannedCashFlow);


    List<PlannedCashFlow> findAllByUserId(Long userId);

    List<PlannedCashFlow> findAllByUserIdAndStartDateGreaterThanAndEndDateLessThan(Long userId,LocalDate startDate, LocalDate endDate);
}
