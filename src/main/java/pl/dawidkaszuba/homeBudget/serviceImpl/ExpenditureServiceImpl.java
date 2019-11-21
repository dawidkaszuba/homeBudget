package pl.dawidkaszuba.homeBudget.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dawidkaszuba.homeBudget.entity.Expenditure;
import pl.dawidkaszuba.homeBudget.repository.ExpenditureRepository;
import pl.dawidkaszuba.homeBudget.service.ExpenditureService;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenditureServiceImpl implements ExpenditureService {

    private final ExpenditureRepository expenditureRepository;

    @Autowired
    public ExpenditureServiceImpl(ExpenditureRepository expenditureRepository) {
        this.expenditureRepository = expenditureRepository;
    }

    @Override
    public List<Expenditure> findAll() {
        return expenditureRepository.findAll();
    }

    @Override
    public Optional<Expenditure> findById(Long id) {
        return expenditureRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        expenditureRepository.deleteById(id);
    }

    @Override
    public void save(Expenditure expenditure) {
        expenditureRepository.save(expenditure);
    }

    @Override
    public List<Expenditure> findAllForMonthByTag(String month, String tag) {
        return expenditureRepository.findAllForMonthByTag(month,tag);
    }

    @Override
    public List<Expenditure> findAllByTag(String tag) {
        return expenditureRepository.findAllByTag(tag);
    }

    @Override
    public List<Expenditure> findByMonth(String month) {
        return expenditureRepository.findByMonth(month);
    }

    @Override
    public List<Expenditure> findAllFromTo(String from,String to) {
        return expenditureRepository.findAllFromTo(from,to);
    }
}
