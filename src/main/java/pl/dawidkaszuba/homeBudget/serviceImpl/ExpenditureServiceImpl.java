package pl.dawidkaszuba.homeBudget.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dawidkaszuba.homeBudget.entity.Expenditure;
import pl.dawidkaszuba.homeBudget.repository.ExpenditureRepository;
import pl.dawidkaszuba.homeBudget.service.ExpenditureService;

import java.math.BigDecimal;
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
    public Optional<Expenditure> findById(Long userId,Long id) {
        return expenditureRepository.findById(userId,id);
    }

    @Override
    public Expenditure save(Expenditure expenditure) {
        return expenditureRepository.save(expenditure);
    }

    @Override
    public BigDecimal findSumAmountFromTo(String userId,String from, String to) {
        return expenditureRepository.findSumAmountFromTo(userId,from, to);
    }

    @Override
    public List<Expenditure> findAllByTag(String userId, String tagId) {
        return expenditureRepository.findAllByTag(userId,tagId);
    }

    @Override
    public List<Expenditure> findAllByTagFromTo(String userId,String from, String to,String tagId) {
        return expenditureRepository.findAllByTagFromTo(userId,from,to,tagId);
    }


    @Override
    public List<Expenditure> findAllFromTo(String userId,String from,String to) {
        return expenditureRepository.findAllFromTo(userId,from,to);
    }

    @Override
    public void deleteById(Long id) {
        expenditureRepository.deleteById(id);
    }
}
