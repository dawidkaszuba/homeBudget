package pl.dawidkaszuba.homeBudget.service;

import org.springframework.stereotype.Service;
import pl.dawidkaszuba.homeBudget.entity.Expenditure;

import java.util.List;
import java.util.Optional;

@Service
public interface ExpenditureService {

    List<Expenditure> findAll();
    Optional<Expenditure> findById(Long id);
    void deleteById(Long id);
    void save(Expenditure expenditure);

    List<Expenditure> findAllFromTo(String from, String to);
}
