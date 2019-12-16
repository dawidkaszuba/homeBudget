package pl.dawidkaszuba.homeBudget.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.dawidkaszuba.homeBudget.entity.PlannedExpenditure;
import pl.dawidkaszuba.homeBudget.repository.PlannedExpenditureRepository;
import pl.dawidkaszuba.homeBudget.service.PlannedExpenditureService;

import java.util.Optional;

public class PlannedExpenditureServiceImpl implements PlannedExpenditureService {


    private final PlannedExpenditureRepository plannedExpenditureRepository;

    @Autowired
    public PlannedExpenditureServiceImpl(PlannedExpenditureRepository plannedExpenditureRepository) {
        this.plannedExpenditureRepository = plannedExpenditureRepository;
    }

    @Override
    public Optional<PlannedExpenditure> findById(Long id) {
        return plannedExpenditureRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        plannedExpenditureRepository.deleteById(id);
    }

    @Override
    public PlannedExpenditure save(PlannedExpenditure plannedExpenditure) {
        return plannedExpenditureRepository.save(plannedExpenditure);
    }

}
