package pl.dawidkaszuba.homeBudget.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dawidkaszuba.homeBudget.entity.PlannedCashFlow;
import pl.dawidkaszuba.homeBudget.repository.PlannedCashFlowRepository;
import pl.dawidkaszuba.homeBudget.service.PlannedCashFlowService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PlannedCashFlowServiceImpl implements PlannedCashFlowService {

    private final PlannedCashFlowRepository plannedCashFlowRepository;

    @Autowired
    public PlannedCashFlowServiceImpl(PlannedCashFlowRepository plannedExpenditureRepository) {
        this.plannedCashFlowRepository = plannedExpenditureRepository;
    }

    @Override
    public Optional<PlannedCashFlow> findById(Long id) {
        return plannedCashFlowRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        plannedCashFlowRepository.deleteById(id);
    }

    @Override
    public PlannedCashFlow save(PlannedCashFlow plannedCashFlow) {
        return plannedCashFlowRepository.save(plannedCashFlow);
    }

    @Override
    public List<PlannedCashFlow> findAllByUserId(Long userId) {
        return plannedCashFlowRepository.findAllByUserId(userId);
    }

    @Override
    public List<PlannedCashFlow> findAllByUserIdAndStartDateGreaterThanAndEndDateLessThan(Long userId, LocalDate startDateLocalDate, LocalDate endDateLocalDate) {
        return plannedCashFlowRepository.findAllByUserIdAndStartDateGreaterThanAndEndDateLessThan(userId,startDateLocalDate,endDateLocalDate);
    }

}
