package pl.dawidkaszuba.homeBudget.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dawidkaszuba.homeBudget.entity.Income;
import pl.dawidkaszuba.homeBudget.repository.IncomeRepository;
import pl.dawidkaszuba.homeBudget.service.IncomeService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;

    @Autowired
    public IncomeServiceImpl(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    @Override
    public List<Income> findAll() {
        return incomeRepository.findAll();
    }

    @Override
    public Optional<Income> findById(Long id) {
        return incomeRepository.findById(id);
    }

    @Override
    public List<Income> findAllByUserIdAndIncomeDateBetween(Long userId,LocalDate from, LocalDate to) {
        return incomeRepository.findAllByUserIdAndIncomeDateBetween(userId,from,to);
    }

    @Override
    public List<Income> findAllByUserId(Long userId) {
        return incomeRepository.findAllByUserId(userId);
    }

    @Override
    public void deleteById(Long id) {
        incomeRepository.deleteById(id);
    }


    @Override
    public BigDecimal findSumAmountFromTo(String userId,String from, String to) {
        return incomeRepository.findSumAmountFromTo(userId,from, to);
    }

    @Override
    public Income save(Income income) {
        incomeRepository.save(income);
        return incomeRepository.save(income);
    }
}
